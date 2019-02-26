import kr.or.bit.Person;
import kr.or.bit.Tv;

public class Ex01_Ref_Type {

	public static void main(String[] args) {
		Person person; // Stack 영역에 4바이트 빈 공간 (person) null
		person = new Person(); // Heap 메모리에 Person 객체 만들고 person 변수에 주소값 할당
		System.out.println("person : " + person); // kr.or.bit.Person@15db9742

		person.name = "홍길동";
		person.age = 100;
		person.print();
		
		Person person2 = new Person(); // 선언과 할당을 동시에
		person2.name = "김유신";
		person2.age = 120;
		person2.print();
		
		// person, person2 : 참조 타입(Ref Type)
		
		int num = 100; // main 함수 안에 있는 local variable (반드시 초기화)
		System.out.println("값 : " + num); // 값 타입 (value type)
		
		Person you; // The local variable you may not have been initialized
		            // 참조 타입의 초기화란 주소값을 가지는 것
		// 참조변수의 초기화
		// 1. new 연산자
		//    you = new Person();
		// 2. 다른 참조변수의 값을 할당
		you = person; // person과 you의 동거
		System.out.println("you : " + you);
		System.out.println("person : " + person);
		System.out.println(you == person); // == : 값 비교 (같은 주소 : true)
		
		Tv t = new Tv();
		t.brandName = "삼성";
		System.out.println("기본채널 : " + t.ch); // 0
		System.out.println("브랜드명 : " + t.brandName); // String의 기본값 null
		
		System.out.println("전원정보 : " + t.power);
		t.powerOn(); // 호출한다 (함수는 이름을 불러주었을 때 실행)
		System.out.println("전원정보 : " + t.power);

		t.chUp();
		t.chUp();
		t.chUp();
		System.out.println("변경된 채널 : " + t.ch); // 3
		t.chDown();
		System.out.println("변경된 채널 : " + t.ch); // 2
	}

}
