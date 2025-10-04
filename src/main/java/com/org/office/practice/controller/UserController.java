package com.org.office.practice.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.office.practice.data.CompanyDetail;
import com.org.office.practice.data.LoginData;
import com.org.office.practice.data.UserDetails;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * This is the login method this method will validate user name and password
	 * present in the db in user table if the user does not exist in the data base
	 * it will return message as "User not Present" If the user exist in the
	 * database and provided wrong password , then it will return message as
	 * "Password is incorrect" if the user is present in the database and provided
	 * password is correct , then this method will return message as
	 * "Login Successfully"
	 */
	@PostMapping("/login")
	public String login(@RequestBody LoginData loginReq) {

		String phone = loginReq.getPhone();
		String password = loginReq.getPassword();
		UserDetails userPresentinDb = null;

		String sql = "Select * from user where phone= ? ";

		try {
			userPresentinDb = jdbcTemplate.queryForObject(sql, new Object[] { phone },
					(resultSet, rowNum) -> new UserDetails(resultSet.getInt("id"), resultSet.getString("name"),
							resultSet.getString("gender"), resultSet.getString("phone"),
							resultSet.getString("password")));
		} catch (EmptyResultDataAccessException ex) {
			return "User not found";
		}
		if (userPresentinDb == null) {
			return "User not found";
		} else {

			if (userPresentinDb.getPassword().equals(password)) {
				return "Login Successfull";
			} else {
				return "Password is incorrect";
			}

		}

	}

	@PostMapping("/create")
	public Long createUser(@RequestBody UserDetails userDetailsObjectRequest) {

		String name = userDetailsObjectRequest.getName();
		String gender = userDetailsObjectRequest.getGender();
		String phone = userDetailsObjectRequest.getPhone();
		String password = userDetailsObjectRequest.getPassword();
		String sql = "INSERT INTO user  (name, gender, phone , password ) VALUES (?, ? , ? , ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setString(2, gender);
				ps.setString(3, phone);
				ps.setString(4, password);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}

	@PostMapping("/update-by-id")
	public int updateUserDetails(@RequestBody UserDetails userDetailsObjectRequest) {

		int id = userDetailsObjectRequest.getId();
		String name = userDetailsObjectRequest.getName();
		String gender = userDetailsObjectRequest.getGender();
		String phone = userDetailsObjectRequest.getPhone();
		String password = userDetailsObjectRequest.getPassword();
		String sql = "UPDATE user set name = ? , gender =? , phone =?, password=? where id = ? ";
		return jdbcTemplate.update(sql, name, gender, phone, password, id);

	}

	@GetMapping("/delete-by-id")
	int deleteUserDetails(int id) {

		String sql = "delete from user  where id = ? ";
		return jdbcTemplate.update(sql, id);

	}

	@GetMapping("/deleteAll")
	int deleteAllUserDetails() {
		String sql = "delete from user  ";
		return jdbcTemplate.update(sql);

	}

	@GetMapping("/retriveAll")
	List<UserDetails> retriveAllUserDetails() {
		String sql = "SELECT * FROM user";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new UserDetails(rs.getInt("id"), rs.getString("name"),
				rs.getString("gender"), rs.getString("phone"), rs.getString("password")));
	}

	@GetMapping("/retrive-by-id")
	UserDetails retriveUserDetails(int id) {

		String sql = "SELECT * FROM user where id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> new UserDetails(rs.getInt("id"),
				rs.getString("name"), rs.getString("gender"), rs.getString("phone"), rs.getString("password")));
	}

}
