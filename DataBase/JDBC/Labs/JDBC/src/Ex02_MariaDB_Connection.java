import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 1. 드라이버 참조 (jar 추가)
 * 2. 드라이버 로딩 (JVM : Class.forName() 생략 가능)
 * 3. 연결 객체 생성 -> DriverManager 클래스
 * 4. 명령 객체 생성 -> CRUD 작업 준비(Statement)
 * 5. 명령 실행 -> DQL(select 1건, select multi-row) -> ResultSet 객체
 *              -> DML(insert into, update, delete) -> ResultSet 없음 => 성공 여부만 판단
 * 6. 명령 처리 (2가지) : DQL(출력), DML(결과에 따른 처리, 성공,실패)
 * 7. 자원 해제
 * 
 * JDBC API : 표준화된 코드 사용(다형성 기반)
 * Connection
 * Statement
 * PreparedStatement
 * ResultSet
 */
public class Ex02_MariaDB_Connection {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MariaDB");
			
			// 3. 연결 객체 생성
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.23:3306/kostadb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true", "kosta", "1004");
			System.out.println(conn.isClosed());
			
			// 4. 명령 객체 생성
			stmt = conn.createStatement();
			// 4.1 실행문장
			String job = "";
			Scanner sc = new Scanner(System.in);
			System.out.println("직종 입력");
			job = sc.nextLine();
			// where job = 'CLERK'
			String sql = "select empno, ename, job from emp where job = '" + job + "'";
			// 5. 명령 실행
			// DQL(select) : stmt.executeQuery(sql) >> return ResultSet 객체 주소
			// DML(insert into, delete, update) >> 결과 집합 X > 반영 결과(반영된 행의 수) : stmt.executeUpdate(sql) : return 반영된 행의 수
			// delete from emp >> return 14
			rs = stmt.executeQuery(sql);
			
			// 6. 명령 처리
			// DQL : 1. 결과가 없는 경우 (where empno = 9999)
			//       2. 결과가 한 건인 경우 (PK, UNIQUE : where empno = 7788)
			//       3. 결과가 여러 개인 경우 (where deptno = 20)
			
			// 1. 간단하다 (단순)
			// 2. 결과 집합이 없는 경우 처리 불가
			/*
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + ", "
						         + rs.getString("ename") + ", "
						         + rs.getString("job"));
			}
			*/
			
			// 1. 결과가 있는 경우와 없는 경우가 다 처리 가능하다
			// 2. multi-row 출력 불가능
			/*
			if (rs.next()) {
				System.out.println(rs.getInt("empno") + ", "
				         + rs.getString("ename") + ", "
				         + rs.getString("job"));
			} else {
				System.out.println("조회된 데이터가 없습니다.");
			}
			*/
			/*
			while (true) {
				if (rs.next()) {
					System.out.println(rs.getInt("empno") + ", "
					         + rs.getString("ename") + ", "
					         + rs.getString("job"));
				} else {
					System.out.println("데이터 조회 종료");
					break;
				}
			}
			*/
			
			if (rs.next()) {
				do { 
					System.out.println(rs.getInt("empno") + ", "
							         + rs.getString("ename") + ", "
					                 + rs.getString("job"));
				} while (rs.next());         
			} else {
				System.out.println("데이터 조회 종료");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 자원 해제
			/*
			rs.close();
			stmt.close();
			conn.close();
			*/
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					
				}
			}
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
