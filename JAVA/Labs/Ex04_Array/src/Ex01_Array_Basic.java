import java.util.Arrays;

// 배열(Array)은 객체다
public class Ex01_Array_Basic {

	public static void main(String[] args) {
		int[] score = new int[3];
		System.out.println("score변수 (참조) : " + score); // 배열 시작값의 주소
		System.out.println(score[0]);
		score[1] = 333;
		System.out.println(score[1]);
		System.out.println(score[2]);
		
		// Array는 각각의 방을 가지고 있다. (각 방의 크기는(int) 4byte)
		// 각각의 방에 접근은 첨자(index)로 한다. 방 번호의 시작은 0이다.
		// score[0], score[1], score[2]
		// 배열의 개수 : length == 3;
		// 배열의 마지막 첨자 값 == length - 1;
		// 배열의 타입의 default 값을 가진다.
		
		// score[3] = 500;
		// 예외(Exception 발생) >> 프로그램 강제 종료
		// java.lang.ArrayIndexOutOfBoundsException
		// 자주 보는 에러
		
		// Array와 궁합이 제일 좋은 제어문은 for
		for (int i = 0; i < 3; i++) {
			System.out.printf("score[%d] = %d\t", i, score[i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] = %d\t", i, score[i]);
		}
		
		System.out.println();
		// Array 사용을 도와주는 보조 클래스(helper 클래스)
		String result = Arrays.toString(score); // [0, 333, 0]
		System.out.println(result);
		
		score[0] = 666;
		result = Arrays.toString(score);
		System.out.println(result);
		
		Arrays.sort(score); // 낮은 순으로 정렬(쓰지마 당분간)
		result = Arrays.toString(score);
		System.out.println(result);
		
		// Point (암기)
		
		// 배열을 만드는 3가지 방법
		int[] arr = new int[5]; // 기본 : 방의 크기 정의
		int[] arr2 = new int[] {100, 200, 300}; // 값(초기값)을 정의해서 배열 만들기
		int[] arr3 = {11, 12, 13, 14, 15}; // 값만 설정 (컴파일러가 내부적으로 new를 사용)
		
		// JavaScript : var cars = ["Saab", "Volvo", "BMW"];
		
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("[" + i  + "]" + " : " + arr3[i]);
		}
		
		// 선언과 할당 분리 가능
		
		int[] arr4; // 배열 선언 (기본값 null)
		// arr4 = {1,2,3}; 선언 할당 분리할 때에는 사용 불가능
		arr4 = new int[] {21, 22, 23, 24, 25};
		
		int[] arr5 = arr4; // 주소값 할당
		System.out.println(arr4 == arr5);
		
		// 배열은 8가지 기본 타입 + String + 사용자 정의 클래스 ....
		char[] ch = new char[10]; // default 빈 문자 '\u0000'
		for (int i = 0; i < ch.length; i++) {
			System.out.println(">" + ch[i] + "<");
		}
	}
}
