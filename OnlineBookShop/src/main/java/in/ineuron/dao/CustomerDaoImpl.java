package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Customer;
import in.ineuron.util.JdbcUtil;

public class CustomerDaoImpl implements CustomerDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	@Override
	public String addCustomer(Customer customer) {
		String insertQuery = "insert into customers(name,email,password,address) values(?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(insertQuery);
			}
			
			if(pstmt != null) {
				pstmt.setString(1, customer.getCname());
				pstmt.setString(2, customer.getCemail());
				pstmt.setString(3, customer.getCpassword());
				pstmt.setString(4, customer.getCaddress());
				
				int rowAffected = pstmt.executeUpdate();
				if(rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
		
	}

	@Override
	public String verifyCustomer(String email, String password) {
		String selectQuery = "select password from customers where email=?";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(selectQuery);
			}
			
			if(pstmt!=null) {
				pstmt.setString(1, email);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs != null) {
					if(rs.next()) {
						return rs.getString(1);
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCustomerId(String email) {
		String selectQuery = "select id from customers where email=?";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(selectQuery);
			}
			
			if(pstmt!=null) {
				pstmt.setString(1, email);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs != null) {
					if(rs.next()) {
						int id = rs.getInt(1);
						return id;
					}
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public Customer searchCustomer(Integer cid) {
		Customer customer = null;
		String sqlSelectStatement = "select id, name, email, address from customers where id=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectStatement);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1,cid);
				
				resultSet = pstmt.executeQuery();
				if(resultSet != null) {
					if(resultSet.next()) {
						customer = new Customer();
						
						customer.setCid(resultSet.getInt(1));
						customer.setCname(resultSet.getString(2));
						customer.setCemail(resultSet.getString(3));
						customer.setCaddress(resultSet.getString(4));
						return customer;
					}
				}
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public String updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}


}
