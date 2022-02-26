package budgetConsoleApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// TODO:
	// 1. system to separately store income and expense objects
	//    and display them to user if needed
	// 2. system to sort transactions by date, by amount
	// 3. system to store transactions by month and then display
	//    them to user if needed
	// 4. monthly income, monthly expenses
	// 5. overall account balance, with possibility to transfer
	//    remained of available money to next month

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// makes new array list to store all transactions
		ArrayList<Transaction> listOfTransactions = new ArrayList<Transaction>();
		int menuAction = 0;
		while(menuAction != 1 || menuAction != 2) {
			System.out.println("Would you like to enter: \n"
					 + "1. Income \n"
					 + "2. Expense");
			try {
				menuAction = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid input! Try again!");
				System.out.println();
				continue;			}
			try {
				if (menuAction == 1) {
					// creates new income object
					Income newIncome = new Income(sc, "income");
					listOfTransactions.add((Income) newIncome);
				} else if (menuAction == 2) {
					// creates new expense object
					Expense newExpense = new Expense(sc, "income");
					listOfTransactions.add((Expense) newExpense);
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
		sc.close();
		// lists all transactions
		for (int i = 0; i < listOfTransactions.size(); i++) {
			listOfTransactions.get(i).showThisTransaction();
		}
	}

}
