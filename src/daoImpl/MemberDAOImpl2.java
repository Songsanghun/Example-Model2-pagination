package daoImpl;
import java.sql.*;
import constants.Database;
import dao.MemberDAO;
import domain.DatabaseBean;
import domain.MemberBean;
import factory.DatabaseFactory;
import enums.Vendor;
public class MemberDAOImpl2 implements MemberDAO{
	private Connection connection;      //RAM   필드에선 연산하지 않는다.
	private Statement stmt;				//RAM	
	private ResultSet set;				//RAM
	
public MemberDAOImpl2() {	//CPU
	try {
		DatabaseBean db = DatabaseFactory.createDatabase( Vendor.ORACLE, Database.USERNAME, Database.PASSWORD);
		//Class.forName(Database.ORACLE_DRIVER); //static method , class method
		connection = db.getConnection();
		stmt = connection.createStatement();
	} catch (Exception e) {
		e.printStackTrace();
	}  
	
}
@Override
public int insert(MemberBean member) {    //에러만 없앰
	try {
		stmt.executeUpdate(String.format("INSERT INTO Member(id,name,ssn,password,profileImg,phone,email,rank)"
				+ "VALUES ('%s','%s','%s','%s','%s','%s,'%s','%s')", member.getId(),member.getName(),member.getSsn(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail(),member.getRank()));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
}
@Override
public MemberBean selectById(String id) {
	MemberBean member = new MemberBean();
	try {
		set = stmt.executeQuery(String.format("SELECT * FROM Member WHERE id='%s'", id));
		while(set.next()){
			member.setId(set.getString("id"));
			member.setName(set.getString("name"));
			member.setSsn(set.getString("ssn"));
			member.setPassword(set.getString("password"));
			member.setProfileImg(set.getString("phone"));
			member.setEmail(set.getString("email"));
			member.setRank(set.getString("rank"));
		}
	} catch (Exception e) {
		System.out.println("에러발생");
		e.printStackTrace();
	}
	
	return member;
}
@Override
public int update(MemberBean member) {
	try {
		stmt.executeUpdate(String.format("UPDATE Member SET name='%s',password='%s',profileImg='%s',phone='%s',email='%s'",(member.getName().equals("")?"":member.getName()),(member.getPassword().equals("")?"":member.getPassword()),(member.getProfileImg().equals("")?"":member.getProfileImg()),(member.getPhone().equals("")?"":member.getPhone()),(member.getEmail().equals("")?"":member.getEmail())));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}
@Override
public int delete(MemberBean member) {
	return 0;
	// TODO Auto-generated method stub
	
}
}