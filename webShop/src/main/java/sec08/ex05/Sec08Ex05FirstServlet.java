package sec08.ex05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

//바인딩
@WebServlet("/Sec08Ex05FirstServlet")
public class Sec08Ex05FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Sec08Ex05FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //한글깨짐방지
		
		response.setContentType("text/html;charset=utf-8");
		
		// request객체: 클라이언트에서 보내온 모든정보를 관리하는 객체.
		/*
		 - 사용자가 입력한 데이타.
		 - 클라이언트의 브라우저 종류,버전,IP 등 
		 */
		
		// request객체에 정보를 추가작업
		request.setAttribute("address", "서울시 노원구 이젠빌딩");
		
		//주소이동.  이동주소가 클라이언트로 보내져서 새로운 주소요청작업이 발생된다.
		//새로운 주소요청작업은 이전 Request객체와는 다른 새로운Request객체로 이전정보를 참조할 수가 없다.
		response.sendRedirect("/Sec08Ex05SecondServlet");
	}


}
