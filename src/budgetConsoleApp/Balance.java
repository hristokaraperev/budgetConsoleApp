package budgetConsoleApp;
// balance object to keep track of available funds in account
public class Balance {
	private double currentBalance;
	
	public Balance() {
		this.currentBalance = 0;
	}
	// shows current balance
	public void showBalance() {
		System.out.println("=====================\n"
						+  "Current balance: $" + getCurrentBalance() + '\n'
						+  "=====================");
	}

	public double getCurrentBalance() {
		return Math.round(currentBalance * 100.0 / 100.0);
	}
	// adds or subtracts amount of transaction to balance
	// based on whether transaction is income or expense
	public void setCurrentBalance(Transaction transaction) {
		if (transaction.getTypeOfTransaction() == "income") {
			this.currentBalance = currentBalance + transaction.getAmount();
		} else if(transaction.getTypeOfTransaction() == "expense") {
			this.currentBalance = currentBalance - transaction.getAmount();
		}
	}
}
