// this
// 1. 객체 자신을 가리키는 this
// 설계도에게 생성될 것이라 가정하고 설계도의 자원을 명시하겠다 
// 2. this = 객체 자신 : 생성자 호출이 가능하다
// 원칙 : 객체 생성 시 생성자 함수는 하나만 호출 가능
// 예외적으로 this를 사용하면 여러 개의 생성자 호출 가능

class Test6 {
	int i;
	int j;
	Test6() {}
	Test6(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public void print() {
		System.out.println(i + ", " + j);
	}
	
	public void thisPrint() {
		System.out.println(this);
	}
}

class SoCar {
	String color;
	String gearType;
	int door;
	
	SoCar() {
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	SoCar(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + " / " + this.gearType + " / " + this.door);
	}
}

public class Ex15_this {
	public static void main(String[] args) {
		Test6 t6 = new Test6(100, 200);
		t6.print();
		System.out.println("t6: " + t6);
		t6.thisPrint();
		
		SoCar so = new SoCar();
		so.print();
		
		SoCar so2 = new SoCar("blue", "auto", 4);
		so2.print();
	}
}
