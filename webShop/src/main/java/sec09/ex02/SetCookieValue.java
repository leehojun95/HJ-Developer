package sec09.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 쿠키목적: 쿠키정보를 서버측의 메모리 또는 데이타베이스에 저장하지 않고, 사용자 측(클라이언트)에 저장하여, 서버측의 부담을 덜고자 할때 사용.
// 쿠키내용: 보안적이지 않은 정보.
// 쿠키를 사용자의 브라우저에 저장하는 예제.
@WebServlet("/SetCookieValue")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookieValue() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		//클라이언트(브라우저)에게 보내는 작업
		PrintWriter out = response.getWriter();
		Date d = new Date();
		
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.", "utf-8"));
		cookie.setMaxAge(1 * 24 * 60 * 60); // 1일 보관
		
		// 이 작업을 하면, 클라이언트(브라우저)에게 쿠키 정보가 전송된다.
		response.addCookie(cookie);
		
		out.println("현재시간 : " + d);
		out.println("<br>문자열을 Cookie에 저장합니다.");
		
	}

}
