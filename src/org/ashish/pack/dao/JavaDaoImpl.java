package org.ashish.pack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.ashish.pack.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
@Component
public class JavaDaoImpl {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate nPJT;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.nPJT = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM circle1";
		return jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		
	}
	
	public String getCircleName(int CircleId) {
		String sql = "SELECT NAME FROM CIRCLE1 WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {CircleId}, String.class);
		
	}
	
	public Circle getCircleForId(int CircleId) {
		String sql = "SELECT * FROM CIRCLE1 WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {CircleId}, new CircleMapper());
		
	}
	public List<Circle> allCircle(){
		String sql = "SELECT * FROM CIRCLE1";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE1 (ID, NAME) VALUES (:id, :name)";
		//jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
		SqlParameterSource sps = new MapSqlParameterSource("id", circle.getId())
										.addValue("name", circle.getName());
		nPJT.update(sql, sps);
	}
	final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("ID"));
			circle.setName(rs.getString("NAME"));
			return circle;
		}
	}
	public void createTable() {
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(100))";
		jdbcTemplate.execute(sql);
		
	}
	

/*	  public Circle getCircle(int CircleId) {
		
		Connection conn = null;
		Circle circle = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle1 where id = ?");
			ps.setInt(1, CircleId);
			
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				circle = new Circle(CircleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return circle;
				
	}*/
	
}
