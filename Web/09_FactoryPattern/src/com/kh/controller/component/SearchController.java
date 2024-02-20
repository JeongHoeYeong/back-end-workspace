package com.kh.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();

		Member member = dao.searchMember(id);

		if (member != null) {
			request.setAttribute("member", member);
		}
		return member != null ? new ModelAndView("views/find_ok.jsp") : 
			new ModelAndView("views/find_fail.jsp", true);
	}

}
