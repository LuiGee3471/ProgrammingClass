import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Today's Point
// HashMap<k, v>
// HashMap<String, String>
// HashMap<Integer, String>
// HashMap<String, Emp> POINT >> value 값으로 객체가 올 수 있다

// IO, Network, Thread >> ArrayList<Emp>, HashMap<String, Emp> 코드 활용

class Student {
	int kor = 100;
	int math = 80;
	int eng = 20;
	String name;
	
	Student(String name) {
		this.name = name;
	}
}

public class Ex14_HashMap_Generic {
	public static void main(String[] args) {
		HashMap<String, Student> students = new HashMap<String, Student>();
		students.put("hong", new Student("홍길동"));
		students.put("kim", new Student("김유신"));
		
		Student hongstd = students.get("hong");
		System.out.println(hongstd.name);
		System.out.println(hongstd.kor);
		System.out.println(hongstd.eng);
		System.out.println(hongstd.math);
		
		// Map은 기본적으로 key를 가지고 value값을 얻어내는 구조
		// 예외적으로 key와 value를 모두 출력하고 싶을 때
		
		// entrySet() >> key + "=" + value
		// hong=Student@15db9742
		Set set = students.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		// 예외적인 CASE : value가 객체일 때
		// Map.Entry 타입을 통해서 
		// getKey(), getValue()를 통해 각각의 정보를 출력 가능
		for (Map.Entry m : students.entrySet()) {
			System.out.println(m.getKey() + "/" + ((Student) m.getValue()).name + "/" + ((Student)m.getValue()).kor);
		}
		
	}
}
