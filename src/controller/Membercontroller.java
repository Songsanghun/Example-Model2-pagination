package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")   // Membercontroller 는 URL로 바뀐다.
public class Membercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;//마셜링 유니크한 값(id)을 가지고 있다.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========================servlert=========================");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/customer/patLoginForm.jsp");
				rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
