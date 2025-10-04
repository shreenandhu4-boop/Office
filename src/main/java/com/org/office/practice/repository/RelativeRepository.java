package com.org.office.practice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.org.office.practice.data.QualificationData;
import com.org.office.practice.data.RelativeData;

@Repository
public class RelativeRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Long createRelativeData(String name, String phoneNo, String relationship) {
		String sql = "INSERT INTO relatives ( name, phone_no, relationship, per_id ) VALUES (?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setString(2, phoneNo);
				ps.setString(3, relationship);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}
	
 public	RelativeData retriveRelativeData(int rId) 
 	{

		String sql = "SELECT * FROM relatives where r_id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { rId }, (rs, rowNum) -> new RelativeData(rs.getInt("r_id"), 
				rs.getString("name"), rs.getString("phone_no"), rs.getString("relationship"),null));
	}
 
 public	List<RelativeData> retriveRelativeDataByPersonId(int personId) 
 	{

		String sql = "SELECT * FROM relatives where per_id = ?";

		return jdbcTemplate.query(sql, new Object[] { personId }, (rs, rowNum) -> new RelativeData(rs.getInt("r_id"), 
				rs.getString("name"), rs.getString("phone_no"), rs.getString("relationship"), null));
	}
 
 
 public long updateRelativeData(String name, String phoneNo, String relationship, int rId)
 	{
 
	 	String sql = "UPDATE relatives set name = ? , phone_no =?, relationship= ?, per_id =? where r_id = ? ";
	return jdbcTemplate.update(sql, name, phoneNo, relationship, rId);
 	}
 
 public long deleteRelativeData(int rId) 
 	{
	    
	 String sql = "delete from relatives  where r_id = ? ";
		return jdbcTemplate.update(sql, rId);

 	}
 public long deleteAllRelativeData() 
 	{
	 
	 String sql = "delete from relatives ";
	return jdbcTemplate.update(sql);
 	}
 
 
public  List<RelativeData> retriveAllRelativeData() 
	{
		String sql = "SELECT * FROM relatives";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new RelativeData(rs.getInt("r_id"), rs.getString("name"),
						rs.getString("phone_no"), rs.getString("relationship"), null));
	}


}
