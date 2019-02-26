/*
 * 객체 지향 언어의 특징
 * 상속, 캡슐화, 다형성
 * 
 * 캡슐화 (은닉화) -> private
 * 
 * [method overloading]
 * [하나의 이름]으로 [여러 가지 기능]을 하는 함수
 * ex) System.out.println()
 * 특징 : 오버로딩은 성능을 향상시키지는 않는다.
 *        개발자가 편하게 사용하게 하려고
 *        설계할 때 어떤 점을 고려할까? 함수의 활용이 많은 경우
 * 
 * 문법 : 함수의 이름은 같고 parameter의 개수와 타입을 달리하는 방법
 * 1. 함수의 이름이 같아야 한다.
 * 2. parameter의 개수 또는 타입이 달라야 한다.
 * 3. return 타입은 오버로딩과 무관하다.
 * 4. parameter의 순서가 다름을 인정한다.
 */

class Human {
	String name;
	int age;
}

class OverTest {

	void add(Human h) { // class == Type
		h.name = "홍길동";
		h.age = 100;
		System.out.println(h);
	}

	int add(int i) {
		return 100 + i;
	}

	String add(String s) {
		return "hello " + s;
	}

	// void add(int k) {} 안돼요 (parameter type 충돌)

	int add(int i, int j) {
		return i + j;
	}

	void add(int i, String s) {
		System.out.println("오버로딩");
	}

	void add(String s, int i) { // parameter의 순서가 다름을 인정
		System.out.println("순서 인정 : overloading");
	}

	// 배열(Array)
	// int[] source = { 1, 2, 3, 4, 5 };

	int[] add(int[] param) { // parameter로 int배열의 주소값을 받겠다
		int[] target = new int[param.length];
		for (int i = 0; i < param.length; i++) {
			target[i] = param[i] + 1;
		}
		return target; // int 타입의 배열의 주소값을 return
	}
	
	int[] add(int[] so, int[] so2) {
		int[] arr = new int[so.length > so2.length ? so.length : so2.length];
//		if (so.length < so2.length) {
//			arr = new int[so.length];
//		} else {
//			arr = new int[so2.length];
//		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = so[i] * so2[i];
		} 
		return arr;
	}
}

public class Ex11_Method_Overloading {

	public static void main(String[] args) {
		System.out.println(100);
		System.out.println("HELLO");

		OverTest ot = new OverTest();
		System.out.println(ot.add(100));
		// System.out.println(ot.add(3.1f)); // add(float f) 존재하지 않음

		ot.add(100, "H");

		Human human = new Human();
		ot.add(human);
		System.out.println(human.name);
		System.out.println(human.age);

		ot.add(new Human());

		OverTest ot2 = new OverTest();
		// int 타입 배열의 주소를 주어야 함
		int[] source = { 10, 20, 30, 40, 50 };
		int[] target = ot2.add(source); // source = 주소값
		for (int i = 0; i < target.length; i++) {
			System.out.println(target[i]);
		}
		
		int[] so1 = { 1, 3, 5, 7, 9 };
		int[] so2 = { 2, 4, 6, 8, 10, 12 };
		int[] target2 = ot2.add(so1, so2);
		for (int value : target2) {
			System.out.println(value);
		}
		
	}

}
