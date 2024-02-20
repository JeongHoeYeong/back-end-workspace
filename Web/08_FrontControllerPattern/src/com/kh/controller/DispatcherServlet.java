package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청이 어디에서 들어오는 요청인지 구분할 command 값 같이 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";
		try {
			if (command.equals("register")) {
				path = register(request, response); // index.jsp
			} else if (command.equals("login")) {
				path = login(request, response);
			} else if (command.equals("search")) {
				path = search(request, response);
			} else if (command.equals("allShow")) {
				path = allShow(request, response);
			} else if (command.equals("logout")) {
				path = logout(request, response);
			}
		} catch (SQLException e) {
		}
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		Member member = new Member(id, password, name);
		MemberDAO dao = new MemberDAO();
		dao.registerMember(member);

		return "index.jsp";
	}

	protected String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		Member member = null;

		MemberDAO dao = new MemberDAO();
		member = dao.loginMember(id, password);
		HttpSession session = request.getSession();
		session.setAttribute("info", member);
		return "views/login_result.jsp";
	}

	protected String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();

		Member member = dao.searchMember(id);

		if (member != null)
			request.setAttribute("member", member);
		return member != null ? "views/find_ok.jsp" : "views/find_fail.jsp";
	}

	protected String allShow(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		list = dao.allShowMember();
		request.setAttribute("list", list);
		return "views/allShow.jsp";
	}

	protected String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("info");
		if (member != null) {
			session.invalidate();
		}
		return "index.jsp";
	}

}
