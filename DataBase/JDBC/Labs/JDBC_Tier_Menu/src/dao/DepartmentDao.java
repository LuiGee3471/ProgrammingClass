package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Department;
import utils.SingletonHelper;

public class DepartmentDao {
	// 1. 전체조회
	public List<Department> getDepartmentAllList() {
		List<Department> Departmentlist = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname from Department order by deptno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Department department = new Department();
				department.setDeptno(rs.getInt("deptno"));
				department.setDname(rs.getString("dname"));
				Departmentlist.add(department);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return Departmentlist;
	}

	// 2. 조건조회
	public Department getDepartmentListByDname(String dname) {
		// select deptno , dname , loc from dept where deptno=?
		Department department = null; //

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname from Department where dname=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				department = new Department();
				department.setDeptno(rs.getInt("deptno"));
				department.setDname(rs.getString("dname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return department;
	}

	// 3. 데이터 삽입
	public int insertDepartment(Department department) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into department(deptno,dname) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, department.getDeptno());
			pstmt.setString(2, department.getDname());
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

		return rowcount;
	}

	// 4. 데이터 수정
	public int updateDepartment(String dname, Department department) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update department set deptno = ?, dname = ? where dname = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, department.getDeptno());
			pstmt.setString(2, department.getDname());
			pstmt.setString(3, dname);
			

			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

		return rowcount;
	}

	// 5. 데이터 삭제
	public int deleteDepartment(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "delete from department where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

		return rowcount;
	}
	
	// 이름으로 부서 검색 (dname like)
	public List<Department> getDeptListByString(String s) {
		// select deptno , dname , loc from dept where deptno=?
		List<Department> deptlist = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname from department where dname like ?";
			pstmt = conn.prepareStatement(sql);
			String str = "%%" + s + "%%";
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Department dept = new Department(); // 하나의 row 담기 위한 객체
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				deptlist.add(dept);		
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return deptlist;
	}
}