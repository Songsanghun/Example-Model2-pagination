package factory;

import command.Command;
import command.ListCommand;
import command.MoveCommand;

public class CommandFactory {
	public static Command createCommand(String directory, String action, String page){
		return new MoveCommand(directory, action, page);
	}
	public static Command createCommand(String directory, String action, String page, String pageNO){
		Command cmd = null;
		switch(action){
		case "list":
			cmd = new ListCommand(directory, action, page, pageNO);
			break;
		default: break;
		}
		return cmd;
		
	}
}