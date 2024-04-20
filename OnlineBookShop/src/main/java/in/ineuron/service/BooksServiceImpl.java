package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.BooksDao;
import in.ineuron.dao.CustomerDao;
import in.ineuron.daofactory.BooksDaoFactory;
import in.ineuron.daofactory.CustomerDaoFactory;
import in.ineuron.dto.Books;

public class BooksServiceImpl implements BooksService{

	@Override
	public String addBook(Books book) {
		BooksDao booksDao = BooksDaoFactory.getDaoFactory();
		return booksDao.addBook(book);
	}

	@Override
	public List<Books> getAllBooks() {
		BooksDao booksDao = BooksDaoFactory.getDaoFactory();
		return booksDao.getAllBooks();
	}

	@Override
	public String deleteBook(int book_id) {
		BooksDao booksDao = BooksDaoFactory.getDaoFactory();
		return booksDao.deleteBook(book_id);
	}

	@Override
	public List<Books> searchBooks(String bookName) {
		BooksDao booksDao = BooksDaoFactory.getDaoFactory();
		return booksDao.searchBooks(bookName);
	}

}
