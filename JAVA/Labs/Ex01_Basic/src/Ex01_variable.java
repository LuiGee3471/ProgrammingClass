// main 함수를 가지고 있는 클래스 -> 프로그램의 시작점을 가지고 있는 클래스
// C# : public static void Main()
// 변수 : variable
// 변수 Scope (유효범위): 선언되는 위치에 따라서
// 1. instance variable : 객체변수 class Test{ private int age; }
// 2. local variable    : 지역변수 (함수 안에 선언된 변수)
// class Test { public void run() {int speed = 0;} }
// 지역변수는 항상 초기값이 필요하다
// 3. static variable   : 공유변수 (객체 간 공유 자원)


//설계도 == 클래스 == 타입(사용자 정의 타입)


class Test {
	int iv; // instance variable (클래스 안)
	        // 이 변수는 초기화를 하지 않아도 된다. 기본값(default value)을 가지고 있다.
	        // Why: 초기화를 하지 않아도 사용 가능하게 했을까? 객체마다 다른 값을 가지게 하기 위해
	
	void print() {
		int i = 100; // 함수 안에 있는 변수 : 지역변수
		             // 함수가 호출되면 그때 stack 메모리에 생성되고 함수가 종료되면 같이 소멸된다
		             // 지역변수는 반드시 초기화를 해야 한다. (암기) <- Stack 메모리에 생성되는 데이터는 초기화 필요
		System.out.println(i);
	}
	
	void write() {
		System.out.println("iv 전역변수(객체): " + iv);
		// System.out.println(i);
		// Error : i 변수의 scope : print() 함수 내부
		int i = 200; // 언제라도 가능
		// int iv = 300; Error는 아니지만 의미가 없다.
	}
	
	String print2(int i) {
		return "포켓몬";
	}
}

public class Ex01_variable { 

	public static void main(String[] args) {
		int s = 5; // local variable 지역변수(main함수 안) >> 선언과 동시에 초기화
		System.out.println("지역변수 s : " + s);
		
		int s2;   // 선언부
		s2 = 100; // 초기화
		System.out.println(s2);
		
		s2 = 300; // Overwrite
	}

}
