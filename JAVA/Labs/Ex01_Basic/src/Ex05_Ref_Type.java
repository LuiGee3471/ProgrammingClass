// 클래스는 설계도이다, 클래스는 타입이다
// 클래스 == 설계도 == 타입
// 클래스는 반드시 메모리에 올려야 사용할 수 있다. (설계도를 기반으로 땅에 아파트를 지어야 한다.)
// new를 통해서 설계도를 기반으로 구체화된 사물을 만든다. (객체를 만든다.)

// 설계도 (속성(상태정보) + 행위(기능))

class Apt2 {
	int door = 10; // 객체변수(instance variable) : 초기화가 반드시 필요하지는 않다.
	int window; 
}

public class Ex05_Ref_Type {
	
	public static void main(String[] args) {
		int i = 100; // i는 100이라는 값을 갖는다.
		
		// Apt2 타입(사용자 정의 타입 : 여러 개의 타입을 모아 넣은 큰 타입)
		Apt2 lg = new Apt2(); // lg라는 변수는 Apt2 객체의 주소값을 갖는다.
		// lg : 주소값을 가지고 있는 변수 : 참조 변수, 객체 변수
		System.out.println("lg 변수의 값은 주소: " + lg);
		
		Apt2 ssapt = lg; // lg가 갖는 주소를 ssapt에게 전달
		// ssapt와 lg는 같은 집에 살고 있다.
		// 참조변수의 할당은 주소값 할당
		ssapt.window = 50;
		
		System.out.println("창문의 개수는: " + lg.window);
	}
	
}
