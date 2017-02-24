package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispathcherServlet {
	public static void send(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("최종적 페이지:" +Separator.command.getView() );
		request.getRequestDispatcher(Separator.command.getView()).forward(request, response);
	}
}
