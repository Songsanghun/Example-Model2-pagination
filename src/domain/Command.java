package domain;

import handler.CommandHandler;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class Command implements CommandHandler{
	@Getter @Setter
	private String directory, action, page;
	@Getter
	private String view;
	
	public Command(String directory, String action, String page) {
		this.directory = directory;
		this.action = action;
		this.page = page;
		this.setView();
	}

	@Override
	public Command process() {
		Command cmd =null;
		switch(action){
		case"move":
			cmd= new Command(directory, action, page);
			break;
		}
		return cmd;
	}
	public void setView(){
		this.view="/WEB-INF/jsp"+this.directory+"/"+this.page+".jsp";
	}
	
}
