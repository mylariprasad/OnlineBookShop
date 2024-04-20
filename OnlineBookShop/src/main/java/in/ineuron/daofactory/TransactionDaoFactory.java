package in.ineuron.daofactory;

import in.ineuron.dao.CustomerDao;
import in.ineuron.dao.CustomerDaoImpl;
import in.ineuron.dao.TransactionDao;
import in.ineuron.dao.TransactionDaoImpl;

public class TransactionDaoFactory {
	private TransactionDaoFactory() {
		
	}
	
	private static TransactionDao transactionDao = null;
	
	public static TransactionDao getDaoFactory() {
		if(transactionDao == null) {
			transactionDao = new TransactionDaoImpl();
		}
		return transactionDao;
	}
}
