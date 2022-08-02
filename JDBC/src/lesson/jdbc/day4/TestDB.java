package lesson.jdbc.day4;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDB db = new TestDB();
		db.test1();
// 		db.test2();
		db.test3();
		db.test4();
	}
	
	public void test1() {
		//로직 클래스를 불러와서 1번 문제 푸는 코드
		QuizSolutionService service = new QuizSolutionService();
		service.solveQuiz1V2();
	}
	
	public void test2() {
		QuizSolutionService service = new QuizSolutionService();
		service.solveQuiz2();
	}
	
	public void test3() {
		QuizSolutionService service = new QuizSolutionService();
		service.solveQuiz3();
	}
	
	public void test4() {
		QuizSolutionService service = new QuizSolutionService();
		service.solveQuiz4();
	}
	
	public void testDate() {
		//sql에서 사용하는 Date에 관련된 객체 만들기
		Date date = new Date(System.currentTimeMillis()); //데이터베이스 Date 형
		Timestamp stamp = new Timestamp(System.currentTimeMillis()); //데이터 베이스 Timestamp형 호환
	}

}
