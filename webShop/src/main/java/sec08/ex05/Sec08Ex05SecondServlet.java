package sec08.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Sec08Ex05SecondServlet")
public class Sec08Ex05SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sec08Ex05SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//새로운 Request객체로 null이 발생된다.
		String address = (String) request.getAttribute("address");
		
		out.println("<html><body>");
		out.println("주소: " + address);
		out.println("<br>");
		out.println("redirect를 이용한 바인딩 실습입니다.");		
		out.println("</body></html>");
		
		
	}

	

}
