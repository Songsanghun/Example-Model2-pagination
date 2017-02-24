package daoImpl;

import java.sql.*;
import constants.Database;
import dao.PatientDAO;
import domain.PatientBean;
import factory.DatabaseFactory;
import enums.Vendor;

public class PatientDAOImpl implements PatientDAO {
	final String prop="pat_id,nur_id,doc_id,pat_pass,pat_name,pat_gen,pat_jumin,pat_addr,pat_phone,pat_email,pat_job";
	private static PatientDAOImpl instance = new PatientDAOImpl(); 	// RAM instance한개 생성하고 만다.  
	public static PatientDAOImpl getInstance() {                     // >>>singleton pattern
		return instance;
	}
	@Override
	public int insert(PatientBean member) throws Exception { // throws Exception
																// 에러 나면 메소드 꺼라
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection()
				.createStatement()
				.executeUpdate("");
	}

	@Override
	public PatientBean selectById(String id) throws Exception {
		PatientBean member = new PatientBean();
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				.getConnection().createStatement()
				.executeQuery("SELECT "+prop+ " FROM Patient WHERE pat_id='"+id+"'");
		if (rs.next()) {
//			patID,nurID,docID,patPass,patName,patGen,patJumin,patAddr,patPhon,patEmail,patJob
			member.setPatID(rs.getString("pat_id"));
			member.setNurID(rs.getString("nur_id"));
			member.setDocID(rs.getString("doc_id"));
			member.setPatPass(rs.getString("pat_pass"));
			member.setPatName(rs.getString("pat_name"));
			member.setPatGen(rs.getString("pat_gen"));
			member.setPatJumin(rs.getString("pat_jumin"));
			member.setPatAddr(rs.getString("pat_addr"));
			member.setPatPhone(rs.getString("pat_phone"));
			member.setPatEmail(rs.getString("pat_email"));
			member.setPatJob(rs.getString("pat_job"));
		}else{
			member.setPatID("FAIL");
		}
		System.out.println("###DAO 주민번호###"+member.getPatJumin());
		return member;
	}

	/*@Override
	public boolean login(PatientBean member) throws Exception {
		boolean check = false;
		PatientBean temp = selectById(member.getId());
		if(temp.getPassword().equals(member.getPassword())) {
			check = true;
		}
		String sql = String.format("SELECT id,name,ssn,password,profileImg,phone,email,rank \n FROM Member WHERE id='%s' and password= '%s'", 
				member.getId(),member.getPassword());
		ResultSet set = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				.getConnection().createStatement()
				.executeQuery(sql);
		return check;
	}*/

	@Override
	public int update(PatientBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection()
				.createStatement().executeUpdate("");
		
	}

	@Override
	public int delete(PatientBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection()
				.createStatement().executeUpdate("");
	}
}