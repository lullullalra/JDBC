package lesson.jdbc.day3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lesson.jdbc.day2.ConnectionManager;
import lesson.jdbc.day2.StudentVO;

public class ResultSetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSetMain sm = new ResultSetMain();
		try {
			sm.testResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testResultSet() throws SQLException { 
		String sql = "SELECT * FROM gisa WHERE local_code = ?";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "B");
		ResultSet rs = pstmt.executeQuery();
		//테이블의 데이터를 원하는 부분만큼 저장해야함
		//VO를 이용해서 컬렉션에 저장
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		StudentVO vo = null;
		while(rs.next()) {
			vo = new StudentVO();
			vo.setStdNo(rs.getInt(1));
			vo.setEmail(rs.getString(2));
			vo.setKor(rs.getInt(3));
			vo.setEng(rs.getInt(4));
			vo.setMath(rs.getInt(5));
			vo.setSci(rs.getInt(6));
			vo.setHist(rs.getInt(7));
			vo.setTotal(rs.getInt(8));
			vo.setMgrCode(rs.getString(9));
			vo.setAccCode(rs.getString(10));
			vo.setLocCode(rs.getString(11));	
			list.add(vo);
		}
		rs.close();
		con.close();
		pstmt.close();
		
	}

}
