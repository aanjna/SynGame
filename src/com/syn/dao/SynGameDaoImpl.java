package com.syn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.syn.model.SynGame;
import com.syn.utils.SynExceptionHAndler;

public class SynGameDaoImpl implements ISynGameDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public SynGameDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SynGame> getSynGame() throws SynExceptionHAndler {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM mis_data";
		ResultSet rs = null;

		List<SynGame> synGame = new ArrayList<SynGame>();
		synGame = jdbcTemplate.query(query, new RowMapper<SynGame>() {
			@Override
			public SynGame mapRow(ResultSet rs, int rowNum) throws SQLException {
				SynGame sg = new SynGame();
				sg.setTitle(rs.getString("title"));
				sg.setPlatform(rs.getString("platform"));
				sg.setGenre(rs.getString("genre"));
				sg.setScore(rs.getString("score"));
				sg.setEditors_choice(rs.getString("editors_choice"));
				return sg;
			}
		});
		return synGame;
	}
}
