package domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DoctorBean {
	
	@Getter @Setter
	private String docID,docPass,majorTreat,docName,docGen,docPhone,docEmail,docPosition;
	
}