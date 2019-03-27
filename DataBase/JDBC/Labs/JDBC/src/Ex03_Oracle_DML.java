import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
 * DML (insert into, update, delete)
 * JDBC API 통해서 작업
 * 1. 결과 집합이 없다
 * 2. 반영 결과(return 행의 수)
 * 
 * Java 구현되는 코드
 * update emp set sal = 0 >> 14건 update >> return 14
 * update emp set sal = 100 where empno = 4444 >> return 0
 * 
 * Java 코드 로직 : 성공과 실패
 * 
 * Key Point
 * 1. Oracle DML 작업(developer, CMD, Tool) commit or rollback 강제
 * 2. JDBC API 사용하는 Java 코드는 >> DML >> default : autocommit
 * 3. Java Code : delete from emp >> 실행 >> 자동 commit >> 실반영
 * 4. 필요에 ㄸ라서는 commit(), rollback() Java 코드에서 제어 가능
 * 
 * 시작 
 *   A 계좌 인출(update...)
 *   ....
 *   B 계좌 입금(update...)
 * 끝
 * >> 하나의 논리적 단위 (transaction)
 * >> autocommit 옵션 >> false 전환
 * >> Java Code DML 작업시 반드시 >> commit(), rollback() 강제 호출
 */
public class Ex03_Oracle_DML {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bituser", "1004");
			stmt = conn.createStatement();
			
			//INSERT
			int empno = 0;
			String ename = "";
			int deptno = 0;
			
			Scanner sc = new Scanner(System.in);
			/*
			System.out.println("사번 입력 :");
			empno = sc.nextInt();
			sc.nextLine();
			
			System.out.println("이름 입력 :");
			ename = sc.nextLine();
			
			System.out.println("부서번호 입력 :");
			deptno = sc.nextInt();
			sc.nextLine();
			
			// insert into dmlemp(empno, ename, deptno)
			// values (100, '홍길동', 10);
			
			// 이런 코드는 쓰지 않는다
			String sql = "insert into dmlemp(empno, ename, deptno)";
			sql += "values(" + empno + ", '" + ename + "', " + deptno + ")";
			
			// executeUpdate() > insert, update, delete 전부
			int resultRowCount = stmt.executeUpdate(sql);
			if (resultRowCount > 0) {
				System.out.println("반영된 행의 수 : " + resultRowCount);
			} else {
				System.out.println("INSERT Failed : " + resultRowCount);
			}
			*/
			
			// UPDATE
			// update dmlemp set sal = 0 where deptno = 값
			String sql2 = "update dmlemp set sal = 0 where deptno =";
			System.out.println("부서번호 입력");
			sql2 += sc.nextInt();
			sc.nextLine();
			
			if (resultRowCount > 0) {
				System.out.println("반영된 행의 수 : " + resultRowCount);
			} else {
				System.out.println("INSERT Failed : " + resultRowCount);
			}
			
			// DELETE
			// delete from dmlemp where deptno = 부서번호
			String sql3 = "delete from dmlemp where deptno = ";
			System.out.println("부서번호 입력");
			sql3 += sc.nextInt();
			sc.nextLine();
			
			resultRowCount = stmt.executeUpdate(sql3);
			if (resultRowCount > 0) {
				System.out.println("반영된 행의 수 : " + resultRowCount);
			} else {
				System.out.println("INSERT Failed : " + resultRowCount);
			}
		} catch (Exception e) {
			System.out.println("SQL 예외 발생 : " + e.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
		}
	}
}
