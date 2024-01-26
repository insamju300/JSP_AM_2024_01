package com.KoreaIT.java.Jsp_AM.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.config.Config;
import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.exception.SQLErrorException;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

public class ArticleDAO {
	private Connection conn = null;

	{
		try {
			Class.forName(Config.getDbDriverClassName());
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 없습니다.");
			e.printStackTrace();
		}

	}

	private void connectConnection() {
		try {
			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} catch (SQLErrorException e) {
			e.getOrigin().printStackTrace();
		}

	}

	private void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		connectConnection();
		SecSql sql = SecSql.from("DELETE");
		sql.append("FROM article");
		sql.append("WHERE id = ?;", id);

		DBUtil.delete(conn, sql);
		closeConnection();
	}

	public Optional<Article> findOneById(int id) {
		connectConnection();
		SecSql sql = SecSql.from("SELECT article.*, `member`.`name` as writer");
		sql.append("FROM article INNER JOIN `member` ON article.memberId = `member`.id");
		sql.append("WHERE article.id = ?;", id);

		Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
		if (articleRow == null) {
			return null;
		}

		closeConnection();
		return Optional.of(new Article(articleRow));

	}

	public void update(Article article) {
		connectConnection();
		SecSql sql = SecSql.from("UPDATE article");
		sql.append("SET ");
		sql.append("title = ?,", article.getTitle());
		sql.append("`body` = ?", article.getBody());
		sql.append("WHERE id = ?;", article.getId());

		DBUtil.update(conn, sql);
		closeConnection();
	}
	
	public List<Article> findAll(int limitFrom, int itemsInAPage){
		connectConnection();
		List<Article> result = new ArrayList<>();
		SecSql sql = SecSql.from("SELECT article.*, `member`.`name` as writer");
		sql.append("FROM article INNER JOIN `member` ON article.memberId = `member`.id");
		sql.append("ORDER BY id DESC");
		sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);

		DBUtil.selectRows(conn, sql).forEach(a->result.add(new Article(a)));;
		
		closeConnection();
		return result;
	}
	
	public int insert(Article article) {
		connectConnection();
		
		SecSql sql = SecSql.from("INSERT INTO article");
		sql.append("SET regDate = NOW(),");
		sql.append("title = ?,", article.getTitle());
		sql.append("`body` = ?, ", article.getBody());
		sql.append("`memberId` = ? ", article.getMemberId());

		int id = DBUtil.insert(conn, sql);
		closeConnection();
		return id;
		
	}

	public int getTotalCnt() {
		connectConnection();
		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
		sql.append("FROM article");

		int totalCnt = DBUtil.selectRowIntValue(conn, sql);
		closeConnection();
		return totalCnt;
	}
	
	

}
