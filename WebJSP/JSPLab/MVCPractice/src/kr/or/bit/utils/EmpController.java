package kr.or.bit.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emp;

@WebServlet("/EC")
public class EmpController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EmpController() {
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("search");
    
    try {
      Class.forName("oracle.jdbc.OracleDriver");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Emp> empList = null;
    String result = "";
    
    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
      String sql = "select empno, ename, job, mgr, hiredate, sal, nvl(comm, 0) as commission, dname from emp e " +
                   "inner join dept d on e.deptno = d.deptno where ename like ?";
      
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, "%" + name.toUpperCase() + "%");
      rs = pstmt.executeQuery();
      
      empList = new ArrayList<>();
      if (rs.next()) {
        do {
          Emp e = new Emp();
          e.setEmpno(rs.getInt(1));
          e.setEname(rs.getString(2));
          e.setJob(rs.getString(3));
          e.setMgr(rs.getInt(4));
          e.setHiredate(rs.getDate(5));
          e.setSal(rs.getInt(6));
          e.setComm(rs.getInt(7));
          e.setDname(rs.getString(8));
          empList.add(e);
        } while (rs.next());
        result = "조회 결과: " + rs.getRow() + "명";
      } else {
        result = "조회 결과가 없습니다.";
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        rs.close();
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    
    request.setAttribute("empList", empList);
    request.setAttribute("result", result);
    
    RequestDispatcher rdis = request.getRequestDispatcher("/index.jsp");
    rdis.forward(request, response);
  }
}
