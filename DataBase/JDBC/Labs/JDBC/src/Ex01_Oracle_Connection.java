import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * JDBC
 * 1. Java 언어를 통해서 Oracle(소프트웨어)에 연결하고 CRUD 작업
 * 2. Java APP 의사결정 (어떤 RDBMS를 사용할지) : Oracle, MySQL, MS-SQL, ...
 * 2.1 프린터 구매 : 컴퓨터 - 프린터 연결
 * CASE 1 : 정상 동작 (컴퓨터에 프린터 드라이버가 내장)
 * CASE 2 : 프린터 회사 사이트에서 드라이버 다운로드 >> 통합 / 제품 드라이버 >> 설치
 * 2.2 MySQL (https://dev.mysql.com/downloads/connector/j/)
 * 2.3 Oracle (C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar)
 * 
 * 3. 드라이버 참조 방법 (작업하는 프로젝트에서) (Java Project -> 드라이버 참조)
 * 3.1 Java >> 속성 >> Build Path >> jar (추가)
 * 3.2 드라이버 사용 준비 완료 >> 메모리에 Load해서 사용할 수 있도록 (new)
 * 3.3 class.forName("클래스 이름") >> new 동일한 효과
 * 
 * 4. Java Code (JDBC API)
 * 4.1 import java.sql.* >> 아래에 interface, class 제공
 * 4.2 개발자는 interface 해석을 통해서 작업
 * POINT (Why : interface 형태로 제공? >> JDBC API : oracle, mysql... >> )
 * Oracle사도 JDBC API를 구현... (드라이버 안에서)
 * MySQL도 JDBC API를 구현... (드라이버 안에서)
 * >> 다형성 사용 .... 
 * 
 * import java.sql.Connection;
 * import java.sql.ResultSet;
 * import java.sql.Statement;
 * 
 * 5. 작업순서
 * 5.1 DB 연결 -> 명령(CRUD) -> 실행 -> 처리 -> 자원 해제
 * 5.1 명령 : DDL(create, alter, drop)
 *            CRUD(insert into, select(60%), update, delete)
 * 5.2 실행 : DB 서버에게 구문 전달             
 * 5.3 처리 : 화면 출력, 다른 곳에 전달
 * 5.4 자원 해제(성능)
 * 
 * TIP)
 * 연결 문자열 (connectionString) 설정
 * 네트워크 통해서 DB에 접근
 * (DB 서버 IP, PORT(Oracle : 1521, MySQL : 3306), SID(Oracle : XE, orcl, MySQL : DB이름), 접속 계정, 비밀번호)
 */

public class Ex01_Oracle_Connection {
	public static void main(String[] args) throws Exception {	
		// DB 연결
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("오라클 드라이버 로딩");
		
		// getConnection Connection 인터페이스를 구현한 객체의 주소값을 리턴 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.23:1521:XE", "Team3", "1004");
		System.out.println(conn.isClosed() + "정상 (False)");
		System.out.println(conn.toString());
		
		// 명령 생성
		Statement stmt = conn.createStatement(); // 명령 객체 얻어오기
		
		// CRUD
		String sql = "select * from emp";
		
		// 명령 실행
		ResultSet rs = stmt.executeQuery(sql);
		// 처리 (화면 조회)
		while (rs.next()) {
			System.out.println(rs.getInt("empno") + "/"
					         + rs.getString("ename") + "/"
					         + rs.getInt("sal"));
		}
		
		// 자원 해제
		rs.close();
		stmt.close();
		conn.close();
		System.out.println("DB연결 : " + conn.isClosed());
	}
}
