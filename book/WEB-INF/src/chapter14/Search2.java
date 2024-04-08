package chapter14;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns={"/chapter14/search2"})
public class Search2 extends HttpServlet {
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();

			int price=Integer.parseInt(
				request.getParameter("price"));

			PreparedStatement st=con.prepareStatement(
				"select * from product where price<=?");
			st.setInt(1, price);
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("id"));
				out.println("：");
				out.println(rs.getString("name"));
				out.println("：");
				out.println(rs.getInt("price"));
				out.println("<br>");
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
