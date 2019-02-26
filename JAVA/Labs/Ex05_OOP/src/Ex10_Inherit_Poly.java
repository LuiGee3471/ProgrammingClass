// 다형성(상속 관계에서)
// 다형성 : 여러 가지 성질(형태)를 가질 수 있는 능력
// Tip) C# 다형성 안에 overloading과 override도 포함

// Java : [상속 관계]에서 하나의 참조 변수가 여러 개의 타입을 가질 수 있다
// 여기서 말하는 참조변수는 부모타입을 이야기한다.
// 조상 클래스 타입의 참조변수로 여러 개의 자식 클래스 객체의 주소를 가질 수 있다.

// Java : 자식은 부모에게 조건 없이 드린다. (현실 세계와 반대)

class Tv2 { // 부모(일반화되고 추상화된 공통 자원)
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	
	void chUp() {
		ch++;
	}
	
	void chDown() {
		ch--;
	}
	
}

class CapTv extends Tv2 { // 자기만의 고유한 기능 (구체화, 특수화)
	String text;
	String caption() {
		return this.text = "현재 자막 처리 중입니다.";
	}
	
}

public class Ex10_Inherit_Poly {

	public static void main(String[] args) {
		CapTv tv = new CapTv();
		tv.power();
		System.out.println("전원정보 : " + tv.power);
		tv.chUp();
		System.out.println("채널정보 : " + tv.ch);
		System.out.println("자막처리 : " + tv.caption());
		// 여기까지 현재 학습
		
		// Tv2 tv2 = new Tv2();
		// heap 메모리에 Tv2 타입 객체가 로드되어있다
		
		// Tv2 tv2 = new Tv2(); 이미 있는데 굳이?
		
		Tv2 tv2 = tv; // 자식 타입의 주소를 부모타입에게.. 조건 없이
		// 내것만(부모 것만)
		System.out.println("주소값 : " + tv.toString());
		System.out.println("주소값 : " + tv2.toString());
	
	}

}
