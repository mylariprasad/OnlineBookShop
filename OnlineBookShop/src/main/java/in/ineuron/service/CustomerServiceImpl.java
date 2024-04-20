package in.ineuron.service;

import in.ineuron.dao.CustomerDao;
import in.ineuron.daofactory.CustomerDaoFactory;
import in.ineuron.dto.Customer;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public String addCustomer(Customer customer) {
		CustomerDao customerDao = CustomerDaoFactory.getDaoFactory();
		return customerDao.addCustomer(customer);
	}

	@Override
	public String verifyCustomer(String email, String password) {
		CustomerDao customerDao = CustomerDaoFactory.getDaoFactory();
		String res = customerDao.verifyCustomer(email, password);
		return res;
	}

	@Override
	public int getCustometerId(String email) {
		CustomerDao customerDao = CustomerDaoFactory.getDaoFactory();
		int res = customerDao.getCustomerId(email);
		return res;
	}
	
	@Override
	public Customer searchCustomer(Integer cid) {
		CustomerDao customerDao = CustomerDaoFactory.getDaoFactory();
		return customerDao.searchCustomer(cid);
	}

	@Override
	public String updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
