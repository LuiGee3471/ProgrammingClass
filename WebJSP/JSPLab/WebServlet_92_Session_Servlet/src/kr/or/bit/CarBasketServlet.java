package kr.or.bit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/carbasket")
public class CarBasketServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CarBasketServlet() {
  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 장바구니 목록 보기
    // session에서 정보 출력
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    HttpSession session = request.getSession(); // 서블릿마다 들어가는 코드
    /*
     * 1. getSession() or getSession(true) - HttpSession이 존재하면 그 HttpSession 객체를
     * 반환하고 - 존재하지 않으면 새로운 세션을 생성한다 2. getSession(false) - HttpSession이 존재하면 현재
     * HttpSession 객체를 반환하고 - 존재하지 않으면 null을 반환한다
     */

    out.print("<html>");
    out.print("<body>");
    out.print("<h3>장바구니</h3>");
    if (session != null) {
      // 구매한 상품 리스트 출력하기
      List<String> list = (ArrayList<String>) session.getAttribute("productlist");
      out.print("상품 목록: " + list.toString() + "<br>");
    } else {
      out.print("장바구니가 비어있습니다.<br>");
    }
    out.print("<a href='Product.html'>상품 구매 페이지 이동</a><br>");
    out.print("<a href='cardelete'>장바구니 비우기</a>");
    out.print("</body>");
    out.print("</html>");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

}
