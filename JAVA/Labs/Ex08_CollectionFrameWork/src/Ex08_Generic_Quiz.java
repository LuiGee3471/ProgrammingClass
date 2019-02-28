import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;

public class Ex08_Generic_Quiz {
	public static void main(String[] args) {
		// 1. Emp 클래스를 사용해서 사원 3명을 생성하세요
		// 단 ArrayList 제너릭을 사용하세요
		List<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(1, "윤", "경영"));
		emplist.add(new Emp(2, "장", "영업"));
		emplist.add(new Emp(3, "김", "인사"));
		
		// 2. 3명의 사원 정보(사번, 이름, 직종)를 개선된 for문을 사용해서 출력하세요
		// 단, toString()은 사용 금지
		
		for (Emp emp : emplist) {
			System.out.println("[" + emp.getEmpno() + ", " + emp.getEname() + ", " + emp.getJob() + "]");
		}
		
		// 3. 3명의 사원 정보를 일반 for문을 사용해서 출력하세요
		// 단, toString() 사용 금지
		
		for (int i = 0; i < emplist.size(); i++) {
			System.out.println("[" + emplist.get(i).getEmpno() + ", " + emplist.get(i).getEname() + ", " + emplist.get(i).getJob() + "]");
		}
		
		// 4. CopyEmp라는 클래스를 만드세요 (구조는 Emp와 같음)
		// job member field 대신에
		// private int sal 추가하고 getter, setter 구현
		// ArrayList 제너릭 사용해서 사원 3명
		// 아래 데이터
		// 100, "김", 1000
        // 200, "이", 2000
	    // 300, "박", 3000
		
		List<CopyEmp> copyemplist = new ArrayList<CopyEmp>();
		copyemplist.add(new CopyEmp(100, "김", 1000));
		copyemplist.add(new CopyEmp(200, "이", 2000));
		copyemplist.add(new CopyEmp(300, "박", 3000));
		
		// 5. 200번 사원의 급여를 5000으로 수정해서 출력하세요 (일반 for문 사용)
		for (int i = 0; i < copyemplist.size(); i++) {
			if (copyemplist.get(i).getEmpno() == 200) {
				copyemplist.get(i).setSal(5000);
				System.out.println("[" + copyemplist.get(i).getEmpno() + ", " + copyemplist.get(i).getEname() + ", " + copyemplist.get(i).getSal() + "]");
			}
		}
		
		// 6. 300번 사원의 이름을 "궁금해"로 수정해서 출력하세요 (개선된 for문)
		for (CopyEmp cemp : copyemplist) {
			if (cemp.getEmpno() == 300) {
				cemp.setEname("궁금해");
				System.out.println("[" + cemp.getEmpno() + ", " + cemp.getEname() + ", " + cemp.getSal() + "]");
			}
		}
		
		// 7. 사원 정보를 Iterator 인터페이스를 사용해서 출력하세요.
		
		Iterator<CopyEmp> i = copyemplist.iterator();
		while (i.hasNext()) {
			CopyEmp ce = i.next();
			System.out.println("[" + ce.getEmpno() + ", " + ce.getEname() + ", " + ce.getSal() + "]");
		}
	}
}
