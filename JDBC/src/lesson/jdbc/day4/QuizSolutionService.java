package lesson.jdbc.day4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class QuizSolutionService { //비즈니스 로직 클래스
	
	public void solveQuiz1V2() {
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz1Data("B");
			//list 처리 로직(collections를 이용한)
			Collections.sort(list,new StudentComparator());
			System.out.println("1번 정답은 "+list.get(4).getStdNo()+"입니다");
			System.out.println("2번 정답은 "+list.get(0).getQuiz1Data()+"입니다");
//			this.printList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void solveQuiz1() {
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz1Data("B");
			//list 처리 로직(정렬/kor+eng/학번)
			StudentVO vo1 = null;
			StudentVO vo2 = null;
			StudentVO temp = null; //값이 중복되지 않게 따로 vo1 저장소 만듦
			for(int i=0; i<list.size()-1; i++) { //(국어+영어) 내림차순 정렬
				for(int j=i+1; j<list.size(); j++) { 
					vo1 = list.get(i);
					vo2 = list.get(j);
					if(vo1.getQuiz1Data()<vo2.getQuiz1Data()) {
						temp = vo1; 
						list.set(i, vo2);
						list.set(j, temp);
					} else if(vo1.getQuiz1Data()==vo2.getQuiz1Data()) { //동일값 발생시 학번 오름차순 정렬
						if(vo1.getStdNo()>vo2.getStdNo()) { 
							temp = vo1;
							list.set(i, vo2);
							list.set(j,temp);
						}
					}
				}
			}
//			this.printList(list);
			System.out.println("1번 정답은 "+list.get(4).getStdNo()+"입니다");
//			System.out.println(list.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void solveQuiz2() {
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz1Data("B");
			//list 처리 로직(정렬/kor+eng/학번)
			StudentVO vo1 = null;
			StudentVO vo2 = null;
			StudentVO temp = null; //값이 중복되지 않게 따로 vo1 저장소 만듦
			for(int i=0; i<list.size()-1; i++) { //(국어+영어) 내림차순 정렬
				for(int j=i+1; j<list.size(); j++) { 
					vo1 = list.get(i);
					vo2 = list.get(j);
					if(vo1.getQuiz1Data()<vo2.getQuiz1Data()) {
						temp = vo1; 
						list.set(i, vo2);
						list.set(j, temp);
					} else if(vo1.getQuiz1Data()==vo2.getQuiz1Data()) { //동일값 발생시 학번 오름차순 정렬
						if(vo1.getStdNo()>vo2.getStdNo()) { 
							temp = vo1;
							list.set(i, vo2);
							list.set(j,temp);
						}
					}
				}
			}
//			this.printList(list);
			System.out.println("2번 정답은 "+list.get(1).getQuiz1Data()+"입니다");
//			System.out.println(list.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void solveQuiz3() {
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz3Data(120);
			int sum = 0;
			for(StudentVO vo : list) {
				int point = 20;
				if(vo.getMgrCode().equals("A")) {
					point = 5;
				}else if(vo.getMgrCode().equals("B")) {
					point = 15;
				}
				sum = sum + (vo.getTotal()+point);
			}
			System.out.println("3번 정답은 "+sum+"입니다");
			//list 처리 로직(collections를 이용한)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void solveQuiz4() {
		GisaDAO dao = new GisaDAO();
		try {
			ArrayList<StudentVO> list = dao.selectQuiz4Data("A","B");
			int count = 0;
			for(StudentVO vo : list) {
				int point = 15;
				if(vo.getLocCode().equals("A")) {
					point = 5;
				}else if(vo.getLocCode().equals("B")) {
					point = 10;
				}
				if(vo.getKor()+point>=50) {
					count++;
				}
			}
			System.out.println("4번 정답은 "+count+"입니다");
			//list 처리 로직(collections를 이용한)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void printList(ArrayList<StudentVO> list) {
		for(StudentVO vo : list) {
			System.out.println(vo);
		}
	}
	
	

}
