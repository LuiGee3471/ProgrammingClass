package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(description = "프로그램 실행 시 걸린 시간 체크하는 필터", urlPatterns = { "/*" }, initParams = {
    @WebInitParam(name = "Time", value = "0", description = "기준시간") })
public class TimeFilter implements Filter {

  public TimeFilter() {
  }

  public void destroy() {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    
    // request
    long start = System.currentTimeMillis();
    chain.doFilter(request, response);
    // response
    long end = System.currentTimeMillis();
    System.out.println("걸린 시간: " + (end - start) / 1000f);
  }

  public void init(FilterConfig fConfig) throws ServletException {
  }

}
