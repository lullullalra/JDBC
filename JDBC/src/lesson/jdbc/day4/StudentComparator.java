package lesson.jdbc.day4;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentVO> {

	@Override
	public int compare(StudentVO o1, StudentVO o2) {
		// TODO Auto-generated method stub
		int result = o2.getQuiz1Data()-o1.getQuiz1Data(); //내림차순
		if(result==0) {
			result = o2.getStdNo() - o1.getStdNo();
		}
		
		return result;
	}

}
