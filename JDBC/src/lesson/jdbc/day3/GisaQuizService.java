package lesson.jdbc.day3;


import java.sql.SQLException;
import lesson.jdbc.day2.GisaDAO;

public class GisaQuizService {
	
	// 1번 문제
	public int getFifthStdNo() throws SQLException {
		int answer = 0;
		String sql = "select std_no from gisa where local_code ='B' order by kor+eng desc, std_no asc limit 4 offset 1"; //limit 4 offset 1
		GisaDAO dao = new GisaDAO();
		answer = dao.SelectQuery1(sql);
		return answer;
	}
	
	//2번 문제 : 지역코드가 B인 학생의 kor+eng 점수가 가장 큰 점수는?
	public int getMaxScore() throws SQLException{
		int answer = 0;
		String sql = "select max(kor+eng) from gisa where local_code = 'B'";
		GisaDAO dao = new GisaDAO();
		answer = dao.SelectQuery2(sql);
		
		return answer;
	}
	
	//3번 문제 : 조건에 맞는 점수의 누적합
	public int getSumOfScore() throws SQLException {
		int answer = 0;
		String sql = "select sum(total)+sum(case mgr_code"
				+ "	when 'A' then 5"
				+ "	when 'B' then 15"
				+ "	when 'C' then 20"
				+ "	else 0"
				+ " end) as total "
				+ " from gisa "
				+ " where (eng+math) >= 120; ";
		GisaDAO dao = new GisaDAO();
		answer = dao.SelectQuery3(sql);
		return answer;
	}
	
	//4번 문제 : 조건이 맞는 학생의 수 카운트
	public int getSumOfCount() throws SQLException {
		int answer = 0;
		String sql = "select count(*)"
				+ " from gisa "
				+ " where (acc_code = 'A' or acc_code = 'B') "
				+ " and (kor+ (case local_code "
				+ "	when 'A' then 5 "
				+ "	when 'B' then 10 "
				+ "	when 'C' then 15 "
				+ " end)) >= 50; ";
		GisaDAO dao = new GisaDAO();
		answer = dao.SelectQuery4(sql);
		return answer;
	}
	
}
