// 2. this >> 객체 >> 생성자를 호출 가능

// 원칙 : 생성자는 객체 생성 시 한 개만 호출된다.
// 예외적으로 this를 사용하면 여러 개의 생성자 함수를 호출할 수 있다.

// 생성자 안의 코드가 반복적으로 사용
// default : this.color ...
// overloading : this.color ...

// 할당은 한 번

class Zcar {
	String color;
	String gearType;
	int door;
	
	Zcar() {
		// this.color = "red";
		// this.gearType = "auto";
		// this.door = 4;
		
		// new Zcar()
		//     this()
		this("red", "auto", 4); // 자기 자신을 호출(생성자 함수를 호출)
		
		System.out.println("default constructor");
	}
	
	Zcar(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		System.out.println("Overloading constructor");
	}
	
	void print() {
		System.out.println(this.color + ", " + this.gearType + ", " + this.door);
	}
}

// 자동차 영업사원 (자동차 판매 시 기본 옵션) : default 옵션, 기본값...

class Zcar2 {
	String color;
	String gearType;
	int door;
	
	Zcar2() { // 기본 옵션
		this("red", 2);
		System.out.println("default constructor");
	}
	
	Zcar2(String color, int door) { // 옵션 A : 차량의 색상과 문의 개수 선택 가능
		this(color, "auto", door);
		System.out.println("overloading constructor param 2개");
	}
	
	Zcar2(String color, String gearType, int door) { // 옵션 B : 차량의 색상, 기어, 문의 개수 선택 가능
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		System.out.println("overloading constructor param 3개");
	}
	
	void print() {
		System.out.println(this.color + ", " + this.gearType + ", " + this.door);
	}
}

public class Ex16_this_Constructor_Call {

	public static void main(String[] args) {
		Zcar z = new Zcar(); // 기본값
		z.print();
		
		Zcar z2 = new Zcar("blue", "auto", 10); // Overloading
		z2.print();
		
		Zcar2 car = new Zcar2();
		car.print();
		
		Zcar2 car2 = new Zcar2("gold", 2);
		car2.print();
		
		Zcar2 car3 = new Zcar2("pink", "manual", 5);
		car3.print();
	}
	
}
