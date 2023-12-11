package com.itwill04.array;

public class LottoMain {

	public static void main(String[] args) {
		
		System.out.println("------ 로또 번호 6개 생성[중복번호 허용 안됨] -----");
		int[] lottoNumber = {0, 0, 0, 0, 0, 0}; // new int(6);
		
		/*
		 * 번호 생성
		 * 	- QUIZ 중복체크 ( 횟수가 정해져 있지않음 : while문도 괜찮음)
		 */
		for (int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = (int)(Math.random()*45)+1;
			for (int j = 0; j < i; j++) {
				if(lottoNumber[i] == lottoNumber[j]) {
					System.out.println("-----중복번호발생-----");
					i--;
					break;
				}
			}
		}
		
		
		
		/*
		   	boolean duplicate = true;
			for(int i = 0; i < lottoNumber.length; i++) {
				lottoNumber[i] = (int)(Math.random()*45)+1;
				if(duplicate) {
					i--; //  마지막나올때마다 중복되면 한번 더 찍음 -> 중복숫자 안나오도록
					duplicate = false;
				}
				System.out.println("******************");
			}  // 횟수가 정해져있지 않음 - > 중복되지않도록 계속 뽑아야 하므로
		 */
		
		for(int i = 0; i < lottoNumber.length; i++) {
			lottoNumber[i] = (int)(Math.random()*45)+1;
			} // 횟수가 정해져있지 않음 - > 중복되지않도록 계속 뽑아야 하므로
		
		/*
		 * 번호출력
		 */
		for (int i = 0; i < lottoNumber.length; i++) {
			System.out.print(lottoNumber[i] + " ");
		}
		
		
		
		
		
		
	}

}
