package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

public class MoveCommand extends Command implements CommandHandler {
	public MoveCommand(String directory, String action, String page) {
		this.directory = directory;
		this.action = action;
		this.page = page;
		this.setView();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}