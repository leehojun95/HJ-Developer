package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "jspuser";
	private String pw = "jspuser";
	
	public MemberDAO() {
		
	}
	
	public Connection getConnection() throws SQLException {
		if(conn == null || conn.isClosed()) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(url,uid,pw);
		}
		return conn;
		
	}
	
	// 가입
	public void insMember(MemberVO vo) {
		try {
		     conn = getConnection();
		
		     String id = vo.getId();
		     String pw = vo.getPw();
		     String name = vo.getName();
		     String email = vo.getEmail();
		     String addr = vo.getAddr();
		
		     String sql ="insert into H_member(id,pw,name,email,addr)";
		     sql +=" values(?, ?, ?, ?, ?)";
		
		     pstmt = conn.prepareStatement(sql);
		     pstmt.setString(1, id);
		     pstmt.setString(2, pw);
		     pstmt.setString(3, name);
		     pstmt.setString(4, email);
		     pstmt.setString(5, addr);
		
		     pstmt.executeUpdate();
		
		     pstmt.close();
		     conn.close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 제거
	public void delMember(String id) {
		try {
			conn = getConnection();
			
			String sql = "delete from H_member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			
			System.out.println("delMember");
			
			pstmt.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	// 목록
	
	public List<MemberVO> listMember(){
		List<MemberVO> list = new ArrayList<MemberVO>();{
			try {
				conn = getConnection();
				
				String sql = "select * from H_member";
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					 String id = rs.getString("id");
					 String pw = rs.getString("pw");
					 String name = rs.getString("name");
					 String email = rs.getString("email");
					 String addr = rs.getString("addr");
					 
					 MemberVO vo = new MemberVO();
					 vo.setId(id);
					 vo.setPw(pw);
					 vo.setName(name);
					 vo.setEmail(email);
					 vo.setAddr(addr);
					 
					 list.add(vo);
				}
				rs.close();
				pstmt.close();
			    conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			
		}
		return list;
		
	}
	
	
}
