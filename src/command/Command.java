package command;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
public class Command{
	@Getter @Setter
	protected String directory, action, page, pageNO;
	@Getter
	protected String view;
	public Command(){}
	public Command(String directory, String action, String page){
		this.directory = directory;
		this.action = action;
		this.page = page;
		this.setView();
	}
	
	public void setView(){
		System.out.println("VIEW : "+"/WEB-INF/jsp" + this.directory+"/"+this.page+".jsp");
		this.view=(directory.equals("/home"))?"/WEB-INF/jsp/common/"+this.page+".jsp"
											 :"/WEB-INF/jsp" + this.directory+"/"+this.page+".jsp";
	}
}