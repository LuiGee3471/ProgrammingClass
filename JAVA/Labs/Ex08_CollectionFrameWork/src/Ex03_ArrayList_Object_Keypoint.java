import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_Keypoint {

	public static void main(String[] args) {
		// 1. 사원 한 명의 정보를 담으세요
		Emp e = new Emp(100, "김유신", "군인");
		
		// 2. 사원 2명을 만드세요
		Emp[] emplist = { new Emp(10, "김씨", "IT"), new Emp(20, "박씨", "SALES") };
		for (Emp emp : emplist) {
		    System.out.println(emp.toString());
		
		}
		
		// 실수했어요, 한 명이 입사를 더 했어요
		// 위 정적 배열에 추가 불가(X) -> 새로 new (x)
		
		// 동적 (ArrayList)
		ArrayList alist = new ArrayList();
		alist.add(new Emp(1, "김", "IT"));
		alist.add(new Emp(2, "이", "IT"));
		alist.add(new Emp(3, "박", "영업"));

        System.out.println(alist.toString());
        
        // 일반 for문을 사용해서 사원 정보 출력 (downcasting)
        for (int i = 0; i < alist.size(); i++) {
            // System.out.println(alist.get(i).toString());
            Emp emp = (Emp) alist.get(i); // return Object >> 자식타입 = (자식타입) 부모타입
            System.out.println(emp.getEmpno() + " / " + emp.getEname()+ " / " + emp.getJob());
        }
        
        // 개선된 for 문 
        for (Object obj : alist) {
        	Emp emp = (Emp) obj;
        	System.out.println(emp.getEmpno() + " | " + emp.getEname() + " | " + emp.getJob());
        }
        
        // 사실은... 위의 코드가 불편
        // Generic (현대적인 프로그래밍의 99%는 사용)
        
        ArrayList<Emp> alist2 = new ArrayList<>();
        alist2.add(new Emp(1, "A", "IT"));
        alist2.add(new Emp(2, "B", "IT"));
        for (Emp emp : alist2) {
        	System.out.println(emp.getEmpno() + " | " + emp.getEname() + " | " + emp.getJob());
        }
	}
}