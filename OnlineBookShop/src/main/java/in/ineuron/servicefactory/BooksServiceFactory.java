package in.ineuron.servicefactory;

import in.ineuron.service.BooksService;
import in.ineuron.service.BooksServiceImpl;

public class BooksServiceFactory {
	private BooksServiceFactory() {
		
	}
	
	private static BooksService booksService = null;
	
	public static BooksService getServiceFactory() {
		if(booksService == null) {
			booksService = new BooksServiceImpl();
		}
		return booksService;
	}
}
