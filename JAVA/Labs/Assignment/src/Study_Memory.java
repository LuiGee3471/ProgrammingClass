class Tv {
	int ch;
	String company;
}

public class Study_Memory {

	public static void tvInfo(Tv tv) {
		System.out.println("현재 채널 : " + tv.ch + "번, 제조사 : " + tv.company);
	}

	public static void changeCh(int i) {
		System.out.println("현재 채널 : " + i);
		i = 24;
		System.out.println("바꾼 채널 : " + i);
	}

	public static void changeCom(Tv tv) {
		System.out.println("현재 제조사 : " + tv.company);
		tv.company = "LG";
		System.out.println("다음 제조사 : " + tv.company);
	}

	public static void main(String[] args) {
		Tv a = new Tv();
		a.ch = 16;
		a.company = "삼성";
		tvInfo(a);

		changeCh(16);
		tvInfo(a);

		changeCom(a);
		tvInfo(a);
	}
}
