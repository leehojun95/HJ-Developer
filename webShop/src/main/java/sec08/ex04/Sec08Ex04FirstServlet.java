package sec08.ex04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Sec08Ex04FirstServlet")
public class Sec08Ex04FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Sec08Ex04FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		//방법4는 방법1, 2, 3과는 달리, 서버에서 주소가 이동된다. 결과 : 브라우저 주소가 변경이 안된다.
		// 방법1, 2, 3은 주소가 브라우저로 보내지고 해석되어 브라우저에서 변경된 주소가 요청이 발생된다.
		
		
		// request객체를 공유목적
		RequestDispatcher dispatch = request.getRequestDispatcher("/Sec08Ex04SecondServlet");
		dispatch.forward(request, response);
		
	}

}
