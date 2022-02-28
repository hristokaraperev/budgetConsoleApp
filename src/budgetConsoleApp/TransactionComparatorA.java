package budgetConsoleApp;

import java.util.Comparator;

public class TransactionComparatorA implements Comparator<Transaction>{
	// compare expense objects based on amount of transaction
	@Override
	public int compare(Transaction o1, Transaction o2) {
		if (o1.getAmount() == o2.getAmount()) {
			return 0;
		} else if (o1.getAmount() > o2.getAmount()) {
			return 1;
		} else {
			return -1;
		}
	}
}
