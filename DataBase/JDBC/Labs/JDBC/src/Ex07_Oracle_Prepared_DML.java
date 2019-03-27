import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.SingletonHelper;

public class Ex07_Oracle_Prepared_DML {
	public static void main(String[] args) {
		// INSERT INTO
		// insert into dmlemp(empno, ename, deptno) values (?, ?, ?)
		// UPDATE
		// update dmlemp set ename = ?, sal = ?, job = ?, deptno = ? where empno = ?
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			/*
			String sql = "insert into dmlemp(empno, ename, deptno) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // 쿼리문 전송
			
			// parameter만 준비
			pstmt.setInt(1, 5555);
			pstmt.setString(2, "김유신");
			pstmt.setInt(3, 10);
			
			int row = pstmt.executeUpdate();
			
			if (row > 0) {
				System.out.println("insert into row count : " + row);
			} else {
				System.out.println("row count : " + row);
			}
			*/
			
			String sql = "update dmlemp set ename = ?, sal = ?, job = ?, deptno = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "홍길동");
			pstmt.setInt(2, 6000);
			pstmt.setString(3, "CEO");
			pstmt.setInt(4, 10);
			pstmt.setInt(5, 5555);
			
			int row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("Update row count : " + row);
			} else {
				System.out.println("row count : " + row);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
	}
}
