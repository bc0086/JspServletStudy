package JspServletStudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 여기는 web.xml을 사용하지 않고 어노테이션을 활용하였다.
@WebServlet("/seg")
public class ServletGet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectedIP = (String)getServletContext().getAttribute("connectedIP"); //강제적 형변환 필요
		String connectedUser = (String)getServletContext().getAttribute("connectedUser");
		
		PrintWriter out = response.getWriter();
		out.print("<p>connectedIp : " + connectedIP + "</p>");
		out.print("<p>connectedUser : " + connectedUser + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
