package sec12.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 데이타베이스 연동기능.(연결하고 동작(SQL문 실행))
// JDK안에 JDBC기능 라이브러리.
public class MemberDAO {

	
	private	Connection conn; // 데이타베이스 연결목적
	private PreparedStatement pstmt;  // 연결상태에서 SQL문 실행목적
	//private ResultSet rs; // SQL문 Select문 실행시 출력되는 결과를 저장하는 목적
	
	// 오라클 데이타베이스 연결정보
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "jspuser";
	private String pw = "jspuser";
	
	public MemberDAO() {
	
	}
	
	public Connection getConnection() throws SQLException {
		if(conn == null || conn.isClosed()) {
			try {
				// 메모리상에 DriverManager 객체가 로딩.
				// "oracle.jdbc.OracleDriver" 오라클에서 제공하는 JDBC 드라이버에서 참조.
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// conn객체가 생성된다.(데이타베이스와 연결상태)
			// conn객체가 생성시 오류가 나면, url, uid, pw 파라미터값이 문제일 수 있다.
			conn = DriverManager.getConnection(url, uid, pw);
		}
		
		return conn;

	}
	
	
	//기능.
	
	//회원가입(insert)
	public void insMember(MemberVO vo) {
		try {
			//1)Connection객체생성
			conn = getConnection(); // open
			
			
			//2)쿼리준비
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			
			// id컬럼에 동일한 데이터 삽입하면 제약조건 unique constraint 에러발생
			String sql = "insert into t_member(id,pwd,name, email)";
			sql += " values(?, ?, ?, ?)";
			
			// sql변수안에 ?(placeholder)에 값을 대입한 insert문이 완성된다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			//3)쿼리실행
			//sql변수의 insert문을 오라클데이타베이스서버에게 실행요청한다.
			pstmt.executeUpdate(); // sql문이 insert, delete, update에 사용할 메서드
		
			//4)연결닫기
			pstmt.close();
			conn.close();
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//회원삭제(delete)
	public void delMember(String id) {
		
		try {
			conn = getConnection();
			
			// t_member where
			String sql = "delete from t_member" + " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//회원목록(select)
	public List<MemberVO> listMembers() {
		// 회원테이블의 모든데이타를 list컬렉션객체 저장
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		
		try {
			//1)Connection객체생성
			conn = getConnection();
			
			//2)
			String sql = "select * from t_member";
			pstmt = conn.prepareStatement(sql);
			
			// 데이터 존재유무를 떠나서 rs객체가 생성이 되고, 커서라는 것이 존재한다.
			// 커서의 현재위치는 제목행(헤더)라는 곳을 가리킨다.
			ResultSet rs = pstmt.executeQuery(); // sql문이 select 일 경우 사용
			
			// rs.next() : 커서를 다음위치로 이동하면서, 데이타가 존재하면 true, 존재하지않으면 false 
			while(rs.next()) {
				
				// rs객체로 데이타를 읽어옴.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(rs.getDate("joinDate"));
				
				list.add(vo);
				
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // open
		
		return list;
	}
	
	 
}
