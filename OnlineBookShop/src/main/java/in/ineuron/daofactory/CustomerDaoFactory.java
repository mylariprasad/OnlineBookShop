package in.ineuron.daofactory;

import in.ineuron.dao.CustomerDao;
import in.ineuron.dao.CustomerDaoImpl;

public class CustomerDaoFactory {
	
	private CustomerDaoFactory() {
		
	}
	
	private static CustomerDao customerDao = null;
	
	public static CustomerDao getDaoFactory() {
		if(customerDao == null) {
			customerDao = new CustomerDaoImpl();
		}
		return customerDao;
	}
}
