package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MvcRegisterDao;
import kr.or.bit.dto.MvcRegister;

// 서비스 클래스
public class MemberWriteAction implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    String pwd = request.getParameter("pwd");
    String email = request.getParameter("email");
    
    MvcRegister dto = new MvcRegister();
    dto.setId(id);
    dto.setPwd(pwd);
    dto.setEmail(email);
    
    MvcRegisterDao dao = new MvcRegisterDao();
    int result = dao.writeOk(dto);
    
    String resultData = "";
    if (result > 0) {
      resultData = "Welcome to bit, " + dto.getId();
    } else {
      resultData = "Insert Failed, try again";
    }
    
    request.setAttribute("result", resultData);
    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("/WEB-INF/Register/Register_welcome.jsp");
    
    return forward;
  }
}
