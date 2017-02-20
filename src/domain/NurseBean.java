package domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NurseBean {
	
	@Getter @Setter
	private String nurID,nurPass,majorJob,nurName,nurGen,nurPhone,nurEmail,nurPosition;
}
