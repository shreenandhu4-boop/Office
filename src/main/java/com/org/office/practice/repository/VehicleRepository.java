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


import com.org.office.practice.data.VehicleData;

@Repository
public class VehicleRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public long createVehicleData(String type, String model, String brand, String color,
			String vehicleNumber) {
		String sql = "INSERT INTO vehicle ( type, model, brand, color , pers_id, vehicle_no) "
				+ " values (?, ?, ?, ? , ?, ?) ";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, type);
				ps.setString(2, model);
				ps.setString(3, brand);
				ps.setString(4, color);
				ps.setString(5, vehicleNumber);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}

	public List<VehicleData> retriveAllVehicleData() 
	{
		String sql = "SELECT * FROM vehicle";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new VehicleData(rs.getInt("v_id"), rs.getString("type"), rs.getString("model"),
						rs.getString("brand"), rs.getString("color"),
						rs.getString("vehicle_no"),null));
	}

	public VehicleData retriveVehicleData(int vId) 
	{

		String sql = "SELECT * FROM vehicle where v_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { vId },
				(rs, rowNum) -> new VehicleData(rs.getInt("v_id"), rs.getString("type"), rs.getString("model"),
						rs.getString("brand"), rs.getString("color"),
						rs.getString("vehicle_no"), null));

	}
	
	public List<VehicleData> retriveVehicleDataByPersonId(int personId) 
	{

		String sql = "SELECT * FROM vehicle where pers_id = ?";
		return jdbcTemplate.query(sql, new Object[] { personId },
				(rs, rowNum) -> new VehicleData(rs.getInt("v_id"), rs.getString("type"), rs.getString("model"),
						rs.getString("brand"), rs.getString("color"),
						rs.getString("vehicle_no"), null));

	}

	public long updateVehicleData(String type, String model, String brand, String color,
			String vehicleNumber, int vId) 
	{
	
		String sql = "UPDATE vehicle set type = ? , model =?, brand= ?, color =?, pers_id =?, vehicle_no =? where v_id = ? ";
		return jdbcTemplate.update(sql, type, model, brand, color, vehicleNumber, vId);
	}

	public long deleteVehicleData(int vId) 
	{

		String sql = "delete from vehicle  where v_id = ? ";
		return jdbcTemplate.update(sql, vId);

	}

	public long deleteAllVehicleData() 
	{
		String sql = "delete from vehicle  ";
		return jdbcTemplate.update(sql);

	}

	public List<VehicleData> getByVehicleNo(String vehicleNumber) 
	{
		String sql = "SELECT * FROM vehicle where vehicle_no = ? ";
		return jdbcTemplate.query(sql, new Object[] { vehicleNumber },
				(rs, rowNum) -> new VehicleData(rs.getInt("v_id"), rs.getString("type"), rs.getString("model"),
						rs.getString("brand"), rs.getString("color"),
						rs.getString("vehicle_no"), null));
	}

}
