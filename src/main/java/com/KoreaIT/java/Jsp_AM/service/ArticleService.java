package com.KoreaIT.java.Jsp_AM.service;

import java.util.List;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dao.ArticleDAO;
import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.dto.Page;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

public class ArticleService {
	ArticleDAO dao = new ArticleDAO();
	

	public Optional<Article> findArticleById(int id) {
		// TODO Auto-generated method stub
		return dao.findOneById(id);
	}


	public void delete(int id) {
		dao.delete(id);
		
	}


	public void update(Article article) {
		dao.update(article);
		
	}


	public int insert(Article article) {
		// TODO Auto-generated method stub
		return dao.insert(article);
	}


	public Page getPageNation(int page) {
		int itemsInAPage = 10;
		int limitFrom = (page - 1) * itemsInAPage;
		int totalCnt =dao.getTotalCnt();
		int totalPage = (int) Math.ceil(totalCnt / (double) itemsInAPage);
		return new Page(page, totalCnt, totalPage, itemsInAPage, limitFrom);
	}





	public List<Article> findArticles(int limitFrom, int itemsInAPage) {
		// TODO Auto-generated method stub
		return dao.findAll(limitFrom, itemsInAPage);
	}




}
