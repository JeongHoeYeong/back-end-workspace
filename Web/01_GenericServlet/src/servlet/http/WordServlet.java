package servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("word");
		System.out.println("Client Send data : " + word);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>");
		out.println("Client Send Data : " + word);
		out.println("</h1></body></html>");
		out.close();
	}
}
