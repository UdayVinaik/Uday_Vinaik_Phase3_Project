package com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.model.PurchaseReport;

@Repository
public class PurchaseReportDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<PurchaseReport> getPurchaseReportList() {
		return jdbcTemplate.query("select * from purchasereport", new RowMapper<PurchaseReport> () {

			@Override
			public PurchaseReport mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchaseReport report = new PurchaseReport();
				report.setPurchaseId(rs.getInt(1));
				report.setUsername(rs.getString(2));
				report.setProducts(rs.getString(3));
				report.setDate_created(rs.getTimestamp(4));
				return report;
			}
		});
	}
	
	public List<PurchaseReport> getReportByOrder(String status) {
		String sqlQuery = "";
		if (status.equals("ascending")) {
			sqlQuery = "select * from purchasereport order by date_created asc";
		}
		else if (status.equals("descending")) {
			sqlQuery = "select * from purchasereport order by date_created desc";
		}
		return jdbcTemplate.query(sqlQuery, new RowMapper<PurchaseReport> () {

			@Override
			public PurchaseReport mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchaseReport report = new PurchaseReport();
				report.setPurchaseId(rs.getInt(1));
				report.setUsername(rs.getString(2));
				report.setProducts(rs.getString(3));
				report.setDate_created(rs.getTimestamp(4));
				return report;
			}
		});
	}
}
