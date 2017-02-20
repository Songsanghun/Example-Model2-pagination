package serviceImpl;

import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService{
		private PatientBean session;
	public static PatientServiceImpl getInstance() {
		return new PatientServiceImpl();
	}
	public PatientServiceImpl() {
		session = new PatientBean();
	}

	@Override
	public int join(PatientBean patient) throws Exception {
		return PatientDAOImpl.getInstance().insert(patient);
	}

	@Override
	public PatientBean findById(String id) throws Exception {
		return PatientDAOImpl.getInstance().selectById(id);
	}

	@Override
	public boolean login(PatientBean patient) throws Exception{
		boolean check = false;
		PatientBean temp = this.findById(patient.getPatID());
		if(patient.getPatPass().equals(temp.getPatPass())){
			session=temp;
			check = true;
		}
		return check;
	}

	@Override
	public int change(PatientBean patient) throws Exception{
		return PatientDAOImpl.getInstance().update(patient);
		
	}

	@Override
	public int remove(PatientBean patient) throws Exception {
		return PatientDAOImpl.getInstance().delete(patient);
		
	}
	@Override
	public boolean logout(PatientBean patient) throws Exception {
		session=null;
		return true;
	}
	
}
