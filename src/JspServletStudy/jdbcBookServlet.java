package JspServletStudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bs")
public class jdbcBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html); charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "jin";
		String pw = "1234";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			String sql = "select * from book";
			res = stmt.executeQuery(sql);
				// 데이터를 select할 때만 executeQuery문을 사용
				// 반환값은 resultSet으로 받게됨
			while (res.next()) {
				int bookId = res.getInt("book_id");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				out.print("bookId : " + bookId + ", ");
				out.print("bookName : " + bookName + ", ");
				out.print("bookLoc : " + bookLoc + "</br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
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
