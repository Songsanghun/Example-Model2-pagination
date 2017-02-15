package util;
import java.sql.*;
import constants.Database;
public class JdbcTest {
	public static void main(String[] args) {
		try {                     						// project 밖에 나가서 DirverManager 끌고 온 것.
			Class.forName(Database.ORACLE_DRIVER);      // 생성자에 들어가야한다. setter라서
			Connection connection = DriverManager.getConnection(
					Database.ORACLE_URL, Database.USERNAME, Database.PASSWORD
					);
			Statement stmt = connection.createStatement();   //공통 부분은 필드에 선언해줘도 된다.
			String sql = "SELECT * FROM Member WHERE id='song'",result="";  //구분해줘야 한다.
			ResultSet set =stmt.executeQuery(sql);
			while(set.next()){
				result=set.getString("name");
				
			}
			System.out.println("회원이름: "+result);
		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}

		
	}
}
