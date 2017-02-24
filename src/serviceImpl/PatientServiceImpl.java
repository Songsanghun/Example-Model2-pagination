package serviceImpl;

import dao.PatientDAO;
import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService{
		private static PatientBean session=new PatientBean();
		private PatientDAO dao;
	public static PatientServiceImpl getInstance() {
		return new PatientServiceImpl();
	}
	
	private PatientServiceImpl() {
		dao=PatientDAOImpl.getInstance();
	}
	public PatientBean getSession(){
		System.out.println("세션에 있는 ID값"+session.getPatID());
		System.out.println("세션에 있는 SSN값"+session.getPatJumin());
		return session;
	}


	@Override
	public int join(PatientBean patient) throws Exception {
		return dao.insert(patient);
	}

	@Override
	public PatientBean findById(String id) throws Exception {
		return dao.selectById(id);
	}

	@Override
	public PatientBean login(PatientBean patient) throws Exception{
		session = this.findById(patient.getPatID());
		System.out.println("===로그인===\n"+session.getPatJumin());
		return session;
	}

	@Override
	public int change(PatientBean patient) throws Exception{
		return dao.update(patient);
		
	}

	@Override
	public int remove(PatientBean patient) throws Exception {
		return dao.delete(patient);
		
	}
	@Override
	public boolean logout(PatientBean patient) throws Exception {
		return true;
	}
	@Override
	public String getBirth(String ssn) {
		System.out.println("###getBirth() 진입###\n SSN="+ssn);
		String brith ="";
		if(ssn.equals("")){
			System.out.println("널입니다.===");
		}else{
			System.out.println("널 아닙니다.===");
		}
		brith="19"+ssn.substring(0,2)+"년 "
		+ssn.substring(2,4)+
		"월 "+ssn.substring(4,6)+
		"일 ";
		return brith;
	}
	
}
