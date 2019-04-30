package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.EmpDeleteAction;
import kr.or.bit.service.EmpListAction;
import kr.or.bit.service.EmpLoginAction;
import kr.or.bit.service.EmpRegisterAction;
import kr.or.bit.service.EmpUpdateAction;
import kr.or.bit.service.EmpUploadAction;

@WebServlet("*.do")
public class EmpController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EmpController() {

  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    String requestUri = request.getRequestURI();
    String contextPath = request.getContextPath();
    String urlCommand = requestUri.substring(contextPath.length());
    System.out.println(requestUri);
    System.out.println(contextPath);
    System.out.println(urlCommand);
    
    Action action = null;
    ActionForward forward = null;
    if (urlCommand.equals("/login.do")) {
      action = new EmpLoginAction(); 
      forward = action.execute(request, response);
    } else if (urlCommand.equals("/list.do")) {  // 조회
      action = new EmpListAction(); 
      forward = action.execute(request, response);
      System.out.println("리스트 액션");
    } else if (urlCommand.equals("/register.do")) {
      action = new EmpRegisterAction();
      forward = action.execute(request, response);
    } else if (urlCommand.equals("/update.do")) {
      action = new EmpUpdateAction();
      forward = action.execute(request, response);
    } else if (urlCommand.equals("/delete.do")) {
      action = new EmpDeleteAction();
      forward = action.execute(request, response);
    } else if (urlCommand.equals("/upload.do")) {
      action = new EmpUploadAction();
      forward = action.execute(request, response);
    }
    
    if (forward != null) {
      if (forward.isRedirect()) {
        response.sendRedirect(forward.getPath());
      } else {
        RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
        dis.forward(request, response);
      }
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

}
