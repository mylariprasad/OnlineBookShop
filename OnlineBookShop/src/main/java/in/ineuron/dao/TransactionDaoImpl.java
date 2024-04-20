package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Books;
import in.ineuron.dto.Transaction;
import in.ineuron.util.JdbcUtil;

public class TransactionDaoImpl implements TransactionDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public String addTransaction(Transaction transaction) {
		String insertQuery = "insert into transactions(customer_id,book_name, transaction_type) values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(insertQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, transaction.getCustomer_id());
				pstmt.setString(2, transaction.getBook_name());
				pstmt.setString(3, transaction.getTransaction_type());
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
	public List<Transaction> getTransactionsById(int customer_id) {
		List<Transaction> TransactionsList = new ArrayList<>();
        String query = "SELECT * FROM transactions where customer_id = ?";
		try {
            connection = JdbcUtil.getJdbcConnection();
            if(connection != null) {
            	pstmt = connection.prepareStatement(query);
            }
			
			if(pstmt != null) {
				pstmt.setInt(1,customer_id);
				rs = pstmt.executeQuery();
			}
            
            if(rs != null) {
	            while (rs.next()) {
	                Transaction transaction = new Transaction();
	                transaction.setTransaction_id(rs.getInt("transaction_id"));
	                transaction.setBook_name(rs.getString("book_name"));
	                transaction.setTransaction_type(rs.getString("transaction_type"));
	                TransactionsList.add(transaction);
	            }
	        }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
		return TransactionsList;
	}

}
