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

@WebServlet("/carsave")
public class CarSaveServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CarSaveServlet() {

  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    String product = request.getParameter("product");
    
    // session 다루기
    // request 객체에서 session 얻기
    HttpSession session = request.getSession();
    System.out.println("sessionID: " + session.getId());
    List<String> list = (ArrayList<String>) session.getAttribute("productlist");
    if (product == null) {
      System.out.println("상품 선택하지 않았어요");
    } else {
      if (list == null) {
        System.out.println("list collection is null");
        list = new ArrayList<String>();
        list.add(product);
        session.setAttribute("productlist", list);
        System.out.println("List collection: " + list);
      } else {
        System.out.println("list collection is not null");
        list.add(product);
        System.out.println("List collection: " + list);
      }
    }
    out.print("<html>");
    out.print("<body>");
    out.print("<a href='carbasket'>장바구니 보기</a>");
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
