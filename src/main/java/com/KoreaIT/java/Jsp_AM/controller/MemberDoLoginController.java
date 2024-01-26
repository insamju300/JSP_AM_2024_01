package com.KoreaIT.java.Jsp_AM.controller;

import java.util.Map;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dto.Member;
import com.KoreaIT.java.Jsp_AM.service.MemberService;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DoLoginServlet
 */
//@WebServlet("/member/doLogin")
public class MemberDoLoginController implements Controller {
	
	MemberService service = new MemberService();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		// TODO Auto-generated method stub
		String loginId = paramMap.get("loginId");
		String loginPw = paramMap.get("loginPw");
		
		Optional<Member> memberOpt = service.findMemberByLoginId(loginId);
		if(memberOpt.isEmpty()) {
			return "<script>alert('해당 id가 존재하지 않습니다.'); location.replace('login');</script>";
		}
		
		Member findMember = memberOpt.get();
		if(!findMember.getLoginPw().equals(loginPw.trim())) {
			return "<script>alert('패스워드가 일치하지 않습니다.'); location.replace('login');</script>";
		}
		
		session.setMaxInactiveInterval(2*60*60);
		session.setAttribute("loginMember", findMember);
		
		String redirectPath = "../home/main";
		//System.out.println(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
		if(paramMap.get("redirectPath")!=null && redirectPath.length()>0) {
			redirectPath = paramMap.get("redirectPath");
		}
		
		//System.out.println(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
		
		return String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
//		
//		String loginId = request.getParameter("loginId");
//		String loginPw = request.getParameter("loginPw");
//		
//		Optional<Member> memberOpt = service.findMemberByLoginId(loginId);
//		if(memberOpt.isEmpty()) {
//			response.getWriter()
//			.append(String.format("<script>alert('해당 id가 존재하지 않습니다.'); location.replace('login');</script>"));
//			return;
//		}
//		
//		Member findMember = memberOpt.get();
//		if(!findMember.getLoginPw().equals(loginPw.trim())) {
//			response.getWriter()
//			.append(String.format("<script>alert('패스워드가 일치하지 않습니다.'); location.replace('login');</script>"));
//			return;
//		}
//		
//		HttpSession session = request.getSession();
//		session.setMaxInactiveInterval(2*60*60);
//		session.setAttribute("loginMember", findMember);
//		
//		String redirectPath = "../home/main";
//		System.out.println(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
//		if(request.getParameter("redirectPath")!=null && redirectPath.length()>0) {
//			redirectPath = request.getParameter("redirectPath");
//		}
//		
//		System.out.println(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
//		
//		response.getWriter().write(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
//		
//		
//		// DB연결
////		try {
////			Class.forName(Config.getDbDriverClassName());
////		} catch (ClassNotFoundException e) {
////			System.out.println("클래스가 없습니다.");
////			e.printStackTrace();
////		}
////
////		Connection conn = null;
////
////		try {
////			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
////			//response.getWriter().append("연결 성공!");
////
////			String loginId = request.getParameter("loginId");
////			String loginPw = request.getParameter("loginPw");
////			
////			
////
////			SecSql sql = SecSql.from("SELECT *");
////			sql.append("FROM `member`");
////			sql.append("WHERE loginId = ?;", loginId);
////
////			Map<String, Object> memberRow = DBUtil.selectRow(conn, sql);
////			if(memberRow.isEmpty()) {
////				response.getWriter()
////				.append(String.format("<script>alert('해당 id가 존재하지 않습니다.'); location.replace('login');</script>"));
////				return;
////			}
////			
////
////			
////			Member findMember = new Member(memberRow);
////			if(!findMember.getLoginPw().equals(loginPw.trim())) {
////				response.getWriter()
////				.append(String.format("<script>alert('패스워드가 일치하지 않습니다.'); location.replace('login');</script>"));
////				return;
////			}
////			
////			HttpSession session = request.getSession();
////			session.setMaxInactiveInterval(2*60*60);
////			session.setAttribute("loginMember", findMember);
////			
////			String redirectPath = "../home/main";
////			System.out.println(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
////			if(request.getParameter("redirectPath")!=null && redirectPath.length()>0) {
////				redirectPath = request.getParameter("redirectPath");
////			}
////			
////			System.out.println(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
////			
////			response.getWriter().write(String.format("<script>alert('%s님 환영합니다.');location.href = '%s';</script>", findMember.getName(), redirectPath));
////			
////
////		} catch (SQLException e) {
////			System.out.println("에러 : " + e);
////		} catch (SQLErrorException e) {
////			e.getOrigin().printStackTrace();
////		} finally {
////			try {
////				if (conn != null && !conn.isClosed()) {
////					conn.close();
////				}
////			} catch (SQLException e) {
////				e.printStackTrace();
////			}
////		}
//	}



}
