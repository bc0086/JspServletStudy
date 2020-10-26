package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BookDto;

public class connectionPoolBookDao {
	
	DataSource dataSource;
	
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//	String id = "jin";
//	String pw ="1234";

	public connectionPoolBookDao() {
		try {
//			Class.forName(driver);
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookDto> select() {
		
		ArrayList<BookDto> list = new ArrayList<BookDto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
//			con = DriverManager.getConnection(url, id, pw);
			con = dataSource.getConnection();
			String sql = "select * from book";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				int bookId = res.getInt("book_id");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				BookDto bookDto = new BookDto(bookId, bookName, bookLoc);
				list.add(bookDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
