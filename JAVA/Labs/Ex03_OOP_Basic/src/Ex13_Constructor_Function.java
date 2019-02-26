import kr.or.bit.Book;

/*
 * 생성자 함수 (Constructor) : 초기화(member field) 함수
 * 1. 특수한 목적을 가지는 함수 : 초기화
 * 2. 초기화(instance variable : member field)
 * 
 * 일반 함수와 다른 점
 * 1. 함수의 이름이 고정 : 클래스 이름과 동일해야 한다.
 * 2. 생성자 함수는 return Type이 없고 void도 없다 : default = void
 *    why : 생성 시점의 문제 : 이 함수는 객체 생성과 동시에 호출 => 값을 넘길 곳이 없다
 *    
 * 목적 : 생성되는 객체마다 다른 초기값을 주고 싶을 때
 * 
 * 생성자 함수 : Overload 가능 (param의 개수와 타입을 다르게 해서)\
 * 
 * class Car { int door; Car() { door = 10; } }
 * 시점 : Car c = new Car("color");
 * 1. Stack에 c 변수 생성 >> null
 * 2. Heap에 Car 객체 생성 >> 영역을 만들고 member field 생성 >> 생성자 함수 호출 (member field 초기화)
 * 3. class 생성 시 default 생성자는 생략 가능 (직접 설계하지 않아도 컴파일러가 알아서 생성)
 * 
 * Tip : 생성자 함수를 overloading하지 않으면 큰 의미가 없다
 * -- 설계자의 의도 파악 -- 
 * 
 * 
 */

class Car {
	String name;
	// 직접 구현하지 않아도 
	// 컴파일러는 생성자가 있다고 가정
	// Car() {} 생략
}

class Car2 {
	String name;
	Car2() { // default constructor(생성자 함수)
		System.out.println("나는 생성자 함수");
		System.out.println("before : " + name);
		name = "pony";
		System.out.println("after : " + name);
	}
}

class Car3 {
	int number;
	// 권장사항 : 코드 상에서 default 생성자는 일반적으로 생략한다.
	Car3() {}
}

class Car4 {
	int door;
	int wheel;
	
	Car4() {
		// default
		System.out.println("default");
	}
	
	Car4(int num) { // overloading
		door = num;
		System.out.println("overloading door : " +door);
	}
	
	Car4(int num, int num2) {
		door = num;
		wheel = num2;
		System.out.println("overloading door : wheel" + door + "," + wheel);
	}
}

class Apt {
	String color;
	
	Apt(String color) {
		this.color = color;
	}
}

// 1. class 생성 시 overloading 생성자가 하나라도 존재한다면 default 생성자는
// 자동 생성되지 않는다 (컴파일러가 자동으로 만들지 않는다)

// 이유 : 강제성 (설계도)에 강제성 부여(나는 overloading을 강제 사용하게 하겠다)

class Apt2 {
	String color;
	// default 사용하고 싶다면 반드시 구현
	Apt2() { System.out.println("default"); }
	
	Apt2(String color) {
		this.color = color;
	}
}


public class Ex13_Constructor_Function {

	public static void main(String[] args) {
		// Car c = new Car();
		// Car2 c2 = new Car2();
		// Car3 c3 = new Car3();
		Car4 c4 = new Car4(); // default 호출해서 객체 생성
		System.out.println();
		Car4 c5 = new Car4(2); // param 1개 객체 생성
		System.out.println();
		Car4 c6 = new Car4(2, 4); // param 2개 객체 생성
		
		Apt2 apt2 = new Apt2();
		Apt2 apt3 = new Apt2("gold");
		
		Book book = new Book("홍길동전", 10000);
		book.printNamePrice();
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		
		Book book2 = new Book("마법천자문", 15000);
		book2.printNamePrice();
	}
}

// 1. class 생성 시 생성자 함수 구현하지 않으면 default 생성자 자동 생성
// ex) class Tv { String name; }

// 2. class 생성 시 overloading 생성자를 하나라도 구현하면
// default 생성자는 사용할 수 없다. 
// 강제적 구현이 목적인 클래스
// ex) class Tv { String name; Tv(String n) { name = n; } }

// 3. class 생성 시 default, overloading 생성자를 모두 구현
// 필요에 따라서 default나 overloading을 골라 쓸 수 있다.
// ex) class Tv { String name; Tv() {} Tv(String n) { name = n } }