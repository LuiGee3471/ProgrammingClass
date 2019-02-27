import java.util.ArrayList;

/*
 * 1.Arraylist를 사용해 (generic사용 X)
   int값 string값을가진 객체를 2개씩 생성하여 개선된 for문으로 값을 출력하시오.

   2. 방금 만든 Arraylist의 1번째 2번째의 방의 값을 지우고 출력하시오.

   3. 값이 지워진 Arraylist의 값 중간에 hello, would를 넣어보세요.

   4. 새로운 class를 만들어 이름 학번 전공 변수를 넣고  
   Arraylist<generic>을 사용하여 출력하시오.

   5. 이름하고 전공만 출력하시오.
 */

class Student {
	private String name;
	private int no;
	private String major;
	
	public Student(String name, int no, String major) {
		this.name = name;
		this.no = no;
		this.major = major;
	}

	@Override
	public String toString() {
		return "이름 : " + name + ", 전공 : " + major;
	}
	
	
}

public class ArrayListExerCise {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add("가");
		list.add(2);
		list.add("나");
		
		for (Object obj : list) {
			System.out.println(obj);
		}
		
		list.remove(0);
		list.remove(1);
		
		System.out.println(list);
		
		list.add(1, "hello");
		list.add(2, "would");
		
		System.out.println(list);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("김동민", 2008, "컴공"));
		studentList.add(new Student("윤종석", 2011, "언론"));
		studentList.add(new Student("권태환", 2015, "디자인"));
		
		System.out.println(studentList);
	}

}
