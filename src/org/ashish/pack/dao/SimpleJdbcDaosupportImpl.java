package org.ashish.pack.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SimpleJdbcDaosupportImpl extends JdbcDaoSupport {
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM circle1";
		return this.getJdbcTemplate().queryForObject(sql, new Object[] {}, Integer.class);
		
	}
}
