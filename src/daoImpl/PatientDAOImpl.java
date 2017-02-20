package daoImpl;

import java.sql.*;
import constants.Database;
import dao.PatientDAO;
import domain.PatientBean;
import factory.DatabaseFactory;
import enums.Vendor;

public class PatientDAOImpl implements PatientDAO {
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
		ResultSet set = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				.getConnection().createStatement()
				.executeQuery(String.format("SELECT id,name,ssn,password,profileImg,phone,email,rank \n "
						+ "FROM Member WHERE id='%s'", id));
		if (set.next()) {
			
		}
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