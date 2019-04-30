package kr.or.bit.service;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemoDao;

// POINT 비동기(ajax)
// 동기식 처리와 같은 process

public class MemoIdCheckService implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    String hasId = null;
    ActionForward forward = null;
    
    try {
      String id = request.getParameter("id");
      MemoDao dao = new MemoDao();
      hasId = dao.hasId(id);
      request.setAttribute("message", hasId);
      
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("/WEB-INF/views/uservalid.jsp");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return forward;
  }
}
