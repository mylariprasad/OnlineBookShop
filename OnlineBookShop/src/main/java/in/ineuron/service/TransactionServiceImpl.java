package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.CustomerDao;
import in.ineuron.dao.TransactionDao;
import in.ineuron.daofactory.CustomerDaoFactory;
import in.ineuron.daofactory.TransactionDaoFactory;
import in.ineuron.dto.Transaction;

public class TransactionServiceImpl implements TransactionService{

	@Override
	public String addTransaction(Transaction transaction) {
		TransactionDao transactionDao = TransactionDaoFactory.getDaoFactory();
		return transactionDao.addTransaction(transaction);
	}

	@Override
	public List<Transaction> getTransactionsById(int customer_id) {
		TransactionDao transactionDao = TransactionDaoFactory.getDaoFactory();
		return transactionDao.getTransactionsById(customer_id);
	}

}
