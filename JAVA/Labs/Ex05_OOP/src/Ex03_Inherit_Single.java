class Tv {
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

class Vcr { // 비디오 플레이어
	boolean power;
	
	void power() {
		this.power = !this.power;
	}
	
	void play() {
		System.out.println("재생하기");
	}
	
	void stop() {
		System.out.println("정지");
	}
	
	void rew() {}
	void ff() {}
}

// 설계도: TV, VCR을 가지고 있다
// VCR 기능과 TV 기능을 다 갖춘 설계도를 작성해주세요.
// TvVcr 설계도 제품을 만들고 싶어요

// 설계도 재사용
// class TvVcr extends TV, Vcr {} (X : 다중 상속)

// Tv extends Vcr
// TvVcr extends Tv (계층적 상속)
// TvVcr 클래스 : Tv, Vcr 둘 다 포함

// 전제조건 상속은 한 번만 사용
// 상속, 포함
// 고민 : TvVcr을 만들 때 누구를 상속하고 누구를 포함할 것인가

// 주 기능(TV)과 보조 기능(VCR)
// 비중이 높은 클래스를 상속해라

class TvVcr extends Tv {
	Vcr vcr;
	
	TvVcr() {
		vcr = new Vcr();
	}
}

public class Ex03_Inherit_Single {

	public static void main(String[] args) {
		TvVcr t = new TvVcr();
		t.power();
		System.out.println("Tv 전원 상태 : " + t.power);
		
		t.chUp();
		t.chUp();
		System.out.println("Tv 채널 정보 : " + t.ch);
		
		// 비디오 전원
		t.vcr.power();
		System.out.println(t.vcr.power);
		
		t.vcr.play();
		t.vcr.stop();
		t.vcr.power();
		
		t.power();
		System.out.println("Tv 전원 : " + t.power);
		System.out.println("비디오 전원 : " + t.vcr.power);
	}

}
