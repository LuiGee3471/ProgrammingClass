package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 서블릿(Servlet)
 * Java 파일로 웹 서비스를 할 목적으로 만든 파일
 * 서블릿 조건 : request, response 객체 사용 가능
 * 
 * 1. extends HttpServlet 반드시 필요 (웹 환경에서 제공하는 요청, 응답 객체 처리 가능)
 * 
 * 2. SimpleController 서블릿
 * 
 * 3. SimpleController 서블릿은 이벤트 기반 동작
 * (함수가 특정 상황에 맞춰 자동 호출)
 * [상황] : 클라이언트가 SimpleController 요청을 보냈을 때
 * 전송방식이 GET으로 요청이 오면 자동으로 호출되는 함수 : doGet
 * 전송방식이 POST로 요청이 오면 자동으로 호출되는 함수 : doPost
 * HttpServletRequest request, HttpServletResponse response
 * parameter를 제공 받음으로써 parameter 받고 응답도 가능하다
 * 
 * doGet() 호출되는 경우 : <a href="board.do?id=kglim">서버에 요청</a>
 * doPost() 호출되는 경우 : <form method="POST" ... submit() => doPost()
 * 
 * 3.1 클라이언트의 정보를 얻어온다 : request.getParameter()
 * 
 * 4. 실행단계
 * SimpleController (서블릿) 자바 파일 요청 -> 컴파일 - 클래스 파일 -> 실행 -> 결과 리턴
 * 
 * 5. 자바 멀티 쓰레드 (웹 효율적으로 사용)
 * 
 * 6. 만들어진 순서
 * Servlet => JSP => MVC 패턴 => Framework(Spring)
 * 
 * 7. 최종: Model2 기반의 MVC 패턴을 적용한 프로젝트
 * 
 * 7.1: JSP만 가지고 개발 > 가능(사실은 Model은 만든다(DAO, DTO)) > Model1 방식
 *       JSP가 모든 클라이언트의 요청을 받고 처리까지 담당
 *      
 *      Model2 방식의 MVC
 *      Model(DTO, DAO) >> 순수한 Java 클래스
 *      View >> JSP(EL & JSTL) >> 화면 구성
 *      그럼 누가 클라이언트의 요청을 받고 파악하고 처리하는 과정을 담당할까
 *      Controller >> Servlet 작성(extends HttpServlet)
 *      1. 클라이언트의 요청을 파악 (로그인, 게시판 글쓰기, 게시판 상세보기)
 *      2. 요청 파악을 통해서 다양한 MVC를 적용: DTO 객체 생성, DAO 객체 생성
 *      
 * 8. 서블릿 파일을 클라이언트에서 어떻게 요청할까
 * JSP: 
 *   <form action="loginok.jsp" method="POST">
 *   localhost:8090/WebJSP/WebServlet_1/loginok.jsp
 *   
 * 8.2
 * 서블릿 파일 요청은
 * 1. web.xml 설정을 통해서 주소만들기
 * <servlet>
		<servlet-name>simplecontroller</servlet-name>
		<servlet-class>com.SimpleController</servlet-class>
	</servlet>
	<servlet-mapping>
	    <servlet-name>simplecontroller</servlet-name>
	    <url-pattern>/simple</url-pattern>
	</servlet-mapping>
   localhost:8090/WebServlet_1/simple
	
 * 2. Servlet 파일의 상단에 @WebServlet("/SimpleController")
 * localhost:8090/WebServlet_1/SimpleController
 * 
 * 최초 요청 -> 그 때 servlet 컴파일 -> 실행 -> doGet or doPost 호출
 * 두 번째부터 -> 바로 실행 -> doGet or doPost 호출
 * 최초 요청 : 1. 서버 시작 2. 개발자가 수정
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
		System.out.println("클라이언트 요청");
		
		// 1. 사용자의 요청 파악
		String type = request.getParameter("type");
		
		// 2. 요청에 따른 업무 수행 (service 실행)
		Object resultobj = null;
		if (type == null || type.equals("greeting")) {
			resultobj = "Hello, world";
		} else if (type.equals("date")) {
			resultobj = new java.util.Date();
		} else {
			resultobj = "invalid type";
		}
		
		// 3. 요청 완료에 따라서 그 결과 요청한 사용자에게 전달
		// 정보를 저장 : request 객체, session 객체, application 객체
		request.setAttribute("result", resultobj);
		
		// 4. 결과 보여주기 > 필요한 view를 지정한다.
		// 화면을 출력할 페이지를 정하고 -> 출력할 데이터를 넘겨준다.
		// 제어권(forward)
    RequestDispatcher	dis =	request.getRequestDispatcher("/simpleView.jsp");
    // 내가 view로 지정한 곳에 forward 작업
    dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
