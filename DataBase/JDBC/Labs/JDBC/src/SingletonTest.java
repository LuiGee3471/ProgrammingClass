import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bit.utils.SingletonHelper;

public class SingletonTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.isClosed());
		SingletonHelper.close(conn);
		System.out.println("연결 여부 : " + conn.isClosed());
		
		// 연결 객체가 재활용 가능한 객체일까
		// 연결할 때마다 객체를 새로 생성
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.isClosed());
		SingletonHelper.close(conn);
		System.out.println("연결 여부 : " + conn.isClosed());
		
		// 1 return : oracle.jdbc.driver.T4CConnection@4aa8f0b4
		// 2 return : oracle.jdbc.driver.T4CConnection@1c3a4799
		// result : getConnection() 함수 호출 시마다 새로운 객체 생성
		// 하나의 APP 연결 객체 하나만 사용해도 되지 않을까
		// 한 번 만들어서 재사용하면 어떨까
		
		Connection myconn = null;
		myconn = SingletonHelper.getConnection("mysql", "bituser", "1004");
		System.out.println(myconn.toString());
		System.out.println(myconn.getMetaData().getDatabaseProductName());
		System.out.println(myconn.getMetaData().getDatabaseProductVersion());
		System.out.println(myconn.isClosed());
		SingletonHelper.close(myconn);
		System.out.println("연결 여부 : " + myconn.isClosed());
	}
}
