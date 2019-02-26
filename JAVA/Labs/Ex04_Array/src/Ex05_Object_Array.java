import kr.or.bit.Emp;

// 배열에서 가장 중요한 부분은 객체 배열
// 실무에서 가장 많이 쓰이니까
public class Ex05_Object_Array {

	public static void main(String[] args) {
		// 신입 사원 3명
		// Array를 배우지 않았을 때
		// Emp e = new Emp();
		// Emp e2 = new Emp();
		// Emp e3 = new Emp();
		
		Emp[] emplist = new Emp[3]; // 방 만들고 방에 값을 넣어준다
		emplist[0] = new Emp(); // 0번째가 주소값
		emplist[0].setEmpno(1000);
		emplist[0].setEname("김유신");
		
		emplist[1] = new Emp(2000, "아무개"); // 1번째 주소값
		emplist[2] = new Emp(3000, "유관순");
		
		for (int i = 0; i < emplist.length; i++) {
			emplist[i].empInfo();
		}
		
		// 3개 Emp 타입의 배열을 만들고 각각의 방에 주소값을 할당
		// int[] arr = new int[] { 10, 20, 30 }
		Emp[] emplist2 = new Emp[] { new Emp(1, "이씨"), new Emp(2, "박씨"), new Emp(3, "김씨") };
		for (int i = 0; i < emplist2.length; i++) {
			emplist2[i].empInfo();
		}
		
		// int[] arr = { 10, 20, 30 }
		Emp[] emplist3 = { new Emp(111, "A"), new Emp(222, "B") };
	}
}
