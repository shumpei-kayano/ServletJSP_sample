package chapter10;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class TimeFilter implements Filter {

	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		long time=System.currentTimeMillis();
		chain.doFilter(request, response);
		time=System.currentTimeMillis()-time;
		System.out.println("Time:"+time+"ms");
	}

	public void init(FilterConfig config) {}
	public void destroy() {}
}
