package com.KoreaIT.java.Jsp_AM.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.config.Config;
import com.KoreaIT.java.Jsp_AM.dto.Member;
import com.KoreaIT.java.Jsp_AM.exception.SQLErrorException;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

public class MemberDAO {
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

	public int insert(Member member) {
		connectConnection();
		SecSql sql = SecSql.from("INSERT INTO `member`");
		sql.append("SET regDate = NOW(),");
		sql.append("loginId = ?,", member.getLoginId());
		sql.append("loginPw = ?,", member.getLoginPw());
		sql.append("`name` = ?;", member.getName());
		closeConnection();
		return DBUtil.insert(conn, sql);
	}
	
	public Optional<Member> findOneByLoginId(String loginId) {
		connectConnection();
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?;", loginId);

		Map<String, Object> memberRow = DBUtil.selectRow(conn, sql);
		if(memberRow.isEmpty()) {
			return Optional.empty();
		}
		closeConnection();
		return Optional.of(new Member(memberRow)); 
	}
	
	

}
