package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Dept;
import utils.SingletonHelper;

// DAO
// 1. DB 연결
// 2. CRUD (함수)
// 3. 5가지 method(selectALL, select where, insert, update, delete)

public class DeptDao {
	/*
	Connection conn = null;
	public DeptDao() {
		conn = SingletonHelper.getConnection(dsn)
	}
	*/
	
	// 1. 전체 조회 >> select 결과 >> return multi-row
	public List<Dept> getDeptAllList() {
		// 여러 건의 데이터를 담는 클래스
		List<Dept> deptList = new ArrayList<Dept>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select * from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptList.add(dept); // 배열에 객체 담는 것
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return deptList;
	}

	// 2. 조건 조회 >> select 결과 >> return single row
	public Dept getDeptByDeptno(int deptno) {
		Dept dept = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select * from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			
			dept = new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setLoc(rs.getString("loc"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return dept;
	}

	// 3. 데이터 삽입
	// public int insertDept(int deptno, String dname, String loc) ... (X)
	public int insertDept(Dept dept) {
		// insert into dept(deptno, dname, loc) values (?, ?, ?)
		int rows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into dept(deptno, dname, loc) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return rows;
	}

	// 4. 데이터 수정
	public int updateDept(Dept dept) {
		// update dept set dname = ?, loc = ? where deptno = ? 
		int rows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update dept set dname = ?, loc = ? where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return rows;
	}

	// 5. 데이터 삭제
	public int deleteDept(int deptno) { // primary key
		// delete from dept where deptno = ?
		int rows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "delete from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return rows;
	}
}
