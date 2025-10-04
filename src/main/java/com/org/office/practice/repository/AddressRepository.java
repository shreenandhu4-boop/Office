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

import com.org.office.practice.data.AddressData;

@Repository
public class AddressRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public long createAddressData(String doorNo, String street, String adderssLine1, String addressLine2,
			String district, String pincode, String state, String addressType) 
	{
		String sql = "INSERT INTO address ( door_no, street, address_line_1, address_line_2 , district , pincode, state, persons_id, address_type ) "
				+ " values (?, ?, ?, ? , ? , ?, ?, ?, ?) ";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() 
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
			{
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, doorNo);
				ps.setString(2, street);
				ps.setString(3, adderssLine1);
				ps.setString(4, addressLine2);
				ps.setString(5, district);
				ps.setString(6, pincode);
				ps.setString(7, state);
				ps.setString(8, addressType);
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}

	public List<AddressData> retriveAllAddressData() 
	{
		String sql = "SELECT * FROM address";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new AddressData(rs.getInt("ad_id"), rs.getString("door_no"), rs.getString("street"),
						rs.getString("address_line_1"), rs.getString("address_line_2"), rs.getString("district"),
						rs.getString("pincode"), rs.getString("state"),
						rs.getString("address_type"), null));
	}

	public List<AddressData> retriveAllAddressDataByPersonId(int personId) 
	{
		String sql = "SELECT * FROM address where persons_id= ?";

		return jdbcTemplate.query(sql, new Object[] { personId },
				(rs, rowNum) -> new AddressData(rs.getInt("ad_id"), rs.getString("door_no"), rs.getString("street"),
						rs.getString("address_line_1"), rs.getString("address_line_2"), rs.getString("district"),
						rs.getString("pincode"), rs.getString("state"),
						rs.getString("address_type"), null));
	}

	public AddressData retriveAddressData(int adId) 
	{

		String sql = "SELECT * FROM address where ad_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { adId },
				(rs, rowNum) -> new AddressData(rs.getInt("ad_id"), rs.getString("door_no"), rs.getString("street"),
						rs.getString("address_line_1"), rs.getString("address_line_2"), rs.getString("district"),
						rs.getString("pincode"), rs.getString("state"),
						rs.getString("address_type"), null));

	}

	public long updateAddressData(String doorNo, String street, String addressLine1, String addressLine2,
			String district, String pincode, String state, String addressType, int adId) 
	{
		String sql = "UPDATE address set door_no = ? ,street =?, address_line_1= ?, address_line_2 =?, "
				+ "district =?, pincode=?, state=?, persons_id=?, address_type=?  where ad_id = ? ";
		return jdbcTemplate.update(sql, doorNo, street, addressLine1, addressLine2, district, pincode, 
				state, addressType, adId);
	}

	public long deleteAddressData(int adId) 
	{

		String sql = "delete from address  where ad_id = ? ";
		return jdbcTemplate.update(sql, adId);

	}

	public long deleteAllAddressData() 
	{
		String sql = "delete from address  ";
		return jdbcTemplate.update(sql);

	}

	public List<AddressData> getAddressByPersonIdAndAddressType(int personId, String addressType) 
	{
		String sql = "SELECT * FROM address where persons_id= ? and address_type = ? ";

		return jdbcTemplate.query(sql, new Object[] { personId, addressType },
				(rs, rowNum) -> new AddressData(rs.getInt("ad_id"), rs.getString("door_no"), rs.getString("street"),
						rs.getString("address_line_1"), rs.getString("address_line_2"), rs.getString("district"),
						rs.getString("pincode"), rs.getString("state"),
						rs.getString("address_type"), null));
	}

}
