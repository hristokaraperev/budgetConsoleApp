package budgetConsoleApp;

import java.util.Scanner;

public class Expense extends Transaction{
	private String typeOfTransaction;
	private int date;
	private int month;
	private int year;
	private double amount;
	private String description;
	
	public Expense(Scanner sc, String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
		// sets year to be of format XXXX
		int maxDigitsOfYear = 4;
		// sets date and month to be of format XX
		int maxDigitsOfDateAndMonth = 2;
		// variable to check if its a leap year or not
		boolean isLeapYear = false;
		while (this.getYear() == 0) {
			try {
				System.out.println("Please enter year: ");
				this.year = Integer.parseInt(sc.nextLine());
				int lenght = String.valueOf(getYear()).length();
				// checks if year value is of correct format
				if (lenght != maxDigitsOfYear) {
					this.year = 0;
					System.out.println("Invalid input! Try again!");
					continue;
				}
				// checks if current year is a leap year or not
				int currentYear = getYear();
				if (currentYear % 4 == 0) {
					if (currentYear % 100 == 0) {
						if (currentYear % 400 == 0) {
							isLeapYear = true;
						}
					}
					else {
						isLeapYear = true;
					}
				}
			} catch (Exception e) {
				continue;
			}
		}
		while (this.getMonth() == 0) {
			try {
				System.out.println("Please enter month: ");
				this.month = Integer.parseInt(sc.nextLine());
				int lenght = String.valueOf(getMonth()).length();
				// checks if month value is of correct format
				if (lenght > maxDigitsOfDateAndMonth) {
					this.month = 0;
					System.out.println("Invalid input! Try again!");
					continue;
				}
				// checks if month value is valid
				if (getMonth() > 12) {
					this.month = 0;
					System.out.println("Invalid input! Try again!");
					continue;
				}
			} catch (Exception e) {
				continue;
			}
		}
		while (this.getDate() == 0) {
			try {
				System.out.println("Please enter day: ");
				this.date = Integer.parseInt(sc.nextLine());
				int lenght = String.valueOf(getDate()).length();
				// checks if month value is of correct format
				if (lenght > maxDigitsOfDateAndMonth) {
					this.date = 0;
					System.out.println("Invalid input! Try again!");
					continue;
				}
				int currentMonth = getMonth();
				int currentDate = getDate();
				// checks if month has to have 31 days
				if ((currentMonth == 1 || currentMonth == 3 || currentMonth == 5 
				  || currentMonth == 7 || currentMonth == 8 || currentMonth == 10
				  || currentMonth == 12) && currentDate > 31) {
					this.date = 0;
					System.out.println("Invalid input! Try again!");
					continue;
				}
				// checks if month has to have 30 days
				else if ((currentMonth == 4 || currentMonth == 6
						 || currentMonth == 9 || currentMonth == 11) 
						 && currentDate > 30) {
					this.date = 0;
					System.out.println("Invalid input! Try again!");
					continue;
				} 
				// checks if month has to have 29 days(leap year)
				else if (isLeapYear && currentMonth == 2) {
					if (currentDate > 29) {
						this.date = 0;
						System.out.println("Invalid input! Try again!");
						continue;
					}
				} 
				// checks if month has to have 28 days(not a leap year)
				else if (!isLeapYear && currentMonth == 2) {
					if (currentDate > 28) {
						this.date = 0;
						System.out.println("Invalid input! Try again!");
						continue;
					}
				}
			} catch (Exception e) {
				continue;
			}
		}
		while (this.getAmount() == 0) {
			try {
				System.out.println("Please enter amount: ");
				// gets amount and rounds and formats it 
				// to have 2 digits after decimal point
				this.amount = Math.round(Double.parseDouble(sc.nextLine()) * 100.0) / 100.0;
			} catch (Exception e) {
				continue;
			}
		}
		while (this.getDescription() == null) {
			try {
				System.out.println("Please describe the expense: ");
				this.description = sc.nextLine();
			} catch (Exception e) {
				continue;
			}
		}
	}

	public void showThisTransaction() {
		System.out.println("=====================\n"
						+  "Type: " + getTypeOfTransaction().toUpperCase()
						+  "Date: " + getDate() + "." + getMonth() + "." + getYear() + '\n'
						+  "Amount: " + "$" + getAmount() + '\n'
						+  "Description: "  + getDescription().toUpperCase() + '\n'
						+  "====================="
				);
	}
	
	public int getDate() {
		return this.date;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getTypeOfTransaction() {
		return this.typeOfTransaction;
	}
}
