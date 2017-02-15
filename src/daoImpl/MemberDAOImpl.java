package daoImpl;

import java.sql.*;
import constants.Database;
import dao.MemberDAO;
import domain.MemberBean;
import factory.DatabaseFactory;
import enums.Vendor;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance = new MemberDAOImpl(); 	// RAM instance한개 생성하고 만다.  
	public static MemberDAOImpl getInstance() {                     // >>>singleton pattern
		return instance;
	}
	@Override
	public int insert(MemberBean member) throws Exception { // throws Exception
																// 에러 나면 메소드 꺼라
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection()
				.createStatement()
				.executeUpdate(String.format(
						"INSERT INTO Member(id,name,ssn,password,profileImg,phone,email,rank)"
								+ "VALUES ('%s','%s','%s','%s','%s','%s,'%s','%s')",
						member.getId(), member.getName(), member.getSsn(), member.getPassword(), member.getProfileImg(),
						member.getPhone(), member.getEmail(), member.getRank()));
	}

	@Override
	public MemberBean selectById(String id) throws Exception {
		MemberBean member = new MemberBean();
		ResultSet set = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				.getConnection().createStatement()
				.executeQuery(String.format("SELECT id,name,ssn,password,profileImg,phone,email,rank \n "
						+ "FROM Member WHERE id='%s'", id));
		if (set.next()) {
			member.setId(set.getString("id"));
			member.setName(set.getString("name"));
			member.setSsn(set.getString("ssn"));
			member.setPassword(set.getString("password"));
			member.setProfileImg(set.getString("phone"));
			member.setEmail(set.getString("email"));
			member.setRank(set.getString("rank"));
		}
		return member;
	}

	/*@Override
	public boolean login(MemberBean member) throws Exception {
		boolean check = false;
		MemberBean temp = selectById(member.getId());
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
	public int update(MemberBean member) throws Exception {
		String result = "";
		String result1 = "";
		String result2 = "";
		String result3 = "";
		if(member.getPassword().equals("")){
		}else{
			result = member.getPassword();
		}
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection()
				.createStatement().executeUpdate(
						String.format("UPDATE Member SET "
								+ "password='%s',"
								+ "profileImg='%s',"
								+ "phone='%s',"
								+ "email='%s' "
								+ "WHERE id='%s'" ,result,result1,result2,result3));
		
	}

	@Override
	public int delete(MemberBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection()
				.createStatement().executeUpdate(String.format("DELETE FROM Member WHERE id='%s'",member.getId()));
	}
}