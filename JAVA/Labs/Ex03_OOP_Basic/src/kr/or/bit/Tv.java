package kr.or.bit;

/*
 * 요구사항 정의
 * TV는 채널 정보를 가지고 있다 (예를 들면, 1~250번 채널)
 * TV는 브랜드 이름을 가지고 있다 (예를 들면, 삼성, LG 등등)
 * TV는 채널 전환 기능을 가지고 있다 (채널을 변경할 수 있다, 한 단계씩만 가능)
 * 기능 2개 필요 (++, --)
 * Tv의 전원은 On, Off할 수 있다.
 */

public class Tv {
	public int ch; // public int ch = 1;
	public String brandName;
	public boolean power;

	public void chUp() {
		// member field 상태값
		ch++;
	}

	public void chDown() {
		ch--;
	}
	
	public void powerOn() {
		power = true;
	}
	
	public void powerOff() {
		power = false;
	}
}
