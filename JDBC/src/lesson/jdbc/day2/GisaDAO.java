package lesson.jdbc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GisaDAO {
	
	public int SelectQuery2(String query) throws SQLException {
		int result = 0;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery(); //ResultSet은 테이블 형태를 가지고 있음
		if(rs.next()) {
			result = rs.getInt(1); //인덱스 - ResultSet의 인덱스는 1부터 시작함
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return result;
	}
	
	public int SelectQuery1(String query) throws SQLException {
		int result = 0;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			result = rs.getInt(1);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return result;
	}
	
	public int SelectQuery3(String query) throws SQLException {
		int result = 0;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			result = rs.getInt(1);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return result;
	}
	
	public int SelectQuery4(String query) throws SQLException {
		int result = 0;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			result = rs.getInt(1);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return result;
	}
	//DELETE
	public boolean deleteData(int stdNo) throws SQLException {
		boolean flag = false;
		//커넥션 취득
		Connection con = ConnectionManager.getConnection();
		//쿼리 작성
		String sql = "DELETE from gisa where std_no = "+stdNo; //전체 삭제할 시 쿼리문만 DELETE from gisa로 하면 됌
		//쿼리 전송 통로 작성
		Statement stmt = con.createStatement();
		//쿼리 전송
		int affectedCount = stmt.executeUpdate(sql);
		//결과 처리
		if(affectedCount>0) {
			flag = true;
		}
		//연결된 통로 모두 닫기
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
	}
	
	public boolean deleteData() throws SQLException {
		boolean flag = false;
		//커넥션 취득
		Connection con = ConnectionManager.getConnection();
		//쿼리 작성
		String sql = "DELETE from gisa"; //전체 삭제할 시 쿼리문만 DELETE from gisa로 하면 됌
		//쿼리 전송 통로 작성
		Statement stmt = con.createStatement();
		//쿼리 전송
		int affectedCount = stmt.executeUpdate(sql);
		//결과 처리
		if(affectedCount>0) {
			flag = true;
		}
		//연결된 통로 모두 닫기
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
	}
	
	//CREATE
	public boolean insertData(StudentVO vo) throws SQLException {
		//data를 기사에 삽입
		boolean flag = false;
		
		//990001,addx, 17, 29, 16, 49, 43,154,C,A,C
		//테이블에서 정의한 데이터인지 확인하고 전처리
		//테이블 삽입 쿼리 작성
		String sql = "INSERT INTO gisa VALUES("+vo.getStdNo()+",'"+vo.getEmail()+"',"+vo.getKor()+","
											   +vo.getEng()+","+vo.getMath()+","
											   +vo.getSci()+","+vo.getHist()+","
											   +vo.getTotal()+",'"+vo.getMgrCode()+"','"
											   +vo.getAccCode()+"','"+vo.getLocCode()+"')";
		//커넥션 객체 가져오기
		Connection con = ConnectionManager.getConnection();
		//삽입 준비하기
		Statement stmt = con.createStatement(); //Statement --> Stream 역할을 함
		//삽입하기
		int affectedCount = stmt.executeUpdate(sql); //데이터를 추가(Insert), 삭제(Delete), 수정(Update)하는 SQL 문을 실행
		//연결 종료
		ConnectionManager.closeConnection(null, stmt, con);
		//삽입 결과 확인
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	//파일 안의 1000개의 라인을 INSERT 하시오.
	public boolean insertDataAll(ArrayList<StudentVO> list) throws SQLException {
		boolean flag = false;
		int affectedCount = 0;
		// 컨넥션 객체 가져오기
		Connection con= ConnectionManager.getConnection();
		Statement stmt = null;
		for(StudentVO vo : list) {
			String sql = "insert into gisa values ("+vo.getStdNo()+",'"+vo.getEmail()+"',"+vo.getKor()+","+vo.getEng()+","
					+ vo.getMath()+","+vo.getSci()+","+vo.getHist()+","+vo.getTotal()+",'"+vo.getMgrCode()+"','"+vo.getAccCode()+"','"+vo.getLocCode()+"')";
			
			// 삽입 준비하기
			stmt = con.createStatement();
			// 삽입하기
			affectedCount += stmt.executeUpdate(sql);
		}
		ConnectionManager.closeConnection(null, stmt, con);
		// 삽입결과 확인하고 flag에 세팅
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	public boolean insertDataV2(ArrayList<StudentVO> list) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "INSERT INTO gisa values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int affectedCount = 0;
//		StudentVO vo = null;
		for(StudentVO vo : list) {
//			vo = list.get(0);
			pstmt.setInt(1, vo.getStdNo());
			pstmt.setString(2,vo.getEmail());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			pstmt.setInt(6, vo.getSci());
			pstmt.setInt(7, vo.getHist());
			pstmt.setInt(8, vo.getTotal());
			pstmt.setString(9,vo.getMgrCode());
			pstmt.setString(10,vo.getAccCode());
			pstmt.setString(11,vo.getLocCode());
			affectedCount = pstmt.executeUpdate();
		}
		if(affectedCount>0) {
			System.out.println("Success");
		}else {
			System.out.println("failed");
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		
		return flag;
	}
	
}
