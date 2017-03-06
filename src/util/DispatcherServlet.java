package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet {
	public static void send(HttpServletRequest request, 
							HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher(Separator.command.getView()).forward(request, response);
	}
}