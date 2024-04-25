package sec02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    /*
     1)HttpServletRequest request 객체 : 클라이언트의 요청을 담당. 예 사용자가 입력한 데이터
     2)HttpServletResponse response 객체 : 서버에서 클라이언트로 정보를 보낼때 응답기능
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 서블릿에서 HTML Code 작업하기
		
    	//브라우저에게 보내는 데이타가의 MIME-TYPE : text/html 형식이고, utf-8인코딩으로 해석
    	response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
			
		String data = "<html>";
		data += "<body>";
		data += "아이디: " + u_id;
		data += "비밀번호: " + u_pw;
		data += "</body>";
		data += "</html>";

		out.print(data);
		
	}

}
