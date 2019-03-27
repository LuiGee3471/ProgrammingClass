import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.bit.utils.SingletonHelper;

/*
CREATE TABLE trans_A (
num NUMBER,
name varchar2(20));

CREATE TABLE trans_B (
num NUMBER CONSTRAINT pk_trans_B_num PRIMARY KEY,
name varchar2(20));


JDBC >> default(dml) >> autocommit

trans_A, trans_B 하나의 논리적 단위(transaction 처리)

JDBC >> autocommit >> false >> 개발자는 반드시 commit, rollback을 강제
*/

public class Ex08_Oracle_Transaction {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		conn = SingletonHelper.getConnection("oracle");
		String sql = "insert into trans_A(num, name) values (100, 'A')";
		String sql2 = "insert into trans_B(num, name) values (100, 'B')";
		
		try {
			conn.setAutoCommit(false);
			// begin transaction
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeUpdate();
			// end transaction
			conn.commit(); // 둘다 정상적으로 실행되고 예외가 발생하지 않으면
		} catch (Exception e) {
			System.out.println("문제 발생 : " + e.getMessage());
			conn.rollback();
		} finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(pstmt2);
		}
	}
}
