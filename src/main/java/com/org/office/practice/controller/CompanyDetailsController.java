package com.org.office.practice.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.office.practice.data.CompanyDetail;



@RestController
@RequestMapping("/company-details")
public class CompanyDetailsController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostMapping("/create")
	public Long createCompanyDetail(@RequestBody CompanyDetail companyDetailObjectRequest) {
		String name = companyDetailObjectRequest.getName();
		String address = companyDetailObjectRequest.getAddress();
		String industry = companyDetailObjectRequest.getIndustry();
		String city = companyDetailObjectRequest.getCity();
		
		String sql = "INSERT INTO company_details (name, address, industry, city) VALUES (?, ?, ?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setString(2, address);
				ps.setString(3, industry);
				ps.setString(4, city);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}

	@PostMapping("/update-by-id")
	public int  updateCompanyDetail(@RequestBody CompanyDetail companyDetailObjectRequest ) {
		int id = companyDetailObjectRequest.getId();
		String name = companyDetailObjectRequest.getName();
		String address = companyDetailObjectRequest.getAddress();
		String industry = companyDetailObjectRequest.getIndustry();
		String city = companyDetailObjectRequest.getCity();
		
		String sql = "UPDATE company_details set name = ? ,address =?, industry = ?, city =? where id = ? ";
		return jdbcTemplate.update(sql, name, address, industry, city, id);

	}

	@GetMapping("/delete-by-id")
	int deleteCompanyDetail(int id) {

		String sql = "delete from company_details  where id = ? ";
		return jdbcTemplate.update(sql, id);

	}

	@GetMapping("/deleteAll")
	int deleteAllCompanyDetail() {
		String sql = "delete from company_details  ";
		return jdbcTemplate.update(sql);

	}

	@GetMapping("/retrive-by-id")
	CompanyDetail retriveCompanyDetail(int id) {

		String sql = "SELECT * FROM company_details where id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				(rs, rowNum) -> new CompanyDetail(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("industry"), rs.getString("city")));
	}

	@GetMapping("/retriveAll")
	List<CompanyDetail> retriveAllCompanyDetail() {
		String sql = "SELECT * FROM company_details";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new CompanyDetail(rs.getInt("id"), rs.getString("name"),rs.getString("address"), rs.getString("industry"), rs.getString("city")));
	}
}
