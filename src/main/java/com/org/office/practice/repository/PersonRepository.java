package com.org.office.practice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.office.practice.controller.PersonController;
import com.org.office.practice.data.PersonData;
import com.org.office.practice.data.QualificationData;
import com.org.office.practice.dto.AgeOfpersonData;
import com.org.office.practice.dto.CountByEducationData;
import com.org.office.practice.dto.PersonBornBetweenYearData;

@Repository
public class PersonRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public long createPersonData(String name, String gender, String dob, String status, String bloodGroup) 
	{
		String sql = "INSERT INTO person ( Name, Gender, DOB , Status , Bloodgroup ) values ( ?, ?, ? , ? , ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() 
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setString(2, gender);
				ps.setString(3, dob);
				ps.setString(4, status);
				ps.setString(5, bloodGroup);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}

	public List<PersonData> retriveAllPersonData() 
	{
		String sql = "SELECT * FROM person";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new PersonData(rs.getInt("person_id"), rs.getString("Name"),
				rs.getString("Gender"), rs.getDate("DOB"), rs.getString("Status"), rs.getString("Bloodgroup"), null));
	}

	public PersonData retrivePersonData(int personId) 
	{

		String sql = " SELECT * FROM person where person_id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] { personId },
				(rs, rowNum) -> new PersonData(rs.getInt("person_id"), rs.getString("Name"), rs.getString("gender"),
						rs.getDate("DOB"), rs.getString("Status"), rs.getString("Bloodgroup"),null));

	}

	public long updatePersonData(String name, String gender, String dob, String status, String bloodGroup,
			int personId) 
	{
		String sql = " UPDATE person set Name = ? , Gender= ?, DOB =?, " 
			+ "Status =?,Bloodgroup=? where person_id = ? ";
		return jdbcTemplate.update(sql, name, gender, dob, status, bloodGroup, personId);
	}

	public long deletePersonData(int personId) 
	{

		String sql = " delete from person  where person_id = ? ";
		return jdbcTemplate.update(sql, personId);

	}

	public long deleteAllPersonData() 
	{
		String sql = "delete from person  ";
		return jdbcTemplate.update(sql);

	}

	public List<CountByEducationData> getCountByEducationGrade() 
	{

		String sql = " select grade_degree, count(*) as count from qualification group by grade_degree; ";
		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new CountByEducationData(rs.getString("grade_degree"), rs.getInt("count")));
	}

	public List<PersonBornBetweenYearData> getPersonBornbetweenYears(int fromYear, int toYear)
	{
		String sql = " select person_id, name, dob from person where year(DOB) between ? and ?  ";
		return jdbcTemplate.query(sql, new Object[] {fromYear , toYear},
				(rs, rowNum) -> new PersonBornBetweenYearData(rs.getInt("person_id"), 
						rs.getString("name"), rs.getDate("dob")));
	}



	public List<AgeOfpersonData> getAllPersonsAgeWithNameAndPersonId() 
	{
		String sql = " select person_id, name, timestampdiff(year, DOB, curdate()) as age from person ";
		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new AgeOfpersonData(rs.getInt("person_id"), rs.getString("name"), rs.getInt("age")));
	}
	
	
	
}