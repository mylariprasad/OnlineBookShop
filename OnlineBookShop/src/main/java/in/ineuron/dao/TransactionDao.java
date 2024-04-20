package in.ineuron.dao;

import java.util.List;

import in.ineuron.dto.Transaction;

public interface TransactionDao {
	public String addTransaction(Transaction transaction);
	
	public List<Transaction> getTransactionsById(int customer_id);
}
