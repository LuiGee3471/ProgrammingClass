package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemoDao;
import kr.or.bit.dto.Memo;

public class MemoAddService implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = null;
    
    try {
      String id = request.getParameter("id");
      String email = request.getParameter("email");
      String content = request.getParameter("memo");

      MemoDao dao = new MemoDao();
      Memo memo = new Memo();
      memo.setId(id);
      memo.setEmail(email);
      memo.setContent(content);
      int result = dao.insertMemo(memo);

      String msg = "";
      String url = "";
      
      if (result > 0) {
        msg = "등록 성공";
        url = "MemoList.memo";
      } else {
        msg = "등록 실패";
        url = "memo.html";
      }
      
      request.setAttribute("board_msg", msg);
      request.setAttribute("board_url", url);
      
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("/WEB-INF/views/redirect.jsp");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return forward;
  }
}
