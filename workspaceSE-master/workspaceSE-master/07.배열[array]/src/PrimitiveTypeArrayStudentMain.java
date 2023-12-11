		// 참조변수그림 그려보시오
		// 버블정럴 https://www.youtube.com/watch?v=ebI54DXYQG8&t=124s

		// 나도 모르는 정렬은 사용하면 안됩니다. 얻어걸리면 하는거도 못하다

public class PrimitiveTypeArrayStudentMain {

	public static void main(String[] args) {
		
		System.out.println("----- 학생 10명 성적데이터를 저장하기 위한 배열객체생성&초기화 -----");
		int[] noArray = 		{1,2,3,4,5,6,7,8,9,10}; // 배열을 블록에 의한 초기화
		String[] nameArray = 	{"KIM", "LEE", "PARK", "CHOI", "SIM", "KIM", "PIM", "MIN", "AIM", "LIM" };
		int[] korArray = 		{12, 45, 80, 45, 89, 99, 34, 56, 80, 98};
		int[] engArray = 		{98, 56, 34, 67, 98, 23, 56, 78, 45, 22};
		int[] mathArray = 		{45, 67, 34, 12, 77, 23, 56, 99, 98, 11};
		int[] totArray = 		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		double[] avgArray = 	{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		char[] gradeArray = 	{'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F'};
		int[] rankArray = 		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		System.out.println();
		
		/*
		 * 총점, 평균, 평점 계산
		 */
		
		for(int i = 0; i < noArray.length; i++) {
			totArray[i] = korArray[i] + engArray[i] + mathArray[i];
			
			avgArray[i] = totArray[i] / 3.0;
			
			if(avgArray[i] >= 90) {
				gradeArray[i] = 'A';
			}else if(avgArray[i] >= 80) {
				gradeArray[i] = 'B';
			}else if(avgArray[i] >= 70) {
				gradeArray[i] = 'C';
			}else if(avgArray[i] >= 60) {
				gradeArray[i] = 'D';
			}else {
				gradeArray[i] = 'F';
			} 
		}
		
		
		/*
		 * 총점으로 석차계산
		 */
		/*
		 * 1번학생(index --> 0) 석차 계산
		 */
		for(int j = 0; j < totArray.length; j++) {
			if(totArray[0] < totArray[j]) {
				rankArray[0]++;
			}
		}
		/*
		 * 2번학생(index --> 1) 석차 계산
		 */
		for(int j = 0; j < totArray.length; j++) {
			if(totArray[1] < totArray[j]) {
				rankArray[1]++;
			}
		}
		 /*
		  * 3번학생(index-->2)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[2] < totArray[j]) {
				 rankArray[2]++;
			 }
		 }
		 /*
		  * 4번학생(index-->3)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[3] < totArray[j]) {
				 rankArray[3]++;
			 }
		 }
		 /*
		  * 5번학생(index-->4)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[4] < totArray[j]) {
				 rankArray[4]++;
			 }
		 }
		 /*
		  * 6번학생(index-->5)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[5] < totArray[j]) {
				 rankArray[5]++;
			 }
		 }
		 /*
		  * 7번학생(index-->6)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[6] < totArray[j]) {
				 rankArray[6]++;
			 }
		 }
		 /*
		  * 8번학생(index-->7)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[7] < totArray[j]) {
				 rankArray[7]++;
			 }
		 }
		 /*
		  * 9번학생(index-->8)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[8] < totArray[j]) {
				 rankArray[8]++;
			 }
		 }
		 /*
		  * 10번학생(index-->9)석차계산
		  */
		for(int j=0;j<totArray.length;j++) {
			 if(totArray[9] < totArray[j]) {
				 rankArray[9]++;
			 }
		 }
		 // -----------------------------------------------------------------
		 /*
		  * 한번에 석차 구하기
		  */
		 for(int i = 0; i <totArray.length; i++) {
			 for(int j = 0; j < totArray.length; j++) {
				 if(totArray[i] < totArray[j]) {
					 rankArray[i]++;
				 }
			 }
		 }
		
		
		/*
		 * 학생검색(번호,국어,영어,수학,학점,석차)
		 */
		
		/*
		 * 번호3번인학생 1명찾아서 1명정보출력(학생번호는 중복되지않는다.)
		 */
		System.out.println("번호3번인학생 1명찾아서 1명정보출력(학생번호는 중복되지않는다.)");
		for(int i = 0; i < noArray.length; i++) {
			if(noArray[i] == 3) {
			System.out.printf("%4d %6s %d %4d %4d %4d %6.1f %3c %4d \n",
					 noArray[i], nameArray[i], korArray[i], engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
			}
		}
		
		System.out.println();
		
		 /*
		 * 국어점수 80점인 학생들 여러명 찾아서 여러명정보출력
		 */
		System.out.println("국어점수 80점인 학생들 여러명 찾아서 여러명정보출력");
		for(int i = 0; i < noArray.length; i++) {
			if(korArray[i] == 80) {
			System.out.printf("%4d %6s %d %4d %4d %4d %6.1f %3c %4d \n",
					 noArray[i], nameArray[i], korArray[i], engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
			}
		}
		
		System.out.println();
		
		 /*
		 * 영어점수 50점이하인 학생들 여러명 찾아서 여러명정보출력
		 */
		System.out.println(">>영어점수 50점이하인 학생들 여러명 찾아서 여러명정보출력");
		for(int i = 0; i < noArray.length; i++) {
			if(engArray[i] <= 50) {
				System.out.printf("%4d %6s %d %4d %4d %4d %6.1f %3c %4d \n",
						 noArray[i], nameArray[i], korArray[i], engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
			}
		}
		
		System.out.println();
		
		/*
		 * 수학점수 70점이상인 학생들 여러명 찾아서 여러명정보출력
		 */
		System.out.println(">>수학점수 70점이상인 학생들 여러명 찾아서 여러명정보출력");
		for(int i = 0; i < noArray.length; i++) {
			if(mathArray[i] > 70) {
				System.out.printf("%4d %6s %d %4d %4d %4d %6.1f %3c %4d \n",
						 noArray[i], nameArray[i], korArray[i], engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
			}
		}
		
		System.out.println();
		
		/*
		 * 학점이 D학점이하인 학생모두찾아서 여러명 정보출력
		 */
		
		System.out.println(">>학점이 D학점이하인 학생모두찾아서 여러명 정보출력");
			for(int i = 0; i < noArray.length; i++) {
				if(gradeArray[i] >= 'D') {
					System.out.printf("%4d %6s %d %4d %4d %4d %6.1f %3c %4d \n",
							 noArray[i], nameArray[i], korArray[i], engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
				}
			}
			
		System.out.println();

		
		System.out.println(">>>>>>>>>>>>>>>>> 정렬전 <<<<<<<<<<<<<<<<<<<<<<<");
		System.out.printf("--------학생성적출력-----------------------------\n");
		System.out.printf("%s %3s %3s %s %s %s %s %s %s \n","학번","이름","국어", "영어","수학","총점","평균","평점","석차");
		System.out.printf("-------------------------------------------------\n");
		
		for(int i = 0; i < noArray.length; i++) {
			 System.out.printf("%4d %6s %d %4d %4d %4d %6.1f %3c %4d \n",
					 noArray[i], nameArray[i], korArray[i], engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
		} // 좌측정렬 할려면 - 붙여주면 됨 (예를들어 %-6s 처럼 해주면 됨)
		
		System.out.println();
		
		 /*
		 * 정렬 -> 주로 숫자를 사용한다
		 *    1.오름차순 (작은숫자 -> 큰숫자) / index 0 번째 자리에 제일 작은숫자가 들어옴 
		 *      ex> 1,2,3,4,5...
		 *          a,b,c,d,e...., 가 ... 힣
		 *    2.내림차순 (큰숫자 -> 작은숫자) / index 0 번째 자리에 제일 큰 숫자가 들어옴
		 *    	ex> 5,4,3,2,1
		 *          z,y,x...., 힣 ... 가
		 */
		int a = 10; 
		int b = 3; 
		// a 의 값과 b 의 값을 교체 (swap a, b)
		System.out.println("----------swap a,b-----------");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		int temp = b; // 임시변수 먼저 선언 , b 의 값을 보관하기위해 (값을 보관하기 위해 임시변수가 필요하다)
		b = a; // b 에다가 a 값을 넣는다
		a = temp;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		System.out.println();
		
		/*
		 * 학생총점(석차)순으로 오름차순 (총점 낮은 -> 높은) 기준이 있으면 가능 
		 */
		// 1회 -> 총점이 가장 높은 사람이 맨 뒤로
		for(int j = 0; j < totArray.length - 1; j++) {
			if(totArray[j] > totArray[j +1]) {
				// no 교체
				int tempNo = noArray[j + 1];
				noArray[j + 1] = noArray[j];
				noArray[j] = tempNo;
				// name 교체
				String tempName = nameArray[j + 1];
				nameArray[j + 1] = nameArray[j];
				nameArray[j] = tempName;
				// kor 교체
				int tempKor = korArray[j + 1];
				korArray[j + 1] = korArray[j];
				korArray[j] = tempKor;
				// eng 교체
				int tempEng = engArray[j + 1];
				engArray[j + 1] = engArray[j];
				engArray[j] = tempEng;
				// math 교체
				int tempmath = mathArray[j + 1];
				mathArray[j + 1] = mathArray[j];
				mathArray[j] = tempmath;
				// tot 교체
				int tempTot = totArray[j + 1];
				totArray[j + 1] = totArray[j];
				totArray[j] = tempTot;
				// avg 교체
				double tempAvg = avgArray[j + 1];
				avgArray[j + 1] = avgArray[j];
				avgArray[j] = tempAvg;
				// grade 교체
				char tempGrade = gradeArray[j + 1];
				gradeArray[j + 1] = gradeArray[j];
				gradeArray[j] = tempGrade;
				// rank 교체
				int tempRank = rankArray[j + 1];
				rankArray[j + 1] = rankArray[j];
				rankArray[j] = tempRank;
				// no, name, kor, eng, math, tot, avg, grade, rank
			}
		}
		
		// -> 1회때 총점이 가장 높은 사람이 맨 뒤로 가고
		// 	  2회차때 두번째로 높은사람이 가고 ... 끝까지 가면 됨 - 이중for문
		// 2회 
		// 3회
		// 4회
		// 5회
		// 6회
		// 7회
		// 8회
		// 9회
		
		// 학생총점순으로 오름차순 
		for (int i = 0; i < noArray.length-1; i++) {
			for (int j = 0; j < noArray.length-1; j++) {
				// for (int j = 0; j < noArray.length-1-i; j++) {
				if (totArray[j] < totArray[j + 1]) {
					// no 교체
					int tempNo = noArray[j + 1];
					noArray[j + 1] = noArray[j];
					noArray[j] = tempNo;
					// name 교체
					String tempName = nameArray[j + 1];
					nameArray[j + 1] = nameArray[j];
					nameArray[j] = tempName;
					// kor 교체
					int tempKor = korArray[j + 1];
					korArray[j + 1] = korArray[j];
					korArray[j] = tempKor;
					// eng 교체
					int tempEng = engArray[j + 1];
					engArray[j + 1] = engArray[j];
					engArray[j] = tempEng;
					// math 교체
					int tempmath = mathArray[j + 1];
					mathArray[j + 1] = mathArray[j];
					mathArray[j] = tempmath;
					// tot 교체
					int tempTot = totArray[j + 1];
					totArray[j + 1] = totArray[j];
					totArray[j] = tempTot;
					// avg 교체
					double tempAvg = avgArray[j + 1];
					avgArray[j + 1] = avgArray[j];
					avgArray[j] = tempAvg;
					// grade 교체
					char tempGrade = gradeArray[j + 1];
					gradeArray[j + 1] = gradeArray[j];
					gradeArray[j] = tempGrade;
					// rank 교체
					int tempRank = rankArray[j + 1];
					rankArray[j + 1] = rankArray[j];
					rankArray[j] = tempRank;

				}
			}
		}
		// 한번 할때마다 하나 채워줌 -> 마지막숫자 - 1 
		
		
		 System.out.println(">>>>>>>>>>>>>>>>> 정렬후 <<<<<<<<<<<<<<<<<<<<<<<");
		 System.out.printf("-----------------학생성적출력-----------------\n");
		 System.out.printf("%s %3s %s %s %s %s %3s %s %s\n",
				 "학번","이름","국어","영어","수학","총점","평균","평점","석차");
		 System.out.printf("----------------------------------------------\n");
		 for(int i=0;i<noArray.length;i++) {
			 System.out.printf("%4d %-6s %d %4d %4d %4d %6.1f %3c %4d\n",
					 noArray[i],nameArray[i],korArray[i],engArray[i],mathArray[i],totArray[i],avgArray[i],gradeArray[i],rankArray[i]);
		 }
		 
		 
		 
	}

}
