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

@WebFilter(urlPatterns = { "/*" }, initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8", description = "인코딩 형식") })
public class EncodingFilter implements Filter {
  private String encoding;

  public EncodingFilter() {

  }

  public void destroy() {

  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    if (request.getCharacterEncoding() == null) {
      request.setCharacterEncoding(encoding);
    }
    
    chain.doFilter(request, response);
  }

  public void init(FilterConfig fConfig) throws ServletException {
    encoding = fConfig.getInitParameter("encoding");
  }

}
