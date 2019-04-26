package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.MvcRegisterDao;
import kr.or.bit.dto.MvcRegister;

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
    
    System.out.println("requestUri: " + requestUri);
    System.out.println("contextPath: " + contextPath);
    System.out.println("urlCommand: " + urlCommand);
    
    // 2. 요청 판단 처리
    String viewPage = "";
    if (urlCommand.equals("/Register.do")) { // 회원 가입 페이지 전달(업무)
      viewPage = "/WEB-INF/Register/Register.jsp";
    } else if (urlCommand.equals("/ok.do")) { // 회원 가입 처리(업무)
      int id = Integer.parseInt(request.getParameter("id"));
      String pwd = request.getParameter("pwd");
      String email = request.getParameter("email");
      
      // controller -> service 객체 처리
      // dao, dto를 통해서 처리
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
      
      // 3. 결과 저장하기
      request.setAttribute("result", resultData);
      viewPage = "/WEB-INF/Register/Register_welcome.jsp";
    }
    
    // 4. 뷰 지정하기
    RequestDispatcher dis = request.getRequestDispatcher(viewPage);
    
    // 5. forward(request 객체의 주소값 공유)
    dis.forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }
}
