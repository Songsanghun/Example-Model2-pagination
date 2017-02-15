package factory;

import constants.Database;
import domain.DatabaseBean;
import enums.Vendor;
public class DatabaseFactory { // 공장이라고 생각하면 된다. 그래서 static 으로 생성한다.
	public static DatabaseBean createDatabase(Vendor vendor, String username, String password) { // get
		String driver="",url="";
		switch(vendor){
		case DB2: 
			driver=Database.DB2_DRIVER;
			url=Database.DB2_URL;
			break;
		case ORACLE: 
			driver=Database.ORACLE_DRIVER;
			url=Database.ORACLE_URL;
			break;
		case MSSQL:
			driver=Database.MSSQL_DRIVER;
			url=Database.MSSQL_URL;
			break;
		case MYSQL: 
			driver=Database.MYSQL_DRIVER;
			url=Database.MYSQL_URL;
			break;
		case MARIADB:
			driver=Database.MARIADB_DRIVER;
			url=Database.MARIADB_URL;
			break;
		}
		DatabaseBean db = new DatabaseBean(driver, url, username, password); // 오버로딩  옵션에 따라서 생성되는 것이 다르다.
		return db;
	}

}
