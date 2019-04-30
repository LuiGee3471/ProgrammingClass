package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemoDao;
import kr.or.bit.dto.Memo;

public class MemoListService implements Action {
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = null;

    try {
      MemoDao dao = new MemoDao();
      List<Memo> memolist = dao.selectAll();

      request.setAttribute("memolist", memolist);
      
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("/WEB-INF/views/memolist.jsp");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return forward;
  }
}
