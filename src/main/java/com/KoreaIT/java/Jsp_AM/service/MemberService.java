package com.KoreaIT.java.Jsp_AM.service;

import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dao.MemberDAO;
import com.KoreaIT.java.Jsp_AM.dto.Member;

public class MemberService {
	MemberDAO dao = new MemberDAO();

	public int insert(Member member) {
		// TODO Auto-generated method stub
		return dao.insert(member);
	}

	public Optional<Member> findMemberByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return dao.findOneByLoginId(loginId);
	}

}
