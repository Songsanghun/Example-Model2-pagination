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

	public void setView(){
		System.out.println("=========================디렉토리=======================: "+directory);
		if(directory.equals("/home")){
			this.view = "/WEB-INF/jsp/common/"+this.page+".jsp";
		}else{
			this.view = "/WEB-INF/jsp"+this.directory+"/"+this.page+"jsp";
		}
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
	
}
