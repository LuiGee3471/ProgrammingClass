package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
  // 지역 변수 만들기
  private String encoding;
  
  public EncodingFilter() {
  }

  public void destroy() {

  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // pass the request along the filter chain
    // request: 요청이 왔을 때 구현되는 보조(공통 관심 코드)
    if (request.getCharacterEncoding() == null) {
      System.out.println("Before: " + request.getCharacterEncoding());
      
      request.setCharacterEncoding(encoding);
      
      System.out.println("After " + request.getCharacterEncoding());
    }
    
    chain.doFilter(request, response); // ************************
    
    // response (응답할 때 처리되는 코드)
    System.out.println("response 응답 처리 ^^");
  }

  // 처음 한 번만 실행
  public void init(FilterConfig fConfig) throws ServletException {
    // 초기화 함수 (한 번 실행)
    /*
     * 
     */
    encoding = fConfig.getInitParameter("encoding");
    System.out.println("Filter init: " + encoding);
  }
}
