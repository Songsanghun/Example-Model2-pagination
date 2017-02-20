package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/patient/loginForm.do","/patient/registForm.do","/admin/loginForm.do"})   // Membercontroller 는 URL로 바뀐다. 입구 @WebServlet = 톰켓을 의미한다. 배열 선언하면 2개 쓸수있다.
//    /patient directory  폴더를 디렉토리라고 한다. 
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;//마셜링 유니크한 값(id)을 가지고 있다.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========================servlert=========================");
		String path = request.getServletPath();
		System.out.println("리퀘스트객체가 걸어온길 : "+path);
		this.doPatient(path, request, response);
	}
	protected void doPatient(String path,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String patPath = "WEB-INF/jsp/patient/";
		String extension = ".jsp";
		String cmd="";
		switch (cmd) {
		case "login": 
			request.getRequestDispatcher(patPath+"loginForm"+extension).forward(request, response);
			break;
			
		case "regist":
			request.getRequestDispatcher(patPath+"registerForm"+extension).forward(request, response);
			break;

		default:
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
