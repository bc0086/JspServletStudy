// prepareStatement 사용함.
package JspServletStudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jdbcModifyBook")
public class jdbcModifyBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html); charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "jin";
		String pw = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);
			String sql = "update book set book_loc = ? where book_name = ?";
				// statement와는 순서가 다름.
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "001-00007123");
			pstmt.setString(2, "book7");
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				out.print("update success!!");
			} else {
				out.print("update fail!!");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
