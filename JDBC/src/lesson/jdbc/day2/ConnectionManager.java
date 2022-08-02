package lesson.jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	
	public static Connection getConnection() {
			Connection con = null;
			String driver = "com.mysql.cj.jdbc.Driver";
			String jdbcURl = "jdbc:mysql://localhost:3306/gisa"; //jdbc:mysql: --> 프로토콜, localhost:3306/gisa --> 정보가 있는 위치
			String id = "root";
			String pwd = "1234";
			
			try {
				Class.forName(driver); //드라이버를 등록한다는 뜻 forName()
				con = DriverManager.getConnection(jdbcURl,id,pwd);
			} catch (ClassNotFoundException ce) {
				// TODO Auto-generated catch block
				ce.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return con;
		}
	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}

