package budgetConsoleApp;

import java.util.Comparator;

public class ExpenseComparatorA implements Comparator<Expense>{
	// compare expense objects based on amount of transaction
	@Override
	public int compare(Expense o1, Expense o2) {
		if (o1.getAmount() == o2.getAmount()) {
			return 0;
		} else if (o1.getAmount() > o2.getAmount()) {
			return 1;
		} else {
			return -1;
		}
	}
}
