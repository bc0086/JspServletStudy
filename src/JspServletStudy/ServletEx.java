package JspServletStudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// config객체를 가져온다. 그 객체로부터 getInitParameter를 이용해서 파라미터를 가져온다.
		// 그것을 String 타입의 adminId객체와 adminPw객체에 담겠다.
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");
		
		// 출력을 위해서는 PrintWriter클래스를 사용한다.
		// 해당데이터를 가져 올 곳은 response객체에서 getWriter()메소드를 사용하면 된다.
		PrintWriter out = response.getWriter();
		out.print("<p>adminId : " + adminId + "</p>");
		out.print("<p>adminPw : " + adminPw + "</p>");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Context객체를 가져온다. 그 객체로부터 getInitParameter를 이용해서 파라미터를 가져온다.
		// 그것을 String 타입의 imgDir객체와 testServerIP객체에 담겠다.
		String imgDir = getServletContext().getInitParameter("imgDir");
		String testServerIP = getServletContext().getInitParameter("testServerIP");
		
		// 출력하는 방법은 위와 동일하다.
		out.print("<p>imgDir : " + imgDir + "</p>");
		out.print("<p>testServerIP : " + testServerIP + "</p>");
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		// Context객체에 setAttribute() 속성을 이용하여 파라미터를 담았다.		
		getServletContext().setAttribute("connectedIP", "162.62.58.33");
		getServletContext().setAttribute("connectedUser", "gilddong");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
	
}
