
public class WhileNested {

	public static void main(String[] args) {
		/*
		  ★★★★★ 
		  ★★★★★ 
		  ★★★★★ 
		  ★★★★★ 
		  ★★★★★
		 */
		System.out.println("-------------");

		int i = 0;
		while (i < 5) {
			System.out.print("★");
			System.out.print("★");
			System.out.print("★");
			System.out.print("★");
			System.out.print("★");
			System.out.print("\n");
			i++;
		}

		System.out.println("1.-------------");
		/*
		  ★[0,0]★[0,1]★[0,2]★[0,3]★[0,4] 
		  ★[1,0]★[1,1]★[1,2]★[1,3]★[1,4]
		  ★[2,0]★[2,1]★[2,2]★[2,3]★[2,4] 
		  ★[3,0]★[3,1]★[3,2]★[3,3]★[3,4]
		  ★[4,0]★[4,1]★[4,2]★[4,3]★[4,4]
		 */
		i = 0;
		while (i < 5) {
			int j = 0;
			while (j < 5) {
				System.out.printf("%s[%d,%d]", "★", i, j); // [ i값, j값]
				j++;
			}

			System.out.print("\n");
			i++;
		}

		/*
		  ☆★★★★ 
		  ★☆★★★ 
		  ★★☆★★ 
		  ★★★☆★ 
		  ★★★★☆
		 */
		System.out.println("2.-------------");
		i = 0;
		while (i < 5) {
			int j = 0;
			while (j < 5) {
				if (i == j) {
					System.out.print("☆");
				} else {
					System.out.print("★");
				}
				j++;
			}
			System.out.print("\n");
			i++;
		}
		
		System.out.println("3.-------------");
		/*
		  ☆☆☆☆☆
		  ★☆☆☆☆ 
		  ★★☆☆☆ 
		  ★★★☆☆ 
		  ★★★★☆
		 */
		i = 0;
		while (i < 5) {
			int j = 0;
			while (j < 5) {
				if (i <= j) {
					// 1. 을 보면 i가 j보다 같거나 작기때문에 조건을 <= 로 변경
					System.out.print("☆");
				} else {
					System.out.print("★");
				}
				j++;
			}
			System.out.print("\n");
			i++;
		}
		
		System.out.println("4. [Quiz] -------------");
		/*
		  ★★★★★
		  ☆★★★★
		  ☆☆★★★
		  ☆☆☆★★
		  ☆☆☆☆★
		*/
		i = 0;
		while (i < 5) {
			int j = 0;
			while (j < 5) {
				if (i > j) {
					System.out.print("☆");
				} else {
					System.out.print("★");
				}
				j++;
			}
			System.out.print("\n");
			i++;
		}
		
		System.out.println("5.-------------");
		/*
		  ★ 
		  ★★ 
		  ★★★ 
		  ★★★★ 
		  ★★★★★
		 */
		i = 0;
		while (i < 5) {
			int j = 0;
			while (j <= i) {
				System.out.printf("%s", "★"); 
				j++;
			}

			System.out.print("\n");
			i++;
		}
		
		System.out.println("6. [Quiz] -------------");
		/*
		★★★★★
		★★★★
		★★★
		★★
		★
		*/

		i = 0;
		while (i <= 5) {
			int j = i;
			while (j < 5) {
				System.out.printf("★"); 
				j++;
			}

			System.out.print("\n");
			i++;
		}
		

		 
	} // end main

} // end class
