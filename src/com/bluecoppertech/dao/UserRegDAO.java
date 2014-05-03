package com.bluecoppertech.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bluecopper.jsf.bean.UserDetails;



public class UserRegDAO {
	
	@Resource
	DataSource defaultDS;
	
	
	
	public void register1(String fname, String lname, String email) throws Exception
	{
	QueryRunner run = new QueryRunner(defaultDS);
	
	String sql = "INSERT INTO user_details (firstname, lastname, email) VALUES (?,?,?)";	
	int count=0;	
	count +=run.update(sql, fname,lname,email);
		
		
	
	}
	
	
	
	public  List<UserDetails> getUserList() throws DataAccessException
	{
	String sqldetails = "SELECT firstname as fname, lastname as lname, email FROM user_details";
	
	List<UserDetails> result = null;
	QueryRunner run = new QueryRunner(defaultDS);
	
	try {
		ResultSetHandler<List<UserDetails>> h = new BeanListHandler<UserDetails>(
				UserDetails.class);
		result = run.query(sqldetails, h);
		System.out.println("results returned="+result.size());

	} catch (SQLException e) {
		
		throw new DataAccessException("Operation failed. Please check Log.");
	}
	
	return result;
	
	}

}
