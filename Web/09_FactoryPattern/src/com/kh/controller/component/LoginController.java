package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		Member member = null;

		MemberDAO dao = new MemberDAO();
		member = dao.loginMember(id, password);
		HttpSession session = request.getSession();
		session.setAttribute("info", member);
		return new ModelAndView("views/login_result.jsp", true);
	}

}
