package domain;
import java.sql.Connection;
import java.sql.DriverManager;

import constants.Database;
public class DatabaseBean {
	private String driver,url,username,password;
	private Connection connection;
	public DatabaseBean( String driver,String url,String username,String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;  //get 를 안만들면 값을 알수가 없다.
	}
	public Connection getConnection() {     //DBMS 의 벤더 구현 
		//Connection c = new Connection();
		//에러난 이유
		//1. 디폴트가 제거된 오버로딩을 했는가 
		//2. Connection 은 인터페이스라서 객체가 아니다. new 생성 안됨.(객체가 아니라서)
		//3. 데코패턴으로 던졋냐
		try{
			Class.forName(Database.ORACLE_DRIVER);  // set 해주는거 드라이버 매니저를 불러올수 있어서.
			connection = DriverManager.getConnection(Database.ORACLE_URL,  //Shallow copy 를 썻다. new 써도 의미없다 여기 DriverManager는 JDBC 드라이버라고 한다.
					Database.USERNAME,	//이 과정을 이해해야한다. 그래야 오라클 말고 이외도 쓸수있다.
					Database.PASSWORD);
		}catch(Exception e){ //핵심은 Exception을 안써주면 에러가 발생하면 블루스크린 뜬다.
			//Exception 이 최상이라서 애만 써도 된다.
			e.printStackTrace();  //에러가 된 이유 설명하고 죽으라는거  
		}
		return connection;
	}
	
	
	
}
