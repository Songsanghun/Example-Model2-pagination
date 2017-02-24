package service;

import domain.PatientBean;

public interface PatientService {
	// DAO 값을 토스해주는 로직
	public int join(PatientBean member) throws Exception;  //regist해라 PatientBean 을
	public PatientBean findById(String id) throws Exception; // PatientBean 에서 find 해라 String id를 
	public PatientBean login(PatientBean member) throws Exception; // login해라 Member member을 참 거짓 구별.
	public boolean logout(PatientBean member) throws Exception; 
	public int change(PatientBean member) throws Exception; //change해라 PatientBean을
	public int remove(PatientBean member) throws Exception; //remove해라 PatientBean을
	// 추가된 로직
	public String getBirth(String ssn);
	public PatientBean getSession();
}
