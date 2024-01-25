package com.KoreaIT.java.Jsp_AM.service;

import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dao.ArticleDAO;
import com.KoreaIT.java.Jsp_AM.dto.Article;

public class ArticleService {
	ArticleDAO dao = new ArticleDAO();
	

	public Optional<Article> findArticleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
