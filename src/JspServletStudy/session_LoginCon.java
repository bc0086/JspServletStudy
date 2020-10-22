package JspServletStudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session_LoginCon")
public class session_LoginCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session을 출력
		PrintWriter out = response.getWriter();
		
		String mID = request.getParameter("mID");
		String mPW = request.getParameter("mPW");
		
		out.print("mID : " + mID);
		out.print("mPW : " + mPW);
		
		// session은 request객체로부터 얻어 낼 수 있다.
		// session은 HttpSession인터페이스를 통해서 담는다.
		HttpSession session = request.getSession();
		session.setAttribute("memberId", mID);
		
		response.sendRedirect("session_LoginOk.jsp");
			// 해당 session_LoginOk.jsp 화면을 만들어야 한다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
