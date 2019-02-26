/*
 * 추상 클래스 (설계 입장)
 * 미완성 설계도
 * 미완성 클래스(완성된 코드 + 미완성 코드)
 * - 미완성 코드 : 미완성 함수 (함수가 실행 블럭을 가지고 있지 않다.)
 * - ex) public void print();    >> {} 없음
 * 미완성 클래스 : new를 통해서 객체 생성 불가능
 * 
 * 1. 추상 클래스는 스스로 객체 생성 불가 (new 사용 불가)
 * 2. 추상 클래스는 결국 완성된 클래스로 만들어서 사용 -> 상속을 통해서...
 *   - 미완성 자원(추상 함수)을 완성해라(구현) -> 재정의 -> override
 *   
 *   
 * Why : 추상 클래스를 왜 만들었을까?
 *     : 강제적 구현을 목적 (설계자의 입장)  
 */

abstract class Abclass {
	int pos;
	void run() {
		pos++;
	}
	// 위 코드는 완성된 코드입니다
	
	// 추상 함수
	abstract void stop(); // 실행블럭이 없음
}

class Child extends Abclass {
	@Override
	void stop() { // stop 함수를 재정의
		this.pos = 0;
		System.out.println("stop : " + this.pos);
	}
	
}

public class Ex01_abstract_class {

	public static void main(String[] args) {
		// Abclass ab = new Abclass(); 불가능
		Child ch = new Child();
		ch.run();
		ch.stop();
		
		Abclass ab = ch; // 다형성
		ab.run();
		ab.run();
		System.out.println("현재 pos : " + ab.pos);
		ab.stop(); // 재정의된 자식 클래스의 stop 함수 호출
	}

}
