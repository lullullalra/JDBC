package lesson.jdbc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseMain {
	private GisaDAO dao; //1. 필드로 선언하는 방법 2. 파라미터 방법
	
	public DatabaseMain(GisaDAO dao) {
		this.dao = dao;
	}
	public static void main(String[] args) {
		DatabaseMain main = new DatabaseMain(new GisaDAO());
		//main.testInsert();
		try {
			//main.testDelete();
			ArrayList<StudentVO> list = main.getFileData();
			main.testInsert2(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<StudentVO> getFileData() throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ArrayList<StudentVO> list = null;
				/////////////////////////////////////
				list = new ArrayList<StudentVO>();
				///////////////////////////////////////
				File file = new File("./Abc1115.csv");
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line= null;
				//////////////////////////////
				StudentVO vo = null;
				////////////////////////////////
				while((line=br.readLine())!=null) { //null은 파일의 끝을 가리킴
					////////////////////////////////
					vo = new StudentVO(line);
					list.add(vo);
					/////////////////////////////////
				}
				br.close();
				fr.close();
				return list;
	}
	
	public void testInsert2(ArrayList<StudentVO> list) throws SQLException {
//		GisaDAO dao = new GisaDAO();
		boolean flag = dao.insertDataAll(list);
		if(flag) {
			System.out.println("list insert success");
			
			
		} else {
			System.out.println("list insert fail");
		}
	}
	
	public void testInsert() {
		String data = "990002,addx, 17, 29, 16, 49, 43,154,C,A,C";
//		GisaDAO dao = new GisaDAO();
		StudentVO vo = new StudentVO(data);
		try {
			boolean flag = dao.insertData(vo);
			if(flag) {
				System.out.println("insert success");
			}else {
				System.out.println("insert fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testDelete() throws SQLException {
//		GisaDAO dao = new GisaDAO();
		boolean flag = dao.deleteData(990002);
		if(flag) {
			System.out.println("delete success");
		}else {
			System.out.println("delete fail");
		}
	}
	

}
