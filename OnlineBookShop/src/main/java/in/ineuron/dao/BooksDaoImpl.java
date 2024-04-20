package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Books;
import in.ineuron.util.JdbcUtil;

public class BooksDaoImpl implements BooksDao {
	
	Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
	
	@Override
	public String addBook(Books book) {
		String insertQuery = "insert into books(name,author,price,`condition`) values(?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(insertQuery);
			}
			
			if(pstmt != null) {
				pstmt.setString(1, book.getName());
				pstmt.setString(2, book.getAuthor());
				pstmt.setInt(3, book.getPrice());
				pstmt.setString(4, book.getCondition());
				
				int rowAffected = pstmt.executeUpdate();
				if(rowAffected == 1) {
					return "success";
				}
				
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
        	try {
				JdbcUtil.cleanUp(connection, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return "failed";
		
	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> booksList = new ArrayList<>();
        String query = "SELECT * FROM books";
		try {
            connection = JdbcUtil.getJdbcConnection();
            if(connection != null) {
            	pstmt = connection.prepareStatement(query);
			}
			
			if(pstmt != null) {
				rs = pstmt.executeQuery();
			}
            
            if(rs != null) {
	            while (rs.next()) {
	                Books book = new Books();
	                book.setId(rs.getInt("id"));
	                book.setName(rs.getString("name"));
	                book.setAuthor(rs.getString("author"));
	                book.setPrice(rs.getInt("price"));
	                book.setCondition(rs.getString("condition"));
	                booksList.add(book);
	            }
	        }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }finally {
        	try {
				JdbcUtil.cleanUp(connection, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return booksList;
	}

	@Override
	public String deleteBook(int book_id) {
		String insertQuery = "delete from books where id=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(insertQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, book_id);
				
				
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1) {
					return "success";
				}				
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
        	try {
				JdbcUtil.cleanUp(connection, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return "failed";
	}
	
	@Override
	public List<Books> searchBooks(String bookName) {
		List<Books> booksList = new ArrayList<>();
	    String query = "SELECT * FROM books WHERE name = ?";
	    try {
	        connection = JdbcUtil.getJdbcConnection();
	        if (connection != null) {
	            pstmt = connection.prepareStatement(query);
	            pstmt.setString(1, bookName);

	            rs = pstmt.executeQuery();
	            if(rs != null) {
		            while (rs.next()) {
		                Books book = new Books();
		                book.setId(rs.getInt("id"));
		                book.setName(rs.getString("name"));
		                book.setAuthor(rs.getString("author"));
		                book.setPrice(rs.getInt("price"));
		                book.setCondition(rs.getString("condition"));
		                booksList.add(book);
		            }
		        }
	        }
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    } 
	    finally {
        	try {
				JdbcUtil.cleanUp(connection, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	    return booksList;
	}

	
}
