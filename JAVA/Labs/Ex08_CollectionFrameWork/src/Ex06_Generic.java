import java.util.ArrayList;

// Today's Point
// Generic
// JDK 1.5 버전부터 지원
// C#, Java 모두 필수 기능

// 1. Object 타입에 저항 -> Object 타입 탈피
// 2. 타입을 강제하는 방법 (타입의 안정성 추구)
// 3. 형변환 (casting) 문제 해결 : ex) (Car) obj 등 

class Person {
	int age = 100;
}

class MyGen<T> { // Type parameter MyGen<E>
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return obj;
	}
}

/*
 * MyGen<String> mygen = new MyGen<>();
 * 
 * heap 메모리에 로드될 때
 * class MyGen<String> { // Type parameter MyGen<E>
	    String obj;
	
	    void add(T obj) {
		    this.obj = obj;
	    }
	
	    String get() {
		    return obj;
	    }
    }  
 */

public class Ex06_Generic {
	public static void main(String[] args) {
		MyGen<String> mygen = new MyGen<>();
		mygen.add("String");
		System.out.println(mygen.get());
		
		MyGen<Person> mygen2 = new MyGen<>();
		mygen2.add(new Person());
		Person p = mygen2.get();
		System.out.println(p.age);
		
		ArrayList<String> li = new ArrayList<>();
		li.add("A");
		li.add("B");
		for (String str : li) {
			System.out.println(str);
		}
		//////////////////////////////////////
		ArrayList list = new ArrayList();
		list.add(500);
		list.add(new Person());
		list.add("홍길동");
		
		// 개선된 for 문을 사용해서 >> 500, 100, 홍길동
		String str = "";
		for (Object obj : list) {
			if (obj instanceof Person) {
				str += ((Person) obj).age;
			} else {
				str += obj.toString();
			}
			str += ", ";
		}
		System.out.println(str);
		
		ArrayList<Person> alist = new ArrayList<Person>();
		alist.add(new Person());
		System.out.println(alist.get(0).age);
	}
}
