package com.itwill06.collection.student;

 
import java.util.ArrayList;
import java.util.Collections;
//배열에는 .length 가 있지만 ArrayList 에는 .length가 없어서 .size를 사용한다.

public class StudentArrayListMain {

	public static void main(String[] args) {
		
		/*
		 * 0.학생ArrayList객체생성초기화
		 */
		ArrayList studentList=new ArrayList();
		studentList.add(new Student(1,"KIM",89,93,94));
		studentList.add(new Student(2,"HIM",88,77,98));
		studentList.add(new Student(3,"AIM",65,87,99));
		studentList.add(new Student(4,"KIM",75,97,60));
		studentList.add(new Student(5,"KIM",85,98,90));
		studentList.add(new Student(6,"TIM",95,88,77));
		studentList.add(new Student(7,"KIM",99,93,95));
		studentList.add(new Student(8,"LIM",83,80,99));
		studentList.add(new Student(9,"QIM",73,90,80));
		
		int size = studentList.size();
		System.out.println("#size : " + size);
		
		/*
		 * 0.학생두명추가
		 */
		System.out.println("0.학생두명추가");
		studentList.add(9, new Student(10, "AAA", 98, 54, 21));
		studentList.add(10, new Student(11, "BBB", 88, 95, 75));
		System.out.println("#size : " + studentList.size());
		// System.out.println(studentList);
		
		/*
		 * 1. 전체학생총점,평균,평점계산
		 */
		System.out.println("1. 전체학생총점,평균,평점계산");
		for (Object objectStudent : studentList) {
			Student student = (Student)objectStudent;
			student.calculateTotal();
			student.calculateAvg();
			student.calculateGrade();
		}
		
		
		/*
		 * 2. 전체학생 총점으로 석차계산
		 */
		System.out.println("2. 전체학생 총점으로 석차계산");
		for (Object object : studentList) {
			for (Object object2 : studentList) {
				if(((Student) object).getTot()<((Student) object2).getTot()) {
					((Student)object).increaseRank();
					 
				}
			}
		}
		
		/*
		 * 3. 전체학생출력
		 */
		System.out.println("3. 전체학생출력 (enhanced for)");
		Student.headerPrint();
		for (int i = 0; i < studentList.size(); i++) {
			Object student = studentList.get(i);
			Student tempStudent = (Student)student;
			tempStudent.print();
		}
		
		
		/*
		 * 4. 번호3번 학생한명 출력
		 */
		System.out.println("4.번호3번 학생한명 출력");
		for (int i = 0; i < studentList.size(); i++) {
			Student tempStudent = (Student)studentList.get(i);
			if(tempStudent.getNo() == 3) {
				tempStudent.print();
				break;
			}
		}
		
		
		/*
		 * 5. 학점A인 학생들 출력
		 */
		System.out.println("5. 학점A인 학생들 출력");
//		for (int i = 0; i < studentList.size(); i++) {
//			Student tempStudent = (Student)studentList.get(i);
//			if(tempStudent.getGrade() == 'A');
//				tempStudent.print();
//		} -> 전체출력이 됨... 왜쥬??
		
		for (Object objectStudent : studentList) {
			Student student = (Student)objectStudent;
			if(student.getGrade() == 'A') {
				student.print();
			}
		}
		
		
		/*
		 6.이름이 KIM인학생들 출력
		 */
		System.out.println("6.이름이 KIM인학생들 출력");
		for (Object objectStudent : studentList) {
			Student tempStudent = (Student)objectStudent;
			if(tempStudent.getName().equals("KIM")) {
				tempStudent.print();
			}
		}
		
		
		/*
		 * 7.번호3번학생한명삭제
		 */
		System.out.println("7.번호3번학생삭제");
		for (int i = 0; i < studentList.size(); i++) {
			Student tempStudent = (Student)studentList.get(i);
			if(tempStudent.getNo() == 3) {
				
				System.out.println(">> 삭제 전 size : " + studentList.size());
				Student removeStr = (Student)studentList.remove(i);
				removeStr.print();
				System.out.println(">> 삭제 후 size : " + studentList.size());
				break;
			}
		}
		
		
		/*
		 * 8.이름KIM인 학생들삭제
		 */
		System.out.println("8.이름KIM인 학생들삭제");
		System.out.println(">> 삭제 전 size : " + studentList.size());
		for (int i = 0; i < studentList.size(); i++) {
			if(((Student)studentList.get(i)).getName().equals("KIM")) {
				Student remoStudent = (Student)studentList.remove(i);
				remoStudent.print();
				i--;
			}
		}	
		System.out.println(">> 삭제 후 size : " + studentList.size());
		
		
		System.out.println("8-1. 이름KIM인 학생들, 번호3번학생 삭제 후 나머지 전체계좌출력");
		Student.headerPrint();
		for (int i = 0; i < studentList.size(); i++) {
			Student tempStudent = (Student)studentList.get(i);
			tempStudent.print();
		}
		
		
		/*
		 * 9.평점 F 인 학생들삭제
		 */
		System.out.println("9.평점 F 인 학생들삭제");
		for (int i = 0; i < studentList.size(); i++) {
			Student tempStudent = (Student)studentList.get(i);
			if(tempStudent.getGrade() == 'F') {
				System.out.println(">> 삭제 전 size : " + studentList.size());
				Student reStudent = (Student)studentList.remove(i);
				reStudent.print();
				System.out.println(">> 삭제 후 size : " + studentList.size());
				break;
			}	
		}
		
		
		System.out.println("9-1. 이름KIM인 학생들, 번호3번학생, 평점 F 인 학생 삭제 후 나머지 전체계좌출력");
		Student.headerPrint();
		for (int i = 0; i < studentList.size(); i++) {
			Student tempStudent = (Student)studentList.get(i);
			tempStudent.print();
		}
		
		
		/******************안해도됨******************************/
		/*
		 * 10. 학생총점으로 오름차순정렬
		 */
		
		/*
		  11. 학생이름순으로 오름차순정렬
		 */
	
		/********************************************************/
		
		
	}

}
