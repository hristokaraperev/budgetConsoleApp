package budgetConsoleApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// TODO:
	// 3. system to store transactions by month and then display
	//    them to user if needed
	// 4. monthly income, monthly expenses
	// 5. overall account balance, with possibility to transfer
	//    remainder of available money to next month

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// makes new array list to store all transactions
		ArrayList<Transaction> listOfTransactions = new ArrayList<Transaction>();
		ArrayList<Income> listOfIncomes = new ArrayList<Income>();
		ArrayList<Expense> listOfExpenses = new ArrayList<Expense>();
		// creates an object of type balance
		Balance balance = new Balance();
		// creates new menu
		Menu menu = new Menu(sc, listOfTransactions, listOfIncomes, listOfExpenses, balance);
		menu.menu();
		sc.close();
	}
}
