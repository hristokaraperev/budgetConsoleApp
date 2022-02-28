package budgetConsoleApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
	private Scanner sc;
	private ArrayList<Transaction> listOfTransactions;
	private ArrayList<Income> listOfIncomes;
	private ArrayList<Expense> listOfExpenses;
	private Balance balance;
	private int menuAction;

	public Menu(Scanner sc, ArrayList<Transaction> listOfTransactions, ArrayList<Income> listOfIncomes,
			ArrayList<Expense> listOfExpenses, Balance balance) {
		this.sc = sc;
		this.listOfTransactions = listOfTransactions;
		this.listOfIncomes = listOfIncomes;
		this.listOfExpenses = listOfExpenses;
		this.balance = balance;
	}
	// function that takes care of user interactions
	public void menu() {
		this.setMenuAction(0);
		while(this.getMenuAction() != 1 || this.getMenuAction() != 2 || this.getMenuAction() != 3 || this.getMenuAction() != 4) {
			System.out.println("Hello! \n"
							+  "Would you like to: \n"
							+  "1. Add a new transaction \n"
							+  "2. Sort transactions \n"
							+  "3. Show transactions \n"
							+  "4. Show balance");
			this.setMenuAction(Integer.parseInt(sc.nextLine()));
			switch (this.getMenuAction()) {
			case 1:
				this.addTransaction();
				break;
			case 2:
				this.sortTransactionsMenu();
				break;
			case 3:
				this.showTransactionsMenu();
				break;
			case 4:
				this.balance.showBalance();
				break;
			default:
				continue;
			}
		}
	}
	// menu to show all transactions
	public void showTransactionsMenu() {
		this.setMenuAction(0);
		System.out.println("Would you like to show: \n"
				 + "1. All transactions\n"
				 + "2. Income transactions \n"
				 + "3. Expense transactions");
		this.setMenuAction(Integer.parseInt(sc.nextLine()));
		switch (this.getMenuAction()) {
		case 1:
			this.showAllTransactions();
			break;
		case 2:
			this.showAllIncomes();
			break;
		case 3:
			this.showAllExpenses();
			break;
		}
	}
	// menu to sort transactions either by date or by amount
	public void sortTransactionsMenu() {
		this.setMenuAction(0);
		System.out.println("Would you like to sort: \n"
				 + "1. All transactions by date\n"
				 + "2. All transactions by amount \n"
				 + "3. Income transactions by date \n"
				 + "4. Income transactions by amount \n"
				 + "5. Expense transactions by date \n"
				 + "6. Expense transactions by amount");
		this.setMenuAction(Integer.parseInt(sc.nextLine()));
		switch (this.getMenuAction()) {
		case 1:
			this.sortAllTransactionsByDate();
			break;
		case 2:
			this.sortAllTransactionsByAmount();
			break;
		case 3:
			this.sortAllIncomesByDate();
			break;
		case 4:
			this.sortAllIncomesByAmount();
			break;
		case 5:
			this.sortAllExpesesByDate();
			break;
		case 6:
			this.sortAllExpensesByAmount();
			break;
		}
	}
	// sorts all transactions by date
	public void sortAllTransactionsByDate() {
		Collections.sort(this.listOfTransactions, new TransactionComparatorD());
	}
	// sorts all incomes by date
	public void sortAllIncomesByDate() {
		Collections.sort(this.listOfIncomes, new IncomeComparatorD());
	}
	// sorts all expenses by date
	public void sortAllExpesesByDate() {
		Collections.sort(this.listOfExpenses, new ExpenseComparatorD());
	}
	// sorts all transactions by amount
	public void sortAllTransactionsByAmount() {
		Collections.sort(this.listOfTransactions, new TransactionComparatorA());
	}
	// sorts all incomes by amount
	public void sortAllIncomesByAmount() {
		Collections.sort(this.listOfIncomes, new IncomeComparatorA());
	}
	// sorts all expenses by amount
	public void sortAllExpensesByAmount() {
		Collections.sort(this.listOfExpenses, new ExpenseComparatorA());
	}
	// lists all transactions
	public void showAllTransactions() {
		for (int i = 0; i < this.listOfTransactions.size(); i++) {
			this.listOfTransactions.get(i).showThisTransaction();
		}
	}
	// list all income transactions
	public void showAllIncomes() {
		for (int i = 0; i < this.listOfIncomes.size(); i++) {
			this.listOfIncomes.get(i).showThisTransaction();
		}
	}
	// list all expense transactions
	public void showAllExpenses() {
		for (int i = 0; i < this.listOfExpenses.size(); i++) {
			this.listOfExpenses.get(i).showThisTransaction();
		}
	}
	// adds an income or an expense
	public void addTransaction() {
		this.setMenuAction(0);
		while(this.menuAction != 1 || this.menuAction != 2) {
			System.out.println("Would you like to enter: \n"
					 + "1. Income \n"
					 + "2. Expense");
			try {
				this.setMenuAction(Integer.parseInt(sc.nextLine()));
			} catch (Exception e) {
				System.out.println("Invalid input! Try again!");
				System.out.println();
				continue;			}
			try {
				if (this.menuAction == 1) {
					// creates new income object
					Income newIncome = new Income(sc, "income");
					// adds the new income to a list of incomes 
					listOfIncomes.add(newIncome);
					// adds the new income to a list of all transactions
					listOfTransactions.add((Transaction) newIncome);
					// adds the new income to the balance object
					balance.setCurrentBalance(newIncome);
				} else if (this.menuAction == 2) {
					// creates new expense object
					Expense newExpense = new Expense(sc, "expense");
					// adds the new expense to a list of expenses
					listOfExpenses.add(newExpense);
					// adds the new expense to a list of all transactions
					listOfTransactions.add((Transaction) newExpense);
					// adds the new expense to the balance object
					balance.setCurrentBalance(newExpense);
				} else {
					continue;
				}
				System.out.println();
				boolean newTransaction = true;
				// checks if user wants to add more transactions
				while(newTransaction) {
					System.out.print("Another transaction?(y/n): ");
					String anotherTransaction = sc.nextLine();
					if (anotherTransaction.toUpperCase().charAt(0) == 'Y' && anotherTransaction.length() == 1) {
						menuAction = 0;
						break;
					} else if (anotherTransaction.toUpperCase().charAt(0) == 'N' && anotherTransaction.length() == 1) {
						newTransaction = false;
						break;
					}
				}
				if (newTransaction) {
					continue;
				} else {
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Try again!");
				System.out.println();
				continue;
			}
		}
	}
	public ArrayList<Transaction> getListOfTransactions() {
		return listOfTransactions;
	}

	public ArrayList<Income> getListOfIncomes() {
		return listOfIncomes;
	}

	public ArrayList<Expense> getListOfExpenses() {
		return listOfExpenses;
	}

	public Balance getBalance() {
		return balance;
	}
	
	public int getMenuAction() {
		return menuAction;
	}

	public void setMenuAction(int menuAction) {
		this.menuAction = menuAction;
	}
}
