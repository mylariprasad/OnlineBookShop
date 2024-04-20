package in.ineuron.servicefactory;

import in.ineuron.service.TransactionService;
import in.ineuron.service.TransactionServiceImpl;

public class TransactionServiceFactory {
	private  TransactionServiceFactory() {
		
	}
	
	private static TransactionService transactionService = null;
	
	public static TransactionService getServiceFactory() {
		if(transactionService == null) {
			transactionService = new TransactionServiceImpl();
		}
		return transactionService;
	}
}
