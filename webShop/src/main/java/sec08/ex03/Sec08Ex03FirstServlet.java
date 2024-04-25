package sec08.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sec08Ex03FirstServlet")
public class Sec08Ex03FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sec08Ex03FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 방법3. 결과 : 브라우저 주소가 변경이 된다.변경주소가 클라이언트로 보내지고 해석되어 진행이된다.
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("location.href='/Sec08Ex03SecondServlet';");
		out.print("</script>");
	}

}
