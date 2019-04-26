package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.MvcRegister;

public class MvcRegisterDao {
  private static DataSource ds;
  // 1. 생성자에서 ds를 초기화
  // 2. static 초기자: static{}
  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  static {
    InitialContext ctx;
    try {
      ctx = new InitialContext();
      Context envctx = (Context) ctx.lookup("java:comp/env"); // 기본 설정: 바뀌지 않는다
      ds = (DataSource) envctx.lookup("/jdbc/oracle"); // context.xml에서 name = 'jdbc/oracle'을 찾는 것 >> name은 변경 가능
    } catch (Exception e) {
      System.out.println("lookup failed: " + e.getMessage());
    }
//    Context context = new InitialContext();
//    ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
  }

  // CRUD 함수
  public int writeOk(MvcRegister dto) {
    int row = 0;

    try {
      conn = ds.getConnection();
      String sql = "insert into mvcregister(id, pwd, email) values (?, ?, ?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dto.getId());
      pstmt.setString(2, dto.getPwd());
      pstmt.setString(3, dto.getEmail());
      
      row = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println("writeOk function failed: " + e.getMessage());
      row = -1;
      return row;
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
      }
      
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
      }
    }
    return row;
  }

  // 단일 select 함수
  // 다중 select 함수
  // update 함수
  // delete 함수
}
