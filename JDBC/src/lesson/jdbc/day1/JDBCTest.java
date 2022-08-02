package lesson.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCTest test = new JDBCTest();
		String data = "990001,addx, 17, 29, 16, 49, 43,154,C,A,C";
		try {
			boolean flag = test.insertData(data);
			if(flag) {
				System.out.println("삽입완료");
			}else {
				System.out.println("삽입실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertData(String data) throws SQLException {
		//data를 기사에 삽입
		boolean flag = false;
		//990001,addx, 17, 29, 16, 49, 43,154,C,A,C
		String[] temp = data.split(",");
		//테이블에서 정의한 데이터인지 확인하고 전처리
		//테이블 삽입 쿼리 작성
		String sql = "INSERT INTO gisa VALUES("+Integer.parseInt(temp[0])+",'"+temp[1]+"',"+Integer.parseInt(temp[2].trim())+","
											   +Integer.parseInt(temp[3].trim())+","+Integer.parseInt(temp[4].trim())+","
											   +Integer.parseInt(temp[5].trim())+","+Integer.parseInt(temp[6].trim())+","
											   +Integer.parseInt(temp[7].trim())+",'"+temp[8]+"','"+temp[9]+"','"+temp[10]+"')";
		//컨넥션 객체 가져오기
		Connection con = this.getConnection();
		//삽입 준비하기
		Statement stmt = con.createStatement(); //Statement --> Stream 역할을 함
		//삽입하기
		int affectedCount = stmt.executeUpdate(sql);
		//삽입 결과 확인
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	public void connectMYSQL() throws ClassNotFoundException, SQLException {
	
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURl = "jdbc:mysql://localhost:3306/gisa"; //jdbc:mysql: --> 프로토콜, localhost:3306/gisa --> 정보가 있는 위치
		String id = "root";
		String pwd = "1234";
		
		Class.forName(driver); //드라이버를 등록한다는 뜻 forName()
		Connection con = DriverManager.getConnection(jdbcURl,id,pwd); //연결 여부 체크
		if(con!=null) {
			System.out.println("connected");
			con.close();
		}else {
			System.out.println("fail");
		}
	}
	
	public Connection getConnection() {
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

}
