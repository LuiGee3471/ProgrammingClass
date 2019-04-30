package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;

public class EmpLoginAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();
    String id = request.getParameter("id");
    String pwd = request.getParameter("password");
    
    // System.out.println(id + pwd);
    
    EmpDao dao = new EmpDao();
    boolean login = dao.login(id, pwd);
    
    String msg = "";
    String url = "";
    
    if (login) {
      msg = id + "님, 환영합니다.";
      url = "list.do";
    } else {
      msg = "일치하는 회원 정보가 없습니다.";
      url = "index.html";
    }
    
    request.setAttribute("msg", msg);
    request.setAttribute("url", url);
    
    forward.setRedirect(false);
    forward.setPath("/WEB-INF/views/redirect.jsp");
    
    return forward;
  }
}
