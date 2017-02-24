package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.PatientBean;
import service.PatientService;
import serviceImpl.PatientServiceImpl;
import util.DispathcherServlet;
import util.Separator;

@WebServlet("/patient.do")  
public class PatientController extends HttpServlet {    
	private static final long serialVersionUID = 1L;//마셜링 유니크한 값(id)을 가지고 있다.
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();   
		
		PatientService service = PatientServiceImpl.getInstance();
		PatientBean bean = new PatientBean();

		Separator.init(request, response);
		//System.out.println(); = Separator.command.getAction();   same syntax이다.
		switch (Separator.command.getAction()) {
		case "move":
			DispathcherServlet.send(request, response);
			break;
		case "mypage": 
			System.out.println("==마이페이지 진입== ");
			System.out.println("마이페이지 진입후 세션 아이디"+service.getSession().getPatID());
				String birth = service.getBirth(service.getSession().getPatJumin());
				System.out.println("생년월일 : "+birth);
				request.setAttribute("birth", birth);
				DispathcherServlet.send(request, response);
			
			
			break;
		case "login":
			String pw = request.getParameter("password");
			System.out.println("DB 가기전 비번: "+pw);
			bean.setPatID(request.getParameter("id"));
			try {
				PatientBean temp = service.login(bean);
				System.out.println("DB 다녀온 후 아이디"+temp.getPatID());
				System.out.println("DB 다녀온 후 비번"+temp.getPatPass());
				System.out.println("DB 다녀온 후 주번"+temp.getPatJumin());
				if(!temp.getPatID().equals("FAIL") && temp.getPatPass().equals(pw)){
					System.out.println("=========로그인성공===========");
					session.setAttribute("user", temp);
					System.out.println("로그인 성공후 세션 아이디"+service.getSession().getPatID());
					DispathcherServlet.send(request, response);
				}else{
					
					System.out.println("=========로그인실패===========");
					Separator.command.setPage("loginForm");
					System.out.println("가는 페이지"+Separator.command.getPage());
					Separator.command.setView();
					DispathcherServlet.send(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	
}
