package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonController {

	public PersonController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 고정적인 반복 -- DB 연결, 자원 반납 -> 공통적인 메서드 정의.. 메서드마다 호출해서 사용
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");		
		return conn;
	}
	
	// 5. 자원 반납
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	// 변동적인 반복 -- 비즈니스 로직(Database Access Object)
	// person 테이블에 추가 - INSERT
	public int addPerson(int id, String name, String address) throws SQLException {

		Connection conn = getConnect();
		
		// 3. 쿼리문 -> PreparedStatement
		String query = "insert into person values (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		int result = ps.executeUpdate();
		
		// 5. 자원 반납
		closeAll(ps, conn);
		
		return result;

	}

	// person 테이블에서 데이터 수정 - UPDATE
	public int updatePerson(int id, String address) throws SQLException {

		Connection conn = getConnect();
		
		// 3. 쿼리문 -> PreparedStatement
		String query = "update person set address = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 4. 실행
		ps.setString(1, address);
		ps.setInt(2, id);

		int result = ps.executeUpdate();

		closeAll(ps, conn);
		
		return result;
	}

	// person 테이블에서 데이터 삭제 - DELETE
	public int removePerson(int id) throws SQLException {
		
		Connection conn = getConnect();
		
		// 3. 쿼리문 -> PreparedStatement
		String query = "delete from person where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		//4. 실행
		ps.setInt(1, id);
		
		int result = ps.executeUpdate();
		
		closeAll(ps, conn);
		
		return result;
	}

	// person 테이블에 있는 데이터 전체 보여주기
	public ArrayList<Person> searchAllPerson() throws SQLException {

		Connection conn = getConnect();
		
		// 3. 쿼리문 -> PreparedStatement
		String query = "select * from person";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 4. 실행
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();
		
		 while (rs.next()) {
			 // 생성자 방식
//			 list.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
			 
			 // setter 방식
			 Person person = new Person();
			 person.setId(rs.getInt("id"));
			 person.setName(rs.getString("name"));
			 person.setAddress(rs.getString("address"));
			 list.add(person);
		 }
		closeAll(rs, ps, conn);
		return list;
	}
	

	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public Person searchPerson(int id) throws SQLException {
		
		Connection conn = getConnect();
		
		// 3. 쿼리문 -> PreparedStatement
		String query = "select * from person where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		// 4. 실행
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		Person person = null;
		
		 if (rs.next()) {
			person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
		 }
		 
		 
		 closeAll(rs, ps, conn);

		
		return person;
	}

}