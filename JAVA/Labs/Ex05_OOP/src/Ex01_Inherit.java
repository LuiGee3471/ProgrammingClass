/*
 * 객체지향 언어(OOP)의 3대 특징
 * 상속
 * 다형성
 * 캡슐화(은닉화) : private
 * 
 * 1. 상속
 * Java > Child extends Base
 * C#   > Child : Base
 * 
 * 2. 특징
 * - 다중 상속 불가능 (복잡성 증가)
 * - 단일 상속 원칙 (계층적 상속을 사용해서 다중 상속을 구현)
 * - 다중 상속을 지원하는 것은 유일하게 Interface만
 * 
 * 3. 의미
 * 진정한 의미 : [재사용성] >> 반복 코드를 사용하지 않도록 >> 공통 코드는 부모가 가지고 있다
 * 단점 : 초기 설계 비용이 많이 들어간다
 * 
 * 재사용성 >> 설계할 때 고려 >> 비용적 측면(시간 등) 고려
 */

class GrandFather {
	public int gmoney = 5000;
	private int pmoney = 50000; // 상속 관계 접근 불가능
	                            // 참조 변수 접근 불가능
	public GrandFather() {
		System.out.println("할아버지");
	}
}

class Father extends GrandFather {
	public int fmoney = 1000;
	public Father() {
		System.out.println("아빠");
	}
}

class Child extends Father {
	public int cmoney = 100;
	public Child() {
		System.out.println("아이");
	}
}

public class Ex01_Inherit {

	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.gmoney);
		System.out.println(c.fmoney);
		System.out.println(c.cmoney);
		// System.out.println(c.pmoney); // 접근 불가
	}
	
}
