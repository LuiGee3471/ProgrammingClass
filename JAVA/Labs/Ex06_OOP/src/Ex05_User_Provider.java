// 1. 인터페이스를 [다형성] 입장에서 접근 : 인터페이스는 무조건 부모 타입이다
// 2. 서로 연관성이 없는 클래스에 대해서 하나로 묶는 기능 : 부모가 동일하다
// 3. 사용자와 제공자의 관계

// User(사용자) : Provider(제공자)

// 1. 상속(is-a)  : A extends B
// 2. 포함(has-a) : member field 형태로 A라는 클래스 안에 클래스 B가 들어오는 것 >> 연관 관계
                 // class A { B b; }
// 3. 포함(has-a) : 함수 안에서 객체의 생성, 할당, return >> 의존 관계
// 연관 관계
// 학교는 학생을 가지고 있다   : class School { Student st; }, class Student {} >> 집합 연관 -- 생성 소멸 시점이 다름
// 자동차는 엔진을 가지고 있다 : class Car { Engine en = new Engine(); }        >> 복합 연관 -- 생성 소멸 시점이 같음

/*
 * class B {}
 * class A {
 *     int i;
 *     
 *     void print(B b) { // method 안에서 => 의존
 *     }
 *     
 *     void print() {    // method 안에서 => 의존 
 *         B b = new B();
 *     }
 * }
 */

interface Icall {
	void m();
}

class D implements Icall {
	@Override
	public void m() {
		System.out.println("D Icall 인터페이스의 m() 구현");
	}
}

class F implements Icall {
	@Override
	public void m() {
		System.out.println("F Icall 인터페이스의 m() 구현");
	}
}

// 현대적인 프로그래밍 기법 : 다형성 (인터페이스)
// 간접적인 기법(유연하다) 대신 추상적이다

class C {
	void method(Icall ic) { // 오늘의 핵심
		ic.m();
	}
}

public class Ex05_User_Provider {

	public static void main(String[] args) {
		C c = new C();
		c.method(new D());
		c.method(new F());
	}

}
