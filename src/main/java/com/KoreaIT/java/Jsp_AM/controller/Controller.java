package com.KoreaIT.java.Jsp_AM.controller;

import java.util.Map;

import jakarta.servlet.http.HttpSession;

public interface Controller {
	abstract String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session);
}
