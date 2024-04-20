package in.ineuron.daofactory;

import in.ineuron.dao.BooksDao;
import in.ineuron.dao.BooksDaoImpl;

public class BooksDaoFactory {
private BooksDaoFactory() {
		
	}
	
	private static BooksDao booksDao = null;
	
	public static BooksDao getDaoFactory() {
		if(booksDao == null) {
			booksDao = new BooksDaoImpl();
		}
		return booksDao;
	}
}
