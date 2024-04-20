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
import in.ineuron.dto.Transaction;
import in.ineuron.service.TransactionService;
import in.ineuron.servicefactory.TransactionServiceFactory;


@WebServlet("/transaction/*")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionService transactionService = TransactionServiceFactory.getServiceFactory();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("addTransaction")) {
			HttpSession session = request.getSession();
			
			int customer_id = (int)session.getAttribute("user_id");
			String book_name = (String) session.getAttribute("book_name");
			String transaction_type = "bought";
			
			Transaction newTransaction = new Transaction();
			newTransaction.setCustomer_id(customer_id);
			newTransaction.setBook_name(book_name);
			newTransaction.setTransaction_type(transaction_type);
			
			
			String msg = transactionService.addTransaction(newTransaction);
			
			if(msg.equals("success")) {
				response.sendRedirect(request.getContextPath() + "/ordered.jsp");
			} else{
				response.sendRedirect(request.getContextPath() + "/transactionFailed.jsp");
			}
		}
		
		if(request.getRequestURI().endsWith("addSellTransaction")) {
			HttpSession session = request.getSession();
			
			int customer_id = (int)session.getAttribute("user_id");
			String book_name = (String) session.getAttribute("sell_book_name");
			String transaction_type = "sold";
			
			Transaction newTransaction = new Transaction();
			newTransaction.setCustomer_id(customer_id);
			newTransaction.setBook_name(book_name);
			newTransaction.setTransaction_type(transaction_type);
			
			
			String msg = transactionService.addTransaction(newTransaction);
			
			if(msg.equals("success")) {
				response.sendRedirect(request.getContextPath() + "/uploaded.jsp");
			} else{
				response.sendRedirect(request.getContextPath() + "/transactionFailed.jsp");
			
			}
		}
		
		if(request.getRequestURI().endsWith("getTransactionsHistory")) {
			HttpSession session = request.getSession();
			 int user_id =  (int) session.getAttribute("user_id");
			List<Transaction> TransactionsList = transactionService.getTransactionsById(user_id);

	        request.setAttribute("TransactionsList", TransactionsList);
	        request.getRequestDispatcher("/profileData.jsp").forward(request, response);
		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
