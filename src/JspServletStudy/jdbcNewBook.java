// statement 사용함.
package JspServletStudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jdbcNewBook")
public class jdbcNewBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		// 데이터베이스를 사용하기 위한 코드 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "jin";
		String pw = "1234 ";
		
		Connection con = null;
		Statement stmt = null;
			// 쿼리 전송 객체
		try {
			Class.forName(driver);
				// 오라클의 드라이브가 메모리에 로딩됨
			con = DriverManager.getConnection(url, id, pw);
				// 해당되는 DB에 id와 pw로 접근해서 query로부터 connection객체를 얻어서
				// query를 갖고 java와 oracle을 연결을 함
			stmt = con.createStatement();
				// 자바에서도 query를 날리기 위한 객체 즉, query문으로 통신을 해야하는 객체
			String sql = "insert into book(book_id, book_name, book_loc)";
					sql += " values (book_seq.nextval, '" + bookName + "', '" + bookLoc + "')";
			int result = stmt.executeUpdate(sql);
				// 데이터를 select이외의 경우 executeUpdate문을 사용
				// 반환값은 result로 받게됨
			if(result == 1) {
				out.print("insert success!!");
			} else {
				out.print("insert fail!!");
			}
			
		} catch(Exception e) {
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
