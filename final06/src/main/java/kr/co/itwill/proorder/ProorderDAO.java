package kr.co.itwill.proorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProorderDAO {

	public ProorderDAO() {
		System.out.println("-----ProorderDAO()객체 생성됨");
	}
	
	@Autowired
	private JdbcTemplate jt;
	
	StringBuilder sql = null;
	
	
} //class end
