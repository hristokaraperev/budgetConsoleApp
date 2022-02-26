package budgetConsoleApp;

public abstract class Transaction {
	String typeOfTransaction;
	int date;
	int month;
	int year;
	double amount;
	String description;
	
	public abstract void showThisTransaction();
}
