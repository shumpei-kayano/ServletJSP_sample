package chapter5;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

// formのaction属性でgreetingに送信していた
@WebServlet(urlPatterns={"/chapter5/greeting"})
public class Greeting extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		// ユーザーからの入力値も文字エンコーディングが必要
		request.setCharacterEncoding("UTF-8");
		// getParameterメソッドでユーザーからの入力値を取得することができる
		// 引数はinput要素のname属性の値 戻り値はString型
		String user=request.getParameter("user");

		Page.header(out);
		out.println("<p>こんにちは、"+user+"さん！</p>");
		Page.footer(out);
	}
}
