package com.syn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.Connection;
import com.syn.model.User;
import com.syn.utils.SynExceptionHAndler;

public class UserDaoImpl implements IUserDao {
	private static final Logger log = Logger.getLogger(UserDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getData(User user) throws SynExceptionHAndler {
		// TODO Auto-generated method stub

		String query = "select * from user where username=? and password=?";

		Connection conn = null;
		User user1 = null;
		try {

			user1 = jdbcTemplate.queryForObject(query, new Object[] { user.getUsername(), user.getPassword() },
					new RowMapper<User>() {

						@Override
						public User mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							User user = new User();
							user.setUsername(rs.getString("username"));
							user.setPassword(rs.getString("password"));
							return user;
						}

					});

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new SynExceptionHAndler("invalid login");
		}

		if (user1 != null) {
			return user1;
		} else {

			return null;
		}
	}
}