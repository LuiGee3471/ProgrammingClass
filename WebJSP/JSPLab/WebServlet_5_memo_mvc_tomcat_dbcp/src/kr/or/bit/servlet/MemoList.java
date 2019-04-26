package kr.or.bit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.MemoDao;
import kr.or.bit.dto.Memo;

/**
 * Servlet implementation class MemoList
 */
@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public MemoList() {
  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      MemoDao dao = new MemoDao();
      List<Memo> memolist = dao.selectAll();
      
      // 요청 결과 저장
      request.setAttribute("memolist", memolist);
      
      // view 지정
      RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
      dis.forward(request, response);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

}
