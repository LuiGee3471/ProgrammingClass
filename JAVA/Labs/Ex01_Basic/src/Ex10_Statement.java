
public class Ex10_Statement {
	public static void main(String[] args) {
		/* 
		 * 제어문
		 * 조건문(분기문): if(단일, else, else if), switch(case, break, default)
		 * 반복문: for(반복횟수 명확), while(조건이 일치하면 무한), do-while(강제 실행)
		 * break(블럭 탈출), continue(아래 구문을 생략)
		 */
		
		int count = 0; // local variable(초기화)
		if (count < 1) {
			System.out.println("True");
		}
		
		if (count < 1) System.out.println("True {생략}");
		
		char data = 'A'; // 조건값으로 [숫자], [char], [String] 가능
		switch (data) {
		case 'A':
			System.out.println("문자비교");
			break;
		default:
			System.out.println("default");
		}
		
		// 반복문
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			// System.out.println("i : " + i);
			sum += i;
		}
		System.out.println("1부터 10까지의 합: " + sum);
		
		// for문을 사용해서 1~10까지의 홀수의 합을 구해보세요
		int sum2 = 0;
		for (int i = 1; i <= 10; i += 2) {
			sum2 += i;
		}
		System.out.println("1부터 10까지 홀수의 합 : " + sum2);
		
		// 1~100까지 짝수의 합 (if문 사용)
		int sum3 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum3 += i;
			}
		}
		System.out.println("1부터 100까지의 짝수의 합 : " + sum3);
		
		// 입사 시험의 가장 대표적인 문제 : 구구단 (변형)
		// for(while)문 => 중첩 for문 => 행렬
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %d\t", i, j, i*j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// KEY POINT (break(탈출), continue(스킵))
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				// if (i == j)
				//	continue;
				if (i == j) 
					break;
				System.out.printf("%s\t", "*");
				// System.out.printf("%d X %d = %d\t", i, j, i*j);
				
			}
			System.out.println();
		}
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j < i; j++) { // 조건 j < i
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 100; i >= 0; i--) {
			System.out.println("i : " + i);
		}
		
		// 피보나치
		System.out.println("피보나치");
		int a = 0, b = 1, c = 0;
		for (int i = 0; i < 10; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(" " + c);
		}
	}
}
