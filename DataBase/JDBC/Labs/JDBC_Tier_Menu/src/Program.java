import java.util.List;
import java.util.Scanner;

import dao.DepartmentDao;
import dto.Department;

public class Program {
	private static Scanner sc = new Scanner(System.in);
	private static DepartmentDao dao = new DepartmentDao();
	
	// 1. 부서 전체 목록
	private static void selectAll() {
		List<Department> dList = dao.getDepartmentAllList();
		System.out.println("번호   부서명");
		for (Department d : dList) {
			System.out.println(d.getDeptno() + "  |  "  + d.getDname());
		}
	}
	
	// 2. 부서 신규 등록
	private static void insertDepartment() {
		int deptno = 0;
		while (true) {
			try {
		        System.out.print("부서 코드 입력 : ");
		        deptno = Integer.parseInt(sc.nextLine());
		        break;
			} catch (NumberFormatException e) {
				System.out.println("올바르게 입력해주세요.");
			}
		}

	    System.out.print("부서 이름 입력 : ");
	    String dname = sc.nextLine().toUpperCase();
	    Department d = new Department();
	    d.setDeptno(deptno);
	    d.setDname(dname);
	    
		int rows = dao.insertDepartment(d);
		if (rows > 0) {
			System.out.println("INSERT ROW : " + rows);
			System.out.println("INSERT DATA : " + deptno + " : " + dname);
		} else {
			System.out.println("INSERT FAILED");
		}
		
	}
	
	// 3. 부서 변경
	private static void updateDepartment() {
		System.out.print("부서 이름 입력 : ");
	    String dname = sc.nextLine().toUpperCase();
	    Department d = dao.getDepartmentListByDname(dname);
	    if (d != null) {
	    	System.out.println("번호   부서명");
	    	System.out.println(d.getDeptno() + "  |  "  + d.getDname());
	    } else {
	    	System.out.println("부서가 없습니다.");
	    	return;
	    }
	    System.out.println("[부서 변경 정보 입력]");
	    int deptno = 0;
		while (true) {
			try {
		        System.out.print("부서 코드 입력 : ");
		        deptno = Integer.parseInt(sc.nextLine());
		        break;
			} catch (NumberFormatException e) {
				System.out.println("올바르게 입력해주세요.");
			}
		}
	    System.out.print("부서 이름 : ");
	    String newName = sc.nextLine().toUpperCase();
	    d.setDeptno(deptno);
	    d.setDname(newName);
	    
		int rows = dao.updateDepartment(dname, d);
		
		if (rows > 0) {
			System.out.println("변경된 ROW : " + rows);
		} else {
			System.out.println("UPDATE FAILED");
		}
	}
	
	// 4. 부서 삭제
	private static void deleteDepartment() {	
		int deptno = 0;
		while (true) {
			try {
				System.out.print("삭제할 부서 번호 입력 : ");
		        deptno = Integer.parseInt(sc.nextLine());
		        break;
			} catch (NumberFormatException e) {
				System.out.println("올바르게 입력해주세요.");
			}
		}
		
		int rows = dao.deleteDepartment(deptno);
		
		if (rows > 0) {
			System.out.println("변경된 ROW : " + rows);
		} else {
			System.out.println("DELETE FAILED");
		}
	}
	
	// 5. 부서 검색
	private static void searchDepartment() {
		System.out.print("검색할 부서명 입력 : ");
		String dname = sc.nextLine().toUpperCase();
		
		List<Department> dList = dao.getDeptListByString(dname);
		System.out.println("번호   부서명");
		for (Department d : dList) {
			System.out.println(d.getDeptno() + "  |  "  + d.getDname());
		}
	}
	
	private static String menu() {
		return  "**********************\r\n" +
				"* 1. 부서목록조회\r\n" + 
				"* 2. 부서등록\r\n" + 
				"* 3. 부서변경\r\n" + 
				"* 4. 부서삭제\r\n" + 
				"* 5. 부서검색\r\n" + 
				"* 6. 종료\r\n" +
				"**********************";
	}
	
	public static void main(String[] args) {
		while (true) {
			System.out.println(menu());
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				selectAll();
				break;
			case "2":
				insertDepartment();
				break;
			case "3":
				updateDepartment();
				break;
			case "4":
				deleteDepartment();
				break;
			case "5":
				searchDepartment();
				break;
			case "6":
				return;
			default:
				System.out.println("올바른 메뉴 번호를 입력해주세요.");
			}
		}
	}
}
