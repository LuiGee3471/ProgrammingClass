package kr.or.bit;
// Singleton
// 디자인 패턴 (생성 패턴 >> new...)
// 싱글톤 : 객체를 하나만 만들어서 공유하겠다
// 하나의 객체를 생성해서 공유
// 이 패턴을 사용하면 하나의 객체를 사용한다는 보장

// static: 객체 간 공유 자원

//JDBC (DB 연동하는 작업 시 사례를)

public class Singleton {
	private static Singleton p; 
	// Singleton 사용하면 method area에 올라가 있다
	// private : 접근 불가
	private Singleton() {} // 생성자가 private : 객체 생성 불가
	
	public static Singleton getInstance() {
		if (p == null) {
			p = new Singleton(); // 생성자 호출(private이라도 클래스 내부에서는 접근 가능)
		}
		return p;
	}
}
