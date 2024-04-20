package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Books;

public interface BooksService {
	public String addBook(Books book);
	
	public String deleteBook(int book_id);
	
	public List<Books> getAllBooks();
	
	public List<Books> searchBooks(String bookName);
}
