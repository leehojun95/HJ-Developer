package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/memberH")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO dao =  new MemberDAO();
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addMember")) {
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String addr = request.getParameter("addr");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pw);
			vo.setName(name);
			vo.setEmail(email);
			vo.setAddr(addr);
			
			dao.insMember(vo);
			
			
		}else if (command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			dao.delMember(id);
			
		}
		
		List<MemberVO> list = dao.listMember();
        out.print("<html><body>");
		
		out.print("<table border=1> <tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>주소</td><td>삭제</td><tr>");
		
		for(int i = 0; i<list.size(); i++) {
			MemberVO memVO = list.get(i);
			String id = memVO.getId();
			String pw = memVO.getPw();
			String name = memVO.getName();
			String email = memVO.getEmail();
			String addr = memVO.getAddr();
			
			out.print("<tr><td>" + id + "</td><td>" + pw + "</td><td>" + name + "</td><td>"
					+ email + "</td><td>" + addr + "</td><td>" +
					"<a href='/memberH?command=delMember&id=" + id + "'>삭제</a></td></tr>");
		}
		out.print("</table>");
		out.print("<a href='/member/memberForm.html'>회원등록</a>");
		out.print("</body></html>");
		
		
		
		
	}
	
	
	
	
}
