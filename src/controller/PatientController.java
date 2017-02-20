package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.p;


@WebServlet({"/patient/loginForm.do","/patient/registerForm.do","/admin/loginForm.do"})   // URL.  입구 @WebServlet = 톰켓을 의미한다. 배열 선언하면 2개 쓸수있다.
//    /patient directory  폴더를 디렉토리라고 한다. 
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;//마셜링 유니크한 값(id)을 가지고 있다.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action[] = getAction(request.getServletPath());
		switch (action[1]) {
		case "loginForm": 
			request.getRequestDispatcher(action[0]+action[1]+action[2]).forward(request, response);
			break;
			
		case "registerForm":
			request.getRequestDispatcher(action[0]+action[1]+action[2]).forward(request, response);
			break;

		default:
			break;
		}
	}
	protected String[] getAction(String path) throws ServletException, IOException{
		String[] action=new String[3];
		String[] arr=path.split("\\.")[0].split("/");
		//split 으로 patient, loginForm 을 분리시켜서 아래에 담으세요.
		
		action[0] = "/WEB-INF/jsp/"+arr[1]+"/"; //patient
		action[1] = arr[2]; //loginForm
		action[2] = ".jsp";
		
		return action;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
