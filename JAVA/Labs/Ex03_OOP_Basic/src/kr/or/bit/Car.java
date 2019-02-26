package kr.or.bit;
/*
 * 접근자(한정자, 수정자) : modifier
 * public  : 공유 => 폴더(package) 구분 없이 모든 자원 공유 
 * private : 개인 => 클래스 내부에서는 공유, 참조변수(객체)는 사용 불가능한 자원
 *  ㄴ 객체 지향의 특징 중 캡슐화(은닉화)를 구현
 * 
 * 1. 클래스 내부에서 private int age;
 * 1.1 private : age의 직접 할당을 막고 간접할당을 통해서 자원을 보호
 * 1.2 설계자의 의도 : 원하는 값만 처리되도록 하겠다. ex) age 변수에 1~200 정수만 허용 > 별도의 함수를 통해서 구현
 * 1.3 캡슐화된 자원의 간접할당을 처리하는 특수한 함수 (Setter&Getter)
 *       ㄴ private member field를 간접적으로 read, write할 수 있는 함수다.
 *       
 * 1.4 private int age;
 *     - setter() 함수
 *     - getter() 함수
 *     
 *     - 필요에 따라서는 setter만, getter만 구현해도 상관없다.
 */
public class Car {
	private int window;
	private int speed;
	
	// 자동완성 기능
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		// 간접할당
		if (speed < 0) {
		    this.speed = 0;
		} else {
			this.speed = speed;
		}
	}

	public int getWindow() { // read
		return window;
	}
	
	public void setWindow(int window) { // write
		this.window = window;
	}
    
	// 필요하다면 추가 함수(기능)
	public void speedUp() {
		speed += 10;
	}
	
	public void speedDown() {
		if (speed > 0) {
			speed += 5;
		} else {
			speed = 0;
		}
	}
}
