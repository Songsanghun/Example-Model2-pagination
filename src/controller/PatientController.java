package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DispathcherServlet;
import util.Separator;

@WebServlet("/patient.do")  
public class PatientController extends HttpServlet {    
	private static final long serialVersionUID = 1L;//마셜링 유니크한 값(id)을 가지고 있다.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Separator.init(request, response);
		//System.out.println("aaaaaa"); 18번 라인과 같은 뜻
		switch (Separator.command.getAction()) {
		case "move":
			DispathcherServlet.send(request, response, Separator.command);
			break;
		default:
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
