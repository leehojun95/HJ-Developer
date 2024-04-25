package sec02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InputServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글 깨짐방지
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("u_name");
		String id = request.getParameter("u_id");
		String pw = request.getParameter("u_pw");
		String addr = request.getParameter("u_addr");
		String tel = request.getParameter("u_tel");
		
		// 나이를 숫자(정수)로 변환작업
		int age = Integer.parseInt(request.getParameter("u_age"));
		
		System.out.println("이름은? " + name);
		System.out.println("아이디는? " + id);
		System.out.println("비밀번호는? " + pw);
		System.out.println("주소는? " + addr);
		System.out.println("연락처는? " + tel);
		System.out.println("나이는? " + age);
	}

}
