package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import factory.CommandFactory;

public class Separator {
	public static CommandFactory factory = new CommandFactory();
	public static Command command;
	public static void init(HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletPath();
		System.out.println("==========="+path);
		String directory = path.substring(0,path.indexOf("."));
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		String pageNO = request.getParameter("pageNO");
		System.out.println("Sparator PATH : "+path);
		System.out.println("Sparator DIR : "+directory);
		System.out.println("Sparator ACTION : "+action);
		System.out.println("Sparator PAGE : " +page);
		System.out.println("Sparator PAGE : " +pageNO);
		if (pageNO==null) {
			command = CommandFactory.createCommand(directory, action, page);
		}else{
			command = CommandFactory.createCommand(directory, action, page, pageNO);
		}
	}
}
