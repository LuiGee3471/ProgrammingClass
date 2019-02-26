
public class Ex06_Operation {

	public static void main(String[] args) {
		int result = 100/100;
		System.out.println(result);
		
		result = 13 / 2;
		System.out.println(result);
		
		result = 13 % 2;
		System.out.println(result); // 나머지
		
		// 증가감 연산자 (++, --) 1씩 증가하거나 1씩 감소
		int i = 10;
		++i; // 전치 증가
		System.out.println(i);
		i++; // 후치 증가
		System.out.println(i);
		// 변수 한 개에 대해서 전치와 후치는 동일한 효과
		
		
		// Point 전치와 후치가 연산자와 결합하면 본질을 드러낸다.
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2; // j2 1 증가 후 연산
		System.out.println(result2);
		// i2 >> 5, j2 >> 5, result2 >> 10
		
		result2 = i2 + j2++;
		System.out.println(result2);
		System.out.println(j2);
		// i2 >> 5, j2 >> 6, result2 >> 10
		
		// Point 
		// Java의 연산 규칙
		// 정수의 모든 연산은 int로 변환 후 처리
		// byte + byte => 컴파일러는 int + int로 인지
		byte b = 100; // -128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c); // 101이 127 미만이기 때문에 여기서는 문제 없지만
		// 1. byte d = (byte)(b + c); (X)
		// 2. int d = b + c;          (O)
		System.out.println("d: " + d);
		
		// byte + short => int + int
		// char + char => int + int
		// Point : 연산에서 int보다 작은 타입은 int로 바꿔서 처리(long은 더 크기 때문에 제외)
		// byte, char, short => int로 바꾸어서 처리
		// byte + short => int + int >> 결과값 int
		// char + int => int + int >> 결과값 int
		// int + long => long + long >> 결과값 long
		
		// 정수와 실수의 연산 >> 무조건 실수
		// float + int => float + float >> 결과값 float
		// long + float => float + float >> 결과값 float
		// float + double => double + double >> 결과값 double
		
		float num2 = 10.45f;
		int num3 = 20;
		// num2 + num3
		int result5 = (int)(num2 + num3);
		System.out.println(result5);
		
		// char는 정수 타입 (내부적으로 정수값을 가지고 있다)
		char c2 = '!';
		char c3 = '!';
		
		// c2 + c3?
		// char result6 = c2 + c3; int = int + int
		int result6 = c2 + c3;
		System.out.println(result6); // 66 (!!가 아님)
		System.out.println((char)result6); // ASCII 코드값으로 되돌리기 A : 65, a : 97
		
		// 제어문
		// 중소기업 시험문제 (구구단) => 별찍기
		
		int sum = 0;
		for (int j = 1; j <= 100; j++) {
			// System.out.println(j);
			if (j % 2 == 0) {
				sum = sum + j;
			}
		}
		
		System.out.println("sum : " + sum);
		
		// == 연산자 (값(value) 비교 연산자)
		// JavaScript (===)
		
		if (10 == 10.0f) {
			System.out.println("True");
		} else {
			System.out.println("False");
		} // True (타입이 아니라 값을 비교한다.)
		
		// ! 부정연산자
		if ('A' != 65) {
			System.out.println("같은 값이 아냐");
		} else {
			System.out.println("같은 값이야");
		}
		
		// 암기
		// 제어문처럼 쓰는 연산자(삼항연산자)
		int p = 10;
		int k = -10;
		int result8 = (p==k)? p : k;
		String result9 = (p==k)? "P" : "K";
		// ? 앞의 조건식이 true라면 : 앞에 있는 값을
		// ? 앞의 조건식이 false라면 : 뒤에 있는 값을
		System.out.println("result8: " + result8);
		System.out.println("result9: " + result9);
		
		if (p == k) {
			result8 = p;
		} else {
			result8 = k;
		}
		
		/*
		 진리표
		 0: false
		 1: true
		       OR   AND
		 0 0   0     0
		 0 1   1     0
		 1 0   1     0
		 1 1   1     1
		 
		 sql(oracle)
		 select *
		 from emp
		 where job = 'sales' or sal > 2000;
		  
		 */
		// 연산자 ( | (or), & (and) )
		// 0과 1의 bit 연산
		int x = 3;
		int y = 5;
		System.out.println("x|y : " + (x|y));
		System.out.println("x&y : " + (x&y));
		// 10진수 3,5를 2진수 값으로 변환
		// 128 64 32 16 8 4 2 1 (2진수)
		//   0  0  0  0 0 0 1 1 (3)
		//   0  0  0  0 0 1 0 1 (5)
		//   0  0  0  0 0 1 1 1 (3|5 = 7)
		//   0  0  0  0 0 0 0 1 (3&5 = 1)
		
		// POINT 논리연산 ( ||(or), &&(and) ) 연산자 return boolean
		// 중요한 이유
		// if (10 > 0 && -1 > 1 && 100 > 2 && 1 > -1) { 실행문 }
		// if (10 > 0 || -1 > 1 || 100 > 2 || 1 > -1) { 실행문 }
		// short circuit
		
		
	}

}
