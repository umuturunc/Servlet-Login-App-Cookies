package com.umut;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final String SUCCESS_MESSAGE="Login success";
    private static final String FAIL_MESSAGE="Please use correct credentials to login successfully";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username + password);
		
		PrintWriter writer = response.getWriter();
		
		if(isNotNullAndNotEmpty(username) & isNotNullAndNotEmpty(password)){
			Cookie cookie = new Cookie("token","43213214325");
			response.addCookie(new Cookie("token","43213214325"));
			writer.println(SUCCESS_MESSAGE);
			return;
		}
		
		writer.println(FAIL_MESSAGE);
	}
	
	protected static boolean isNotNullAndNotEmpty(String text) {
		return text != null && !text.isEmpty();
	}

}
