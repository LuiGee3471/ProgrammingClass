import kr.or.bit.Employee;

public class Ex14_Constructor {
	public static void main(String[] args) {
		Employee emp = new Employee(); // default 생성자
		emp.employeeInfoPrint();
		System.out.println(emp.getEname());

		Employee emp2 = new Employee(201901, "홍길동", "영업팀");
		emp2.employeeInfoPrint();
		System.out.println(emp2.getEname());
		emp2.setJob("IT개발팀");
		emp2.employeeInfoPrint();
		
		// Array를 사용해서 사원 3명을 만들어보세요.
		// 객체 배열
		Employee[] emparr = { 
				new Employee(201902, "김김김", "기획팀"), 
				new Employee(201903, "이이이", "총무팀"), 
				new Employee(201904, "박박박", "인사팀") 
				};
		
		for (Employee e : emparr) {
			e.employeeInfoPrint();
		}
	}
}
