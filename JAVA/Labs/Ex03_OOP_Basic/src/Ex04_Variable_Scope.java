// 연습용 클래스 (Ex04_Variable_Scope.java 파일 안에)

class Variable {
	int iv;
	/*
	 * 1. member field, instance variable
	 * 2. 목적 : 정보를 담는다. (상태 데이터, 고유 데이터, 참조, 부품 데이터)
	 * 3. 특징 : 초기값을 가지고 있다. (정수 > 0, 실수 > 0.0, boolean > false)
	 *          ㄴ 초기화를 하지 않는다.(생성되는 객체마다 다른 값을 가진다)
	 * 4. 생성 시점(메모리에 올라가는 시점) : new 연산자를 통해 heap에 객체가 만들어지고 나서         
	 */
	static int cv;
	/*
	 * 1. class variable, static variable (공유 자원)
	 * 2. 목적 : 정보를 담는다. >> 생성되는 모든 객체가 공유하는 자원을 담는다. >> 객체 간 공유 자원
	 * 3. 특징 : 접근 방법 >> 클래스이름.static자원 (Variable.cv) >> 객체가 만들어지지 않아도 접근 가능 (Math.random())
	 * 4. 생성 시점 : 프로그램이 실행될 때(java Hello) class loader system이 클래스 정보를 읽고 class area(method area)에 정보를 올리고
	 *             올려진 클래스 안에 static 자원을 가지고 있다면 static 자원도 memory에 올린다.
	 *             >> static은 객체 생성 이전에 memory에 올라간다.
	 */
	
	void method() {
		int lv = 0;
		// 1. local variable (지역 변수)
		// 2. 지역 변수는 사용하기 전 반드시 초기화
		// 3. 생성 시점 : 함수가 호출되었을 때 함수가 끝나면 소멸(stack)
	}
}

public class Ex04_Variable_Scope {

	public static void main(String[] azrgs) {
		/*
		Variable.cv = 100; // static 변수(공유)
		System.out.println(Variable.cv);
		
		Variable v = new Variable();
		v.iv = 200;
		v.cv = 500;
		System.out.println(Variable.cv);
		*/
		System.out.println("Variable.cv : " + Variable.cv);
		// 객체 간 공유 자원
		Variable v = new Variable();
		System.out.println(v.cv);
		
		Variable v2 = new Variable();
		System.out.println(v2.cv);
	}
}
