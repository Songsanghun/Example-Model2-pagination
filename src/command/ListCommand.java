package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class ListCommand extends Command implements CommandHandler{
	public ListCommand(String directory, String action, String page, String pageNO) {
		super.directory = directory;
		super.action = action;
		super.page = page;
		super.pageNO = pageNO;
		super.setView();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	}
	
}