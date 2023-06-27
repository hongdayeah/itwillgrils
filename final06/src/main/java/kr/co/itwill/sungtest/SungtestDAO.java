package kr.co.itwill.sungtest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class SungtestDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	StringBuilder sql = null;
	
	public SungtestDAO() {
		System.out.println("-----SungtestDAO()객체 생성됨");
	}
	
	//등록
	public int create(SungtestDTO dto) {
		
		int cnt = 0;
		
		try {
			sql = new StringBuilder();
			sql.append(" INSERT INTO sung_test(stest_name) ");
			sql.append(" VALUES (?) ");
			
			cnt = jt.update(sql.toString(), dto.getStest_name());
		}catch(Exception e) {
			System.out.println("SUNG test 등록 실패 : " + e);
		}
		
		return cnt;
	}//create() end
	
	//목록
	public List<SungtestDTO> list(){
		List<SungtestDTO> list = null;
		
		try {
			sql = new StringBuilder();
			sql.append(" SELECT stest_no, stest_name ");
			sql.append(" FROM sung_test ");
			sql.append(" ORDER BY stest_no DESC ");
			
			RowMapper<SungtestDTO> rowMapper = new RowMapper<SungtestDTO>() {
				@Override
				public SungtestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					SungtestDTO dto = new SungtestDTO();
					
					dto.setStest_no(rs.getInt("stest_no"));
					dto.setStest_name(rs.getString("stest_name"));
					
					return dto;
				}//mapRow() end
			};//rowMapper end
			
			list = jt.query(sql.toString(), rowMapper);
		}catch(Exception e) {
			System.out.println("SUNG test 목록 조회 실패 : " + e);
		}
		
		return list;
	}//list() end
	
	//상세보기 (수정을 위해)
	public SungtestDTO read(int stest_no) {
		SungtestDTO dto = null;
		
		try {
			sql = new StringBuilder();
			sql.append(" SELECT stest_no, stest_name ");
			sql.append(" FROM sung_test ");
			sql.append(" WHERE stest_no = " + stest_no);
			
			RowMapper<SungtestDTO> rowMapper = new RowMapper<SungtestDTO>() {
				@Override
				public SungtestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					SungtestDTO dto = new SungtestDTO();
					
					dto.setStest_no(rs.getInt("stest_no"));
					dto.setStest_name(rs.getString("stest_name"));
					
					return dto;
				}//mapRow() end
			};//rowMapper end
			
			dto = jt.queryForObject(sql.toString(), rowMapper);
		}catch(Exception e) {
			System.out.println("SUNG test 상세보기 실패 : " + e);
		}
		
		return dto;
	}//read() end
	
	//수정
	public int update(SungtestDTO dto) {
		int cnt = 0;
		
		try {
			sql = new StringBuilder();
			sql.append(" UPDATE sung_test ");
			sql.append(" SET stest_name = ? ");
			sql.append(" WHERE stest_no = ? ");
			
			cnt = jt.update(sql.toString(), dto.getStest_name(), dto.getStest_no());
			
		}catch(Exception e) {
			System.out.println("SUNG test 수정 실패 : " + e);
		}
		
		return cnt;
	}//update() end
	
	//삭제
	public int delete(int stest_no) {
		int cnt = 0;
		
		try {
			sql = new StringBuilder();
			sql.append(" DELETE FROM sung_test ");
			sql.append(" WHERE stest_no = ? ");
			
			cnt = jt.update(sql.toString(), stest_no);
		}catch(Exception e) {
			System.out.println("SUNG test 삭제 실패 : " + e);
		}
		
		return cnt;
	}//delete() end
}//class end
