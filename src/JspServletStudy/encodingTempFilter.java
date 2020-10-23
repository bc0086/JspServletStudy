package JspServletStudy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class encodingTempFilter implements Filter { 
// TempFilter라는 클래스를 생성하였는데 이 클래스는 Filter라는 인터페이스를 implements하고 있다.
// Filter인터페이스는 여기서는 3가지의 method를 제공하고 있다.
// web.xml에 필터를 맵핑 시킬 것.
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("-- filter init() --");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("-- filter doFilter() --");
		
		// request filter
		req.setCharacterEncoding("UTF-8");
			// 사용자로부터 데이터가 오는 부분을 인코딩한다.
		
		chain.doFilter(req, res);
		
		// response filter
	}
	
	@Override
	public void destroy() {
		System.out.println("-- filter destory() --");
	}

}
