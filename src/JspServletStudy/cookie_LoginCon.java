package JspServletStudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie_LoginCon")
public class cookie_LoginCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String mId= request.getParameter("mID");
		String mPw= request.getParameter("mPW");
		
		out.print("mId : " + mId);
		out.print("mPw : " + mPw);
		
		// cookie의 정보는 많을 것이기 때문에 배열로 받는다.
		// cookie는 클라이언트 측에 저장되고, 사용자의 요청이기 때문에 request객체를 사용한다.
		Cookie[] cookies = request.getCookies(); 
		Cookie cookie = null;
		
		// 배열의 정보를 루프를 돌면서 조회를 한다.
		for(Cookie c : cookies) {
			System.out.println("c.getName() : " + c.getName() + "c.getValue() : " + c.getValue());
			
			if(c.getName().equals("memberID")) {
				cookie = c;
			}
		}
		
		// 쿠키가 null이면 새로운 쿠키를 생성한다.
		if(cookie == null) {
			System.out.println("cookie is not null");
			cookie = new Cookie("memberId", mId);
		}
		
		// 결국 쿠키가 있었던 없었던, 서버에서 클라이언트로 response시 쿠키를 보내주게 되있다.
		response.addCookie(cookie);
		cookie.setMaxAge(60*60); // 쿠키의 유효시간 설정
		
		response.sendRedirect("loginOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
