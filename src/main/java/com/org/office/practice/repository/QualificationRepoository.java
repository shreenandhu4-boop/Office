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
import org.springframework.web.bind.annotation.RequestBody;
import com.org.office.practice.controller.QualificationController;
import com.org.office.practice.data.QualificationData;
import com.org.office.practice.data.ToppersData;
import com.org.office.practice.dto.CountByEducationData;
import com.org.office.practice.dto.PersonQualificationResultSet;


@Repository
public class QualificationRepoository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public long createQualificationData(String gradeDegree, String institute, String yearOfComplition,
			double percentage, String status ) 
	{
		String sql = "INSERT INTO qualification  ( grade_degree, institute, year_of_complition, percentage, status , person_id ) VALUES (?, ?, ?, ? , ? , ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() 
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, gradeDegree);
				ps.setString(2, institute);
				ps.setString(3, yearOfComplition);
				ps.setDouble(4, percentage);
				ps.setString(5, status);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}
	
 public	QualificationData retriveQualificationData(int qId) 
 	{

		String sql = "SELECT * FROM qualification where q_id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { qId }, (rs, rowNum) -> new QualificationData(rs.getInt("q_id"), 
				rs.getString("grade_degree"), rs.getString("institute"), rs.getString("year_of_complition"), 
				rs.getDouble("percentage"), rs.getString("status"), null));
	}
 
 public	List<QualificationData> retriveQualificationDataByPersonId(int personId) {

		String sql = "SELECT * FROM qualification where person_id = ?";

		return jdbcTemplate.query(sql, new Object[] { personId }, 
				(rs, rowNum) -> new QualificationData(rs.getInt("q_id"), rs.getString("grade_degree"),
				rs.getString("institute"), rs.getString("year_of_complition"), rs.getDouble("percentage"), 
				rs.getString("status"), null));
	}
 public long updateQualificationData(String gradeDegree, String institute, String yearOfComplition, 
		 double percentage, String status, int qId)
 	
 {
	 	String sql = "UPDATE qualification set grade_degree = ? , institute =? , year_of_complition= ? , "
	 			+ " percentage =? , status =? , person_id=? where q_id = ? ";
	 	return jdbcTemplate.update(sql, gradeDegree, institute, yearOfComplition, 
	 			percentage, status, qId);
 	
 	}
 
 public long deleteQualificationData(int qId) 
 	{
	    
	 	String sql = "delete from qualification  where q_id = ? ";
		return jdbcTemplate.update(sql, qId);

 	}
 
 public long deleteAllQualificationData() 
 	{
	 
	 	String sql = "delete from qualification ";
	 	return jdbcTemplate.update(sql);
 	}
 
 
public  List<QualificationData> retriveAllQualificationData() 
	
	{
		String sql = "SELECT * FROM qualification";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new QualificationData(rs.getInt("q_id"), rs.getString("grade_degree"),
						rs.getString("institute"), rs.getString("year_of_complition"), rs.getDouble("percentage"),
						rs.getString("status"), null));
	}

public List<ToppersData> retriveTopersInTenthAndTwelfth()
	{
	
	
	String sql =  " SELECT p.person_id, p.name, q.grade_degree, q.percentage "
			+ " FROM person p join qualification q on p.person_id = q.person_id "
			+ " where q.percentage=(SELECT max(percentage) FROM qualification where grade_degree ='10') UNION "
			+ " SELECT p.person_id, p.name, q.grade_degree, q.percentage "
			+ " FROM person p join qualification q on p.person_id= q.person_id "
			+ " where q.percentage=(SELECT max(percentage) FROM qualification where grade_degree ='12') ";
	
	return jdbcTemplate.query(sql,
			(rs, rowNum) -> new ToppersData(rs.getInt("person_id"), rs.getString("name"),
					rs.getString("grade_degree"), rs.getDouble("percentage")));
	}


}
















