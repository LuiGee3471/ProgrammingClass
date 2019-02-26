package kr.or.bit;

/*
 * 함수 : 기능의 최소 단위(method)
 * 
 * 함수의 종류
 * void (돌려주는 값이 없다) : return value가 없다
 * return Type : [8가지 기본 타입], String, 사용자 정의 클래스, Array + Collection + Interface
 * * 함수가 return 타입을 가지고 있으면 (ex public int calc() { return 100; })
 * ** 반드시 실행 블럭 안에 return 구문을 가지고 있어야 한다.
 * 
 * * parameter : [8가지 기본 타입], String, 사용자 정의 클래스, Array + Collection + Interface
 * 
 * 1. void, parameter 존재          : public void print(String str) { System.out.println(str); }
 * 2. void, parameter 존재하지 않음 : public void print() { System.out.println("hello";) }
 * 3. return 타입 존재, parameter 존재          : public int call(int i) { return i + 100; }
 * 4. return 타입 존재, parameter 존재하지 않음 : public int call() { return 1000; }
 * 
 * 함수(method)는 반드시 호출(Call)되어야 실행한다.
 */

public class FunctionClass {

	public void m() { // 함수의 이름은 의미있는 단어의 조합 : getChannelNumber()
		System.out.println("일반함수 : void, param(X)");
	}

	public void m2(int i) {
		System.out.println("param value : " + i);
		System.out.println("일반함수 : void, param(O)");
	}

	public int m3() {
		return 100;
	}

	public int m4(int data) {
		return data + 100;
	}

	// private : 클래스 내부에서만 사용 (다른 함수 돕는 함수)
	// 다른 여러 개의 함수가 가지는 공통적인 내용을 한 곳의 함수에 모아서 기능 제공
	// 유지·보수 용이
	private int operationMethod(int data) {
		return data * 100;
	}

	public int sum(int data) {
		return operationMethod(data); // 적당한 코드
	}

	public int sum2(int data) {
		int result = operationMethod(data);
		return result;
	}

	// 확장함수 (parameter가 여러 개)

	public int sum3(int i, int j, int k) {
		return i + j + k; // 안쪽의 로직은 마음대로
	}

	// Quiz
	// a와 b 둘 중에 큰 값을 return하는 함수를 만드세요.
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
	// return은 무조건 하나만 쓰자
	
	public String concat(String s, String s2, String s3) {
		return s + "/" + s2 + "/" + s3;
	}
	
	public void print(int a) {
		System.out.println(a);
	}
	
//	public void maxp(int a, int b) {
//		int a = (a > b) ? print(a) : print(b);
//	}
	
	// 클래스 == 타입이다
	
	// public int call() { return 100; }
    // public Tv call() { Tv t  = new Tv(); return t; }
	// public Tv call() { return new Tv(); }
	// Tv tt = new Tv();
	// public void call(Tv t) { System.out.println(t.name); }
	// tt.name = "삼성";
	// call(tt); // tt.name => "삼성"
	
	public Tv objMethod() { // Tv 타입을 갖는 주소값을 return하는 함수
		Tv v = new Tv();    // heap에 Tv 객체 만들고 주소값 tt에 할당
		v.brandName = "XCanvas";
		v.ch = 1;
	    return v;           // 변수 v에 할당된 Tv 타입의 주소값을 return (brandName = "Xcanvas", ch = 1의 값을 가진)
	}
	
	public Tv objMethod2() { // Tv 타입을 갖는 주소값을 return하는 함수
	    return new Tv();     // heap에 객체 만들고 주소값을 바로 return
	}
	
	public void objMethod3(Tv t) { // parameter에 Tv 타입의 주소값을 받는다
		System.out.println("Tv 타입 정보 : " + t);
		System.out.println("채널 정보 : " + t.ch);
		System.out.println("브랜드 이름 : " + t.brandName);
	}
}
