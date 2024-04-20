package in.ineuron.dao;

import java.util.List;

import in.ineuron.dto.Books;
import in.ineuron.dto.Customer;

public interface BooksDao {
	public String addBook(Books book);
	
	public List<Books> getAllBooks();
	
	public String deleteBook(int book_id);

	public List<Books> searchBooks(String bookName);
}
