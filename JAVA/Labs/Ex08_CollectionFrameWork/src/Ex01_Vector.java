import java.util.Vector;

/*
 * Collection Framework
 * [다수의 데이터를 다루는 [표준화]된 [인터페이스]를 [구현]하고 있는 클래스 집합]
 * 
 *          Collection
 *              |(상속)
 *    List     ---        Set            Map
 *     |                   |              |
 *   Vector             HashSet       [HashMap]
 * [ArrayList]          TreeSet
 * 
 * List interface [줄을 서시오]
 * : 순서(O), 중복(O) -> 내부적으로 데이터 관리는 배열로 -> Array [0][1][2]....
 * 
 * 1. Vector(구버전) -> 동기화(멀티 쓰레드) -> Lock 보장 (default) -> 데이터 보호
 * 2. ArrayList(신버전) -> 동기화(멀티 쓰레드) -> Lock 보장(X) -> 필요하면 Lock -> 성능
 * ex) 동기화
 * 한강 고수부지 화장실 1개 (100명이 이용) >> Lock을 통해서 안전하게
 * 한강 고수부지 비빔밥 축제 (100인분)(100명이 동시에) >> Lock (X) >> 성능 확보
 * 
 * Array (배열) : 정적 배열 (크기가 고정되어있다)
 * 방을 10개 생성하면 고정, 변경 불가
 * int[] arr = new int[10];
 * int[] arr = { 10, 20, 30 };
 * 
 * Array (고정, 정적)
 * 1. 배열의 크기가 고정 : Car[] cars = { new Car(), new Car() }; // 방 2개
 * 2. 배열의 접근 : index(첨자) : cars[0], cars[0].color
 * 3. 초기 설정한 크기는 변경이 불가
 * 
 * List 인터페이스를 구현한 클래스(Vector, ArrayList 등) : 동적 배열
 * 1. 배열의 크기를 동적으로 확장 가능 => 사실은 배열의 재할당 => 내가 직접 코딩하지 않아
 * 2. 순서를 유지한다(Array), 순서(index), 중복값 허용
 * 3. 데이터의 저장 공간으로는 Array 사용
 * 4. List 인터페이스를 구현한 클래스 : new를 통해 객체 생성 후 사용
 * 5. 구현 클래스(ArrayList)가 가지는 데이터 타입 : 방의 타입은 Object
 *    Object[] arr = new Object[10];
 *    장점 : 모든 타입의 부모 타입 (int, Car, String....) >> 모든 자료 삽입 가능
 *    단점 : 값을 사용할 때 Object를 downcasting해서 사용해야 함
 *    
 * 5의 단점을 극복하기 위한 방법 : 제너릭(타입 강제)을 통해 문제 해결 
 */

public class Ex01_Vector {
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("초기 default 용량 : " + v.capacity()); // 10
		v.add("AA"); // [0] >> AA
		v.add("BB"); // [1]
		v.add("AA"); // [2]
		v.add(100);  // [3]
		System.out.println(v.toString()); // [AA, BB, AA, 100] : toString()의 재정의 결과
		System.out.println(v); // toString()은 생략되어있다
		
		// Array >> length() >> Car[index]
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i)); // get 함수의 return 타입 : Object
		}
		
		for (Object obj : v) {
			System.out.println(obj);
		}
		
		// 문제 : Object라는 가장 큰 타입을 사용해서 add(), get() 등등
		
		Vector<String> v2 = new Vector<String>(); // String 타입의 방
		v2.add("Hello");
		v2.add("World");
		
		for (String str : v2) {
			System.out.println(str);
		}
		
		System.out.println(v2.toString());
		System.out.println(v2.get(1));
		System.out.println("size : " + v2.size());
		System.out.println("Capacity : " + v2.capacity());
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity()); // 10
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		System.out.println(v3.capacity()); // 20
		v3.add("A");
		
		System.out.println("size : " + v3.size());
		System.out.println("Capacity : " + v3.capacity());
	}
}
