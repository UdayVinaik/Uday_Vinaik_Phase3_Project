package com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Product> getProducts() {
		return jdbcTemplate.query("select * from product1", new RowMapper<Product> () {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				product.setCategory(rs.getString(4));
				product.setQuantity(rs.getInt(5));
				return product;
			}
		});
	}
	
	public List<Product> filterByCategory(String category1) {
		
		String sqlQuery = "select * from product1 where category = '" + category1 + "'";
		return jdbcTemplate.query( sqlQuery, new RowMapper<Product> () {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product1 = new Product();
				product1.setProductId(rs.getInt(1));
				product1.setProductName(rs.getString(2));
				product1.setPrice(rs.getFloat(3));
				product1.setCategory(rs.getString(4));
				product1.setQuantity(rs.getInt(5));
				return product1;
			}
		});
	}

}
