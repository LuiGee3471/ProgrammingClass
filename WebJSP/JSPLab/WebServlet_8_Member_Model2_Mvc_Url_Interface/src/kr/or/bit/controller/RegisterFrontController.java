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
import kr.or.bit.dao.MvcRegisterDao;
import kr.or.bit.dto.MvcRegister;
import kr.or.bit.service.LoginProcessAction;
import kr.or.bit.service.MemberWriteAction;

// @WebServlet("/Register.do") >> command
// 실제로 들어오는 주소는 같다
// Register.do?cmd=register 회원가입
// Register.do?cmd=registerlist 회원 목록

// Url 방식 > 주소가 고정되면 안됨
// "*.do" > a.do, b.do, asdasd.do... 전부

@WebServlet("*.do")
public class RegisterFrontController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public RegisterFrontController() {

  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 1. 요청 받기
    // String command = request.getParameter("cmd");
    // Url 방식은 cmd parameter가 없다
    
    // 주소값
    // register.do
    // registerok.do
    // registerlist.do...
    
    // 주소 요청의 판단 근거를 제공하는 함수
    String requestUri = request.getRequestURI();
    String contextPath = request.getContextPath();
    String urlCommand = requestUri.substring(contextPath.length()); 
    
    // requestURI: /WebServlet_7_Member_Model2_Mvc_Url/Register.do
    // contextPath: /WebServlet_7_Member_Model2_Mvc_Url
    // urlCommand: /Register.do
    
    // 추가 코드
    ActionForward forward = null; // redirect 여부, 이동할 path의 정보를 가진 클래스
    Action action = null;
    /////////////////////////////////////
    
    System.out.println("requestUri: " + requestUri);
    System.out.println("contextPath: " + contextPath);
    System.out.println("urlCommand: " + urlCommand);
    
    // 2. 요청 판단 처리
    if (urlCommand.equals("/Register.do")) { // 회원 가입 페이지 전달(업무)
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("/WEB-INF/Register/Register.jsp");
    } else if (urlCommand.equals("/ok.do")) { // 회원 가입 처리(업무)
      action = new MemberWriteAction();
      forward = action.execute(request, response);
    } else if (urlCommand.equals("/login.do")) {
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("/WEB-INF/Register/login.jsp");
    } else if (urlCommand.equals("/loginok.do")) {
      action = new LoginProcessAction();
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
