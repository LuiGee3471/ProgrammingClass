package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/FrontBoardController")
public class FrontBoardController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public FrontBoardController() {
  }

  // GET ��İ� POST ��� �� ���� �Լ��� �����ϴ� �Լ�
  // 1. HttpServlet�� �����ϴ� service()�� �ִ�
  // 2. ������ ����� ���� �Լ� �����ؼ� ���: doProcess()

  private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) {
    // doGet, doPost ��� ����Ǵ� �Լ�
    System.out.println("Ŭ���̾�Ʈ ��û: " + method);

    // 1. ��û �ޱ� (Get, Post)

    // 2. ��û �Ǵ� (�Ǵ��� ����): command ���
    // Ŭ���̾�Ʈ�� ��û�� � ������ �Ǵ�?
    // 2.1 parameter �������� �Ǵ�
    // 2.2 /board?cmd=login&userid=kglim&pwd=1004
    // String command = request.getParameter("cmd");
    // if (command.equals("login") { �α��� }
    // cmd >> null >> error.jsp ����
    // cmd >> boardlist >> list.jsp ����
    // cmd >> boardwrite >> write.jsp ����

    // URL ���
    // ��ü �ּҰ��� ������ �Ǵ�
    // board/boardlist >> /boardlist
    // board/boardwrite?title=aaa&content=bbb >> /boardwrite
    // if (command.equals("/boardlist") { �Խ��� ��� }
    // if (command.equals("/boardwrite") { �Խ��� �۾��� }

    // ����
    // 1. ��û�ޱ� (command ���)
    // ��û �ּ�
    // localhost:8090/WebServlet_1/board?cmd=list
    String cmd = request.getParameter("cmd");

    // 2. ��û �Ǵ� (������ ���� ���� ����)
    String viewpage = null;
    if (cmd.equals("boardlist")) {
      viewpage = "/board/boardlist.jsp";
      // DB ����
      // SELECT
      // ���� > ���(ResultSet) > ��ü ���
      // boarddao dao = new boarddao();
      // List<board> boardlist = dao.selectboardlist();
      // request.setAttribute("list", boardlist);
      // view page forward
      // <c:set var="list" value="<%=request.getAttribute("list")%>>"
    } else if (cmd.equals("boardwrite.jsp")) {
      viewpage = "/board/boardwrite.jsp";
    } else {
      viewpage = "/error/error.jsp";
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response, "GET");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response, "POST");
  }
}
