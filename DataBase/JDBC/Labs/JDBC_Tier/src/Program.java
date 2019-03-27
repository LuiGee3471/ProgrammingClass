import java.util.List;

import dao.DeptDao;
import dto.Dept;

/*
 * 3-Tier 기반의 환경
 * 
 * APP 서버 구성 (MVC 패턴)
 * Model > DTO, DAO
 * 
 * view
 * controller
 * >> Program.java (화면, 요청) main에서
 * 
 * Model >> [Service] >> DAO, DTO
 */
public class Program {
	public static void main(String[] args) {
		// UI & 요청
		DeptDao dao = new DeptDao();
		System.out.println("[전체 조회]");
		List<Dept> deptList = dao.getDeptAllList();
		if (deptList != null) {
			for (Dept d : deptList) {
				System.out.println(d.toString());
			}
		}
		
		System.out.println("[조건 조회]");
		Dept dept = dao.getDeptByDeptno(10);
		if (dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("SELECT FAIL");
		}
		
		Dept deptInsert = new Dept(50, "IT", "LA");
		Dept deptInsert2 = new Dept(60, "HR", "WASHINGTON");
		
		int rows = dao.insertDept(deptInsert);
		if (rows > 0) {
			System.out.println(rows + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 불가능합니다.");
		}
		rows = dao.insertDept(deptInsert2);
		if (rows > 0) {
			System.out.println(rows + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 불가능합니다.");
		}
		
		deptList = dao.getDeptAllList();
		if (deptList != null) {
			for (Dept d : deptList) {
				System.out.println(d.toString());
			}
		}
		
		Dept deptUpdate = new Dept(50, "PR", "LA");
		
		rows = dao.updateDept(deptUpdate);
		if (rows > 0) {
			System.out.println(rows + "행이 수정되었습니다.");
		} else {
			System.out.println("조건에 맞는 데이터가 없습니다.");
		}
		
		deptList = dao.getDeptAllList();
		if (deptList != null) {
			for (Dept d : deptList) {
				System.out.println(d.toString());
			}
		}
		
		rows = dao.deleteDept(50);
		if (rows > 0) {
			System.out.println(rows + "행이 삭제되었습니다.");
		} else {
			System.out.println("조건에 맞는 데이터가 없습니다.");
		}
		rows = dao.deleteDept(60);
		if (rows > 0) {
			System.out.println(rows + "행이 삭제되었습니다.");
		} else {
			System.out.println("조건에 맞는 데이터가 없습니다.");
		}
		
		deptList = dao.getDeptAllList();
		if (deptList != null) {
			for (Dept d : deptList) {
				System.out.println(d.toString());
			}
		}
	}
}
