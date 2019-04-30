package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Emp;

// CRUD 작업
// DB서버 통신 > CRUD method 제공
// memo table > select, insert, update, delete 함수 제공
// select(다중, 단일), insert, update, delete 5개 함수가 기본

// CRUD 함수 생성 (parameter, return type) 고민
// parameter 객체 (DTO 타입)
// return 객체, 문자열 return

// public int insertMemo(String id, String email, String content) {}
// public int insertMemo(Memo memo) {}

// 단일 select
// public Memo selectByMemoID(String id) {}

// 다중 select
// public List<Memo> selectMemo() {}
// List<Memo> list = new ArrayList<>();
public class EmpDao {
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;
  private DataSource ds;

  public EmpDao() {
    try {
      Context context = new InitialContext(); // 이름 기반 검색
      ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // jdbc/oracle 이름의 pool을 찾음
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public List<Emp> selectAll(){
    List<Emp> list = new ArrayList<>();
    String sql = "select * from copyemp";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Emp emp = new Emp();
        emp.setEmpno(rs.getInt("empno"));
        emp.setEname(rs.getString("ename"));
        emp.setJob(rs.getString("job"));
        emp.setMgr(rs.getInt("mgr"));
        emp.setHiredate(rs.getDate("hiredate"));
        emp.setSal(rs.getInt("sal"));
        emp.setComm(rs.getInt("comm"));
        emp.setDeptno(rs.getInt("deptno"));

        list.add(emp);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    return list;
  }

  public Emp selectByEmpno(int empno) {
    Emp emp = null;
    String sql = "select * from copyemp where empno = ?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, empno);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        emp = new Emp();
        emp.setEmpno(rs.getInt("empno"));
        emp.setEname(rs.getString("ename"));
        emp.setJob(rs.getString("job"));
        emp.setMgr(rs.getInt("mgr"));
        emp.setHiredate(rs.getDate("hiredate"));
        emp.setSal(rs.getInt("sal"));
        emp.setComm(rs.getInt("comm"));
        emp.setDeptno(rs.getInt("deptno"));

      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    return emp;
  }

  public Emp selectByDeptno(int deptno) {
    Emp emp = null;
    String sql = "select * from copyemp where deptno = ?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, deptno);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        emp = new Emp();
        emp.setEmpno(rs.getInt("empno"));
        emp.setEname(rs.getString("ename"));
        emp.setJob(rs.getString("job"));
        emp.setMgr(rs.getInt("mgr"));
        emp.setHiredate(rs.getDate("hiredate"));
        emp.setSal(rs.getInt("sal"));
        emp.setComm(rs.getInt("comm"));
        emp.setDeptno(rs.getInt("deptno"));

      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    return emp;
  }

  public int updateEmp(Emp emp) {
    int row = 0;
    String sql = "update copyemp set ename = ?, job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? where empno = ?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, emp.getEname());
      pstmt.setString(2, emp.getJob());
      pstmt.setInt(3, emp.getMgr());
      pstmt.setInt(4, emp.getSal());
      pstmt.setInt(5, emp.getComm());
      pstmt.setInt(6, emp.getDeptno());
      pstmt.setInt(7, emp.getEmpno());

      row = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return row;
  }

  public int insertEmp(Emp emp) {
    int row = 0;
    String sql = "insert into copyemp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ?, ?, ?, ?, ?)";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, emp.getEmpno());
      pstmt.setString(2, emp.getEname());
      pstmt.setString(3, emp.getJob());
      pstmt.setInt(4, emp.getMgr());
      pstmt.setDate(5, emp.getHiredate());
      pstmt.setInt(6, emp.getSal());
      pstmt.setInt(7, emp.getComm());
      pstmt.setInt(8, emp.getDeptno());

      row = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return row;
  }

  public int deleteEmp(int empno) {
    int row = 0;
    String sql = "delete from copyemp where empno = ?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, empno);

      row = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return row;
  }

  public boolean login(String id, String password) {
    boolean login = false;
    String sql = "select * from adminlist where userid = ? and pwd = ?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, password);
      rs = pstmt.executeQuery();
      
      if (rs.next()) {
        login = true;
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    return login;
  }
}
