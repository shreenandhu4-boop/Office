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

import com.org.office.practice.data.ContactData;
import com.org.office.practice.data.VehicleData;
import com.org.office.practice.dto.ContactInformation;
import com.org.office.practice.dto.PersonContactResultSetDto;

@Repository
public class ContactRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public long createContactData(String contactType, String contactDetail, String isActive, int pId) 
	{
		String sql = "INSERT INTO contacts ( contact_type, contact_detail, is_active, p_id ) values (?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() 
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException 
			{
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, contactType);
				ps.setString(2, contactDetail);
				ps.setString(3, isActive);
				ps.setInt(4, pId);

				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
	}

	public long updateContactData(String contactType, String contactDetail, String isActive, int pId , int cId) 
	{
		
		String sql = "UPDATE contacts set contact_type = ?, contact_detail =?, is_active= ?, p_id=?  where c_id = ? ";
		return jdbcTemplate.update(sql, contactType, contactDetail, isActive, pId, cId);
	}

	public List<ContactData> retriveAllContactData() 
	{
		String sql = "SELECT * FROM contacts";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new ContactData(rs.getInt("c_id"), rs.getString("contact_type"),
				rs.getString("contact_detail"), rs.getString("is_active"), null));
	}
	
	public List<ContactData> retriveAllContactDataByPersonId(int personId) 
	{
		String sql = "SELECT * FROM contacts where p_id = ?";

		return jdbcTemplate.query(sql,new Object[] { personId }, (rs, rowNum) -> new ContactData(rs.getInt("c_id"), rs.getString("contact_type"),
				rs.getString("contact_detail"), rs.getString("is_active"), null ));
	}
	
	public List<ContactData> retriveAllContactDataByPersonId(int personId, String contactType, String isActive) 
	{
		String sql = "SELECT * FROM contacts where p_id = ? and contact_type = ? and is_active = ? ";

		return jdbcTemplate.query(sql,new Object[] { personId, contactType, isActive }, (rs, rowNum) -> new ContactData(rs.getInt("c_id"), 
				rs.getString("contact_type"), rs.getString("contact_detail"), rs.getString("is_active"), null));
	}

	public ContactData retriveContactData(int cId) 
	{

		String sql = "SELECT * FROM contacts where c_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { cId },
				(rs, rowNum) -> new ContactData(rs.getInt("c_id"), rs.getString("contact_type"),
						rs.getString("contact_detail"), rs.getString("is_active"),null));

	}

	public long deleteContactData(int cId) 
	{

		String sql = "delete from contacts  where c_id = ? ";
		return jdbcTemplate.update(sql, cId);

	}

	public long deleteAllContactData() 
	{
		String sql = "delete from contacts  ";
		return jdbcTemplate.update(sql);

	}
	
	public List<PersonContactResultSetDto> getContactInfoByPersonId(int personId) 
	{
		String sql ="Select p.name, c.contact_detail as mobile_no, a.door_no, a.street, a.address_line_1, a.address_line_2, a.district, a.pincode, a.state " + 
					" from person p inner join contacts c on p.person_id = c.p_id " + 
					" inner join address a on p.person_id = a.persons_id " +
					" where c.p_id=? and c.is_active= 'yes' and c.contact_type= 'mobile' " +
					" and a.address_type = 'primary address' ";
		
		return jdbcTemplate.query(sql,new Object[] { personId }, (rs, rowNum) ->
		new PersonContactResultSetDto(rs.getString("name"),rs.getString("mobile_no"),rs.getString("door_no"),
				rs.getString("street"),rs.getString("address_line_1"),rs.getString("address_line_2"),
				rs.getString("district"),rs.getString("pincode"),rs.getString("state")));
	
					
	}
	public List<ContactData> getContactByContactValue( String contactValue)
	{
		String sql = "select * from contacts where  contact_detail= ? ";
		return jdbcTemplate.query(sql, new Object[] {  contactValue },
				(rs, rowNum) -> new ContactData(rs.getInt("c_id"), rs.getString("contact_type"),
						rs.getString("contact_detail"), rs.getString("is_active"),null));
	}
}
