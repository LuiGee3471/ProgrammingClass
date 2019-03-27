import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex05_SingletonHelper {

	public static void main(String[] args) throws SQLException {
		// Singleton 사용
		// 객체 간 공유 자원 (conn 객체)
		// 공유 자원 값의 변화에 다른 모든 것도 변화
		
		// conn.close(); 연결 해제
		// conn 객체의 주소값을 null값으로 만든 것은 아니다
		// APP 종료될 때까지 singleton >> conn은 연결 해제 하지 않는다
		
		
		Connection conn = null;
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.isClosed());
		SingletonHelper.close();
		System.out.println("연결 여부 : " + conn.isClosed());
		
		Connection conn2 = null;
		conn2 = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.isClosed());
		SingletonHelper.close();
		System.out.println("연결 여부 : " + conn.isClosed());
		
		Connection myconn = null;
		myconn = SingletonHelper.getConnection("mysql", "bituser", "1004");
		System.out.println(myconn.toString());
		System.out.println(myconn.getMetaData().getDatabaseProductName());
		System.out.println(myconn.getMetaData().getDatabaseProductVersion());
		System.out.println(myconn.isClosed());
		 SingletonHelper.close();
		System.out.println("연결 여부 : " + myconn.isClosed());
		
		myconn = SingletonHelper.getConnection("mysql", "bituser", "1004");
		System.out.println(myconn.toString());
		System.out.println(myconn.getMetaData().getDatabaseProductName());
		System.out.println(myconn.getMetaData().getDatabaseProductVersion());
		System.out.println(myconn.isClosed());
		 SingletonHelper.close();
		System.out.println("연결 여부 : " + myconn.isClosed());

	}

}
