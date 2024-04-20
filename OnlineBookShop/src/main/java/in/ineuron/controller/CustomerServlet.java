package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.Customer;
import in.ineuron.service.CustomerService;
import in.ineuron.servicefactory.CustomerServiceFactory;


@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService = CustomerServiceFactory.getServiceFactory();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("profile")) {
			 HttpSession session = request.getSession();
			 int user_id =  (int) session.getAttribute("user_id");
		     Customer customer = customerService.searchCustomer(user_id);
		     session.setAttribute("customer",customer);
		     response.sendRedirect("../transaction/getTransactionsHistory");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getRequestURI().endsWith("registration")) {
			
			String name = request.getParameter("cname");
			String email = request.getParameter("cemail");
			String address = request.getParameter("caddress");
			String password = request.getParameter("cpassword");
			
			Customer newCustomer = new Customer();
			newCustomer.setCname(name);
			newCustomer.setCemail(email);
			newCustomer.setCpassword(password);
			newCustomer.setCaddress(address);
			
			
			String msg = customerService.addCustomer(newCustomer);
			
			if(msg.equals("success")) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else{
				response.sendRedirect(request.getContextPath() + "/customer/login");
		}
		
		}
		
		if(request.getRequestURI().endsWith("login")) {
			String email = request.getParameter("cemail");
			String password = request.getParameter("cpassword");
			
			String msg = customerService.verifyCustomer(email, password);
			if(msg!=null) {
				if(msg.equals(password)){
					HttpSession session = request.getSession();
					int user_id = customerService.getCustometerId(email);
					session.setAttribute("user_id", user_id);
					response.sendRedirect(request.getContextPath() + "/Main.jsp");
				}else {
					response.sendRedirect(request.getContextPath() + "/login.jsp");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/customer/login");
			}
			}
		

		
	}

}
