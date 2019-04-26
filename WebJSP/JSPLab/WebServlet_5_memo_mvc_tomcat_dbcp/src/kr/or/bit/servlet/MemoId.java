package kr.or.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.MemoDao;

/*
 * id 검증: 사용자가 입력한 ID가 DB에 있는지 없는지 확인
 */

@WebServlet("/MemoId")
public class MemoId extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public MemoId() {

  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    MemoDao dao = null;
    try {
      dao = new MemoDao();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (NamingException e) {
      e.printStackTrace();
    }
    String hasId = dao.hasId(id);
    response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
    PrintWriter out = response.getWriter();
    out.write(hasId);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }
}
