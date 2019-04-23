package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ����(Servlet)
 * Java ���Ϸ� �� ���񽺸� �� �������� ���� ����
 * ���� ���� : request, response ��ü ��� ����
 * 
 * 1. extends HttpServlet �ݵ�� �ʿ� (�� ȯ�濡�� �����ϴ� ��û, ���� ��ü ó�� ����)
 * 
 * 2. SimpleController ����
 * 
 * 3. SimpleController ������ �̺�Ʈ ��� ����
 * (�Լ��� Ư�� ��Ȳ�� ���� �ڵ� ȣ��)
 * [��Ȳ] : Ŭ���̾�Ʈ�� SimpleController ��û�� ������ ��
 * ���۹���� GET���� ��û�� ���� �ڵ����� ȣ��Ǵ� �Լ� : doGet
 * ���۹���� POST�� ��û�� ���� �ڵ����� ȣ��Ǵ� �Լ� : doPost
 * HttpServletRequest request, HttpServletResponse response
 * parameter�� ���� �������ν� parameter �ް� ���䵵 �����ϴ�
 * 
 * doGet() ȣ��Ǵ� ��� : <a href="board.do?id=kglim">������ ��û</a>
 * doPost() ȣ��Ǵ� ��� : <form method="POST" ... submit() => doPost()
 * 
 * 3.1 Ŭ���̾�Ʈ�� ������ ���´� : request.getParameter()
 * 
 * 4. ����ܰ�
 * SimpleController (����) �ڹ� ���� ��û -> ������ - Ŭ���� ���� -> ���� -> ��� ����
 * 
 * 5. �ڹ� ��Ƽ ������ (�� ȿ�������� ���)
 * 
 * 6. ������� ����
 * Servlet => JSP => MVC ���� => Framework(Spring)
 * 
 * 7. ����: Model2 ����� MVC ������ ������ ������Ʈ
 * 
 * 7.1: JSP�� ������ ���� > ����(����� Model�� �����(DAO, DTO)) > Model1 ���
 *       JSP�� ��� Ŭ���̾�Ʈ�� ��û�� �ް� ó������ ���
 *      
 *      Model2 ����� MVC
 *      Model(DTO, DAO) >> ������ Java Ŭ����
 *      View >> JSP(EL & JSTL) >> ȭ�� ����
 *      �׷� ���� Ŭ���̾�Ʈ�� ��û�� �ް� �ľ��ϰ� ó���ϴ� ������ ����ұ�
 *      Controller >> Servlet �ۼ�(extends HttpServlet)
 *      1. Ŭ���̾�Ʈ�� ��û�� �ľ� (�α���, �Խ��� �۾���, �Խ��� �󼼺���)
 *      2. ��û �ľ��� ���ؼ� �پ��� MVC�� ����: DTO ��ü ����, DAO ��ü ����
 *      
 * 8. ���� ������ Ŭ���̾�Ʈ���� ��� ��û�ұ�
 * JSP: 
 *   <form action="loginok.jsp" method="POST">
 *   localhost:8090/WebJSP/WebServlet_1/loginok.jsp
 *   
 * 8.2
 * ���� ���� ��û��
 * 1. web.xml ������ ���ؼ� �ּҸ����
 * <servlet>
		<servlet-name>simplecontroller</servlet-name>
		<servlet-class>com.SimpleController</servlet-class>
	</servlet>
	<servlet-mapping>
	    <servlet-name>simplecontroller</servlet-name>
	    <url-pattern>/simple</url-pattern>
	</servlet-mapping>
   localhost:8090/WebServlet_1/simple
	
 * 2. Servlet ������ ��ܿ� @WebServlet("/SimpleController")
 * localhost:8090/WebServlet_1/SimpleController
 * 
 * ���� ��û -> �� �� servlet ������ -> ���� -> doGet or doPost ȣ��
 * �� ��°���� -> �ٷ� ���� -> doGet or doPost ȣ��
 * ���� ��û : 1. ���� ���� 2. �����ڰ� ����
 */

// @WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ŭ���̾�Ʈ ��û");
		
		// 1. ������� ��û �ľ�
		String type = request.getParameter("type");
		
		// 2. ��û�� ���� ���� ���� (service ����)
		Object resultobj = null;
		if (type == null || type.equals("greeting")) {
			resultobj = "Hello, world";
		} else if (type.equals("date")) {
			resultobj = new java.util.Date();
		} else {
			resultobj = "invalid type";
		}
		
		// 3. ��û �Ϸῡ ���� �� ��� ��û�� ����ڿ��� ����
		// ������ ���� : request ��ü, session ��ü, application ��ü
		request.setAttribute("result", resultobj);
		
		// 4. ��� �����ֱ� > �ʿ��� view�� �����Ѵ�.
		// ȭ���� ����� �������� ���ϰ� -> ����� �����͸� �Ѱ��ش�.
		// �����(forward)
    RequestDispatcher	dis =	request.getRequestDispatcher("/simpleView.jsp");
    // ���� view�� ������ ���� forward �۾�
    dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
