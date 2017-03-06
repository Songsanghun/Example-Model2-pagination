package controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.PatientBean;
import service.PatientService;
import serviceImpl.PatientServiceImpl;
import util.DispatcherServlet;
import util.ParamMap;
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
			DispatcherServlet.send(request, response);
			break;
		case "mypage": 
			System.out.println("==마이페이지 진입== ");
			System.out.println("마이페이지 진입후 세션 아이디"+service.getSession().getPatID());
				String birth = service.getBirth(service.getSession().getPatJumin());
				System.out.println("생년월일 : "+birth);
				request.setAttribute("birth", birth);
				DispatcherServlet.send(request, response);
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
					DispatcherServlet.send(request, response);
				}else{
					System.out.println("=========로그인실패===========");
					Separator.command.setPage("loginForm");
					System.out.println("가는 페이지"+Separator.command.getPage());
					Separator.command.setView();
					DispatcherServlet.send(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "register": 
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			String email= request.getParameter("email");
			String password = request.getParameter("password");
			String mBirth = request.getParameter("birth");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			String telecom = request.getParameter("telecom");
			String phoneNo1 = request.getParameter("phoneNo1");
			String phoneNo2 = request.getParameter("phoneNo2");
			String phoneNo3 = request.getParameter("phoneNo3");
			String gender = request.getParameter("gender");
			String job = ParamMap.getValues(request, "job");
			
			ArrayList<String> list = new ArrayList<>();
			list.add(id);
			list.add(email);
			list.add(password);
			list.add(mBirth);
			list.add(month);
			list.add(date);
			list.add(telecom);
			list.add(phoneNo1);
			list.add(phoneNo2);
			list.add(phoneNo3);
			list.add(gender);
			list.add(job);
			System.out.println(list);
			String patJumin = "";
		
			bean.setPatID(id);
			bean.setPatGen(gender);
			bean.setPatAddr(addr);
			bean.setPatEmail(email);
			bean.setPatJob(job);
			bean.setPatJumin(patJumin);
			bean.setPatName(name);
			bean.setPatPass(password);
			bean.setPatPhone(phoneNo1+"-"+phoneNo2+"-"+phoneNo3);
			try {
				if(service.join(bean)==1){
					System.out.println("=========회원가입 성공===========");
					DispatcherServlet.send(request, response);
				}else{
					System.out.println("=========회원 가입 실패===========");
					Separator.command.setPage("registerForm");
					System.out.println("가는 페이지"+Separator.command.getPage());
					Separator.command.setView();
					DispatcherServlet.send(request, response);
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
