package kr.or.bit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cardelete")
public class CarDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CarDeleteServlet() {
  }
  
  private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.print("<html><body>");
    HttpSession session = request.getSession();
    if (session != null) {
      // 특정값 (장바구니 비우기)
      // session.removeAttribute("productlist");
      session.invalidate();
    } else {
      out.print("생성된 session이 없어요<br>");
    }
    out.print("<a href='Product.html'>구매 페이지로 돌아가기</a>");
    out.print("</body></html>");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

}
