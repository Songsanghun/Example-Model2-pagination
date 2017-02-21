package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Command;
import factory.CommandFactory;

public class Separator {
	public static Command command;
	public static void init(HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletPath();
		System.out.println("======="+path);
		String directory = path.substring(0,path.indexOf("."));
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		command = CommandFactory.createCommand(directory, action, page);
	}
}
