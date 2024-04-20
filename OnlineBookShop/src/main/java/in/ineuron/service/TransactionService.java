package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Books;
import in.ineuron.dto.Transaction;

public interface TransactionService {
	public String addTransaction(Transaction transaction);
	
	public List<Transaction> getTransactionsById(int customer_id);
}
