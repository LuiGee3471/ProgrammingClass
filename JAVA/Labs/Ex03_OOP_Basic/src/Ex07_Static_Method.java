// static method

class StaticClass {
	int iv;
	static int cv;
	
	// 일반함수
	void m() {
		// 일반함수 m()에서 iv 값을 처리할 수 있다.
		iv = 100;
		// 일반함수 m()에서 cv 값을 처리할 수 있다.
		// Point : static 자원은 일반 자원보다 항상 먼저 메모리에 올라간다. 
		cv = 200;
		// StaticClass.cv = 200; <= 가능은 하다.
		
		System.out.println("iv : " + iv + " , cv : " + cv);
	}
	
	static void sm() {
		// 일반 자원인 iv 자원(member field)을 사용할 수 없다.
		// iv = 200; sm() 함수가 항상 일반 자원보다 memory에 먼저 올라가기 때문(iv는 아직 로드되지 않음)
		// 생성 시점의 문제
		cv = 200;
		// 끼리끼리 놀면 에러가 없다.
	}
}

/*
 * 일반함수 : 일반자원과 static 자원 모두 사용 가능
 * static 함수 : static 자원만 사용 가능 (static 끼리만)
 */


public class Ex07_Static_Method {

	public static void main(String[] args) {
		//StaticClass s = new StaticClass();
		//s.m();
		//s.sm();
		
		StaticClass.sm();
	}
}
