package kr.or.bit;

// protected의 목적 : 상속 관계에서 재정의
// 당신이 필요하다면 재정의해

//공통 : 새는 날 수 있다, 새는 빠르다

public class Bird {
	
	public void fly() {
		System.out.println("i am fly");
	}
	
	//재정의했으면
	protected void movefast() {
		fly();
	}

}
