package kr.co.itwill.performance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDAO {

	//DBOpen dbopen=new DBOpen()와 동일한 형태
	//@Autowired 스프링컨테이너가 생성해 준 객체를 연결
	@Autowired
	private JdbcTemplate jt;
	
	StringBuilder sql=null;
	
	public PerformanceDAO() {
		System.out.println("-----PerformanceDAO() 객체 생성됨");
	}//end
	
	
	public List<PerformanceDTO> list(String per_code){
		List<PerformanceDTO> list=null;
		try {
			sql=new StringBuilder();
			sql.append(" SELECT per_img,per_code, per_name, per_date, per_time, per_fee, per_exp, per_size, per_filename, class_code  ");
			sql.append(" FROM performance ");
			
			RowMapper<PerformanceDTO> rowMapper=new RowMapper<PerformanceDTO>() {
				@Override
				public PerformanceDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
					PerformanceDTO dto=new PerformanceDTO();
					dto.setPer_img(rs.getString("per_img"));
					dto.setPer_code(rs.getString("per_code"));
					dto.setPer_name(rs.getString("per_name"));
					dto.setPer_date(rs.getString("per_date"));
					dto.setPer_time(rs.getString("per_time"));
					dto.setPer_fee(rs.getInt("per_fee"));
					dto.setPer_exp(rs.getString("per_exp"));
					dto.setPer_filename(rs.getString("per_filename"));
					dto.setPer_size(rs.getLong("per_size"));
					dto.setClass_code(rs.getString("class_code"));
					return dto;	
				} //mapRow() end
			}; //rowMapper end
			
			list=jt.query(sql.toString(), rowMapper);
			
		}catch(Exception e) {
			System.out.println("performance 목록 실패:"+e);
		} //end
		
		return list;
		
	}//list() end
	
	
	public int create(PerformanceDTO dto) {
		int cnt=0;
		try {
			sql=new StringBuilder();
			
			sql.append(" INSERT INTO performance(per_code, per_name, per_date, per_time, per_fee, per_exp, per_img, per_filename, per_size, class_code, per_limit) ");
			sql.append(" VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			
			//SQL문(insert, update, delete)	실행	
			cnt=jt.update(sql.toString(), dto.getPer_code(), dto.getPer_name(), dto.getPer_date(), dto.getPer_time(), dto.getPer_fee(), dto.getPer_exp(), dto.getPer_filename(), dto.getPer_size(), dto.getClass_code(), dto.getPer_limit() );
		
		} catch (Exception e){
			System.out.println("등록 실패" + e );
		}//end
		
		return cnt;
		
	}//create() end

	
	
}
