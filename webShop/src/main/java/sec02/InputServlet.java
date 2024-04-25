package sec02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//실행주소 localhost:9090/input
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}
    
    // HttpServletRequest request(request객체 / 요청) : 클라이언트에서 보낸 모든 전송정보(요청)를 담당하는 객체.
    // HttpServletResponse response(response객체 / 응답) : 서버에서 가지고 있는 정보를 클라이언트에게 보낼때 담당하는 응답객체.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출됨.");
		
		String user_id = request.getParameter("user_id");
		String pass_pw = request.getParameter("user_pw");
		
		System.out.println("아이디는? " + user_id);
		System.out.println("비밀번호는? " + pass_pw);
	}

}
