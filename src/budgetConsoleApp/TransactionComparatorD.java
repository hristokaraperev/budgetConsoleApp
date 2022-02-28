package budgetConsoleApp;

import java.util.Comparator;

public class TransactionComparatorD implements Comparator<Transaction>{
	// compares transaction objects based on year, month and date
	@Override
	public int compare(Transaction o1, Transaction o2) {
		if (o1.getYear() == o2.getYear()) {
			if (o1.getMonth() == o2.getMonth()) {
				if (o1.getDate() == o2.getDate()) {
					return 0;
				} else if (o1.getDate() > o2.getDate()) {
					return 1;
				} else {
					return -1;
				}
			} else if (o1.getMonth() > o2.getMonth()) {
				return 1;
			} else {
				return -1;
			}
		} else if (o1.getYear() > o2.getYear()) {
			return 1;
		} else {
			return -1;
		}
	}
}
