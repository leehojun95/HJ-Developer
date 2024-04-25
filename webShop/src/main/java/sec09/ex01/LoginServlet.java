package sec09.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec09Ex01LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id"); // admin
		String user_pw = request.getParameter("user_pw"); // 1234
		
		// hidden필드의 값을 여기서 확인한다.
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		// db를 이용하여, 아이디및비밀번호 존재여부체크작업
		// 사용자가 입력한 로그인정보가 admin 이고, 1234 일 경우, if문은 true가된다.
		if(user_id.equals("admin") && user_pw.equals("1234")) {
			// 인증된 사용자로 처리작업 - session객체를 이용하는 방식.
			
			// 브라우저에게 발급해준 JSessionID 의 식별자값으로 활성화된 서버측의 사용자별메모리에 "auth"키이름으로 user_id변수의 값을 저장
			request.getSession().setAttribute("auth", user_id);
			
			response.sendRedirect("/sec09/main.jsp");
			
		}else {
			// 인증이 실패.
			
			// 클라이언트로 사용하는 브라우저에 아래 정보가 전송된다.
			
			//브라우저보 보내느 한글데이타 인코딩과 콘텐트에 MIME TYPE작업
			response.setContentType("text/html;charset=utf-8");
			
			// 브라우저로 전송된다.
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('로그인정보가 틀렸습니다. 확인해주세요.');");
			out.print("location.href='/sec09/login.jsp';");
			out.print("</script>");
		}
	}

}
