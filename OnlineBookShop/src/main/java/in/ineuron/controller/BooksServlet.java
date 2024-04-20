package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.Books;
import in.ineuron.service.BooksService;
import in.ineuron.servicefactory.BooksServiceFactory;


@WebServlet("/book/*")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BooksService booksService = BooksServiceFactory.getServiceFactory();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("fetch")) {
			List<Books> booksList = booksService.getAllBooks();

	        request.setAttribute("booksList", booksList);
	        HttpSession session = request.getSession();
	        int user_id =  (int) session.getAttribute("user_id");
	        request.getRequestDispatcher("/displayBooks.jsp").forward(request, response);
		}
		
		
		if(request.getRequestURI().endsWith("buy")) {
			HttpSession session = request.getSession();
	        request.getRequestDispatcher("/buyBook.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getRequestURI().endsWith("upload")) {
			String name = request.getParameter("book_name");
			String author = request.getParameter("author");
			Integer price = Integer.parseInt(request.getParameter("price"));
			String condition = request.getParameter("condition");
			
			HttpSession session = request.getSession();
			session.setAttribute("sell_book_name", name);
			
			Books newBook = new Books();
			newBook.setName(name);
			newBook.setAuthor(author);
			newBook.setPrice(price);
			newBook.setCondition(condition);
			
			String msg = booksService.addBook(newBook);
			if(msg == "success") {
				response.sendRedirect(request.getContextPath() + "/transaction/addSellTransaction");
			}else {
				response.sendRedirect(request.getContextPath() + "/uploadBookFailed.jsp");
			}
		}
		
		if(request.getRequestURI().endsWith("buyBook")) {
			HttpSession session = request.getSession();
			
			String book_name = request.getParameter("bookName");
			session.setAttribute("book_name", book_name);
			response.sendRedirect(request.getContextPath() + "/transaction/addTransaction");
		}
		
		if(request.getRequestURI().endsWith("search")) {
			String searchInput = request.getParameter("search");
			List<Books> searchBooksList = booksService.searchBooks(searchInput);
			
	        request.setAttribute("searchBooksList", searchBooksList);
	        HttpSession session = request.getSession();
	        int user_id =  (int) session.getAttribute("user_id");
	        request.getRequestDispatcher("/searchBooks.jsp").forward(request, response);
	       }
	}

}
