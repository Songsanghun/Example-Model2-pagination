package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Command;
import factory.CommandFactory;

public class Separator {
	public static CommandFactory factory = new CommandFactory();
	public static Command command;
	public static void init(HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletPath();
		String directory = path.substring(0,path.indexOf("."));
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		command = factory.createCommand(directory, action, page);
	}
}
