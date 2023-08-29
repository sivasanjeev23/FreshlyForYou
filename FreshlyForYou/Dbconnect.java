package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbconnect {
	private static final String dburl="Jdbc:Mysql://localhost:3306/Newone",
			dbuser="root",dbpass="";
public static Connection dbCon() throws SQLException {
	return DriverManager.getConnection(dburl,dbuser,dbpass);
}
}
