package dao;

import domain.PatientBean;

public interface PatientDAO {
	public int insert(PatientBean member) throws Exception;  //이름은 Quary 문으로 해줘라.
	public PatientBean selectById(String id) throws Exception; 
	/*public boolean login(PatientBean member) throws Exception;*/
	public int update(PatientBean member) throws Exception; 
	public int delete(PatientBean member) throws Exception; 
}
