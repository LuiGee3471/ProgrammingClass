import java.util.Scanner;

// 반복문(while, do-while)
public class Ex11_Statement {
	public static void main(String[] args) {
		
		int i = 10;
		while (i >= 10) { // 조건이 true일 동안
			i--;
			System.out.println(i);
		}
		
		// 1~100까지의 합
		int sum = 0;
	    int j = 1;
	    while (j <= 100) {
	    	// j++; // 주의: 순서에 따라 결과가 다르다.
	    	sum += j;
	    	j++;
	    }
	    System.out.println("1~100까지의 합: " + sum);
	    
	    // while로 구구단
	    int first = 2;
	    int second;
	    while (first < 10) {
	    	second = 1;
	    	while (second < 10) {
	    		System.out.printf("%d X %d = %d\t", first, second, first * second);
	    		second++;
	    	}
	    	System.out.println();
	    	first++;
	    }
	    
	    // do-while : 강제적 실행 (무조건 한 번 실행, 그 이후 조건 판단)
	    // do {실행문} while (조건식)
	    // 메뉴 구성
	    // 1. 인사
	    // 2. 급여
	    // 1번 입력하면 인사... 2번 입력하면 급여...3번 입력하면 다시 입력 강제
	    
	    Scanner sc = new Scanner(System.in);
	    int inputdata = 0;
	    do {
	    	System.out.println("숫자를 입력해(0~10)");
	    	inputdata = Integer.parseInt(sc.nextLine());
	    } while (inputdata > 10); // while이 true면 계속 반복
	    // while문 탈출은 조건이 false일 때
	    System.out.println("당신이 입력한 숫자는 : " + inputdata);
	}
}
