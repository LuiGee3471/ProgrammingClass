import java.util.Scanner;

public class Ex09_Operation_Quiz {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first, second, result;
		String opr;
		
		System.out.print("> 입력값: ");
		first = Integer.parseInt(sc.nextLine());
		System.out.print("> 입력값(기호): ");
		opr = sc.nextLine();
		System.out.print("> 입력값: ");
		second = Integer.parseInt(sc.nextLine());
		
		// 문자 비교는 equals 함수를 이용한다.
		if (opr.equals("+")) {
			result = first + second;
		} else if (opr.equals("-")) {
			result = first - second;
		} else if (opr.equals("*")) {
			result = first * second;
		} else if (opr.equals("/")) {
			result = first / second;
		} else {
			System.out.println("올바른 연산자를 입력해주세요.(+, -, *, /)");
			//key point(여기서는 main 함수)
			//return 키워드 : [함수단위]의 종결자 > main 함수 탈출 > 종료
			return;
		}
		
		System.out.println("> 연산결과: " + result);
	}
}
