package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "이 서블릿은 서버 시간을 처리하는 파일 입니다", urlPatterns = { "/NowServlet", "/Now.do", "/Now.action",
    "/my.star" }, initParams = { @WebInitParam(name = "id", value = "bit", description = "id값을 초기값으로 설정"),
        @WebInitParam(name = "jdbcDriver", value = "oracle.jdbc.oracleDriver", description = "오라클 드라이버 클래스 제공") })
public class NowServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public NowServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  public void init(ServletConfig config) throws ServletException {
    /*
     * 초기화 함수 (자동으로 호출되는 함수): 특정 이벤트(시점)
     * 호출 시점 : NowServlet 클래스에 대한 최초 요청 시 한 번만 실행(서버의 재시작, 코드 수정)
     * 서버 오픈(it.co.kr) > WAS 구성(NowServlet.java)
     * 홍길동 첫 번째 접속자 > it.co.kr/NowServlet 서버에 요청
     * NowServlet.java 컴파일 > 실행 (class) -> init 호출 -> doGet || doPost
     * 김유신 두 번째 접속자 > it.co.kr/NowServlet 요청
     * 실행(class) -> doGet || doPost
     * 
     * init: 다른 클래스 참조, 공통 자원 초기화, 특정 자원 load
     * Class.forName(); 드라이버 로딩 ...> 모든 함수가 사용 가능
     * @WebInitParam 설정 처리
     */
    String drivername = config.getInitParameter("jdbcDriver");
    System.out.println("최초 요청 한 번 실행: 드라이버 로딩 " + drivername);
  }

//  protected void service(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//    System.out.println("service 함수 호출: doGet과 doPost 운명은...");
//  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("doGet() call");
    // 현재는 JSP 페이지가 없는 상황이라 가정
    // Servlet (모든 처리: UI 구성)
    request.setCharacterEncoding("UTF-8");
    // request.getParameter("name");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.print("<html>");
    out.print("<head><title>HELLO</title></head>");
    out.print("<body>");
    out.print("현재날짜: " + new Date() + "<br>");
    out.print("<script>alert('경고')</script>");
    out.print("</body>");
    out.print("</html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("doPost() call");
  }
}
