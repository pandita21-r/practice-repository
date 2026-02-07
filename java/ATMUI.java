//ATM Console Application (Java)

// A simple console-based ATM simulation created as part of my Java programming practice.
  
// Concepts Applied
// Arrays for storing account data
// User input handling with Scanner
// Conditional statements and loops
// Methods and parameter passing
// Basic file handling (transaction report)

// Notes
// This project is written using procedural style
// Future improvement: refactor using Object-Oriented Programming (OOP)
// !! Future me, APPLY OOP IF YOU MANAGED TO LEARN IT. Also, avoid to many global variables.

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class ATMUI {
	public static int a;
	public static int[] accountNumbers;
	public static int[] pins;
	public static StringBuilder report = new StringBuilder();
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		double[] balances = inputAccounts(sc);
		int accountIndex = -1;
		while(accountIndex == -1){
			accountIndex = authenticate(sc);
			
			if(accountIndex == -1) {
				System.out.println("\nInvalid login. Pleas try again.\n");
			}
		}
	
		System.out.println("""
				\n\n--- ATM MENU ---
				[1] Balance Inquiry
				[2] Deposit
				[3] Withdraw
				[4] Transfer
				[5] Exit
				""");
		int choice;
		do {
		System.out.println("\n--- ATM MENU ---");
		choice = showMenuAndGetChoice(sc);
			if(choice == 1) {
			System.out.println("Your remaining balance is: " + balances[accountIndex]);
					report.append(String.format("Balance: %.2f\n", balances[accountIndex]));
			} else if(choice == 2) {
				double deposit = 0;
			System.out.print("Deposit amount: ");
					deposit = sc.nextDouble();
					String transactionMessageD = deposit(balances, accountIndex, deposit);	
					report.append(transactionMessageD).append("\n");
			}else if(choice == 3) {
				double withdraw = 0;
			System.out.print("Withdraw amount: ");
					withdraw = sc.nextDouble();
					
					String transactionMessageW = withdraw(balances, accountIndex, withdraw);
					report.append(transactionMessageW).append("\n");
			}else if(choice == 4) {
			System.out.print("Enter destination account number: ");
				int toAccNo = sc.nextInt();
				
			System.out.print("Enter transfer amount: ");
				double amount = sc.nextDouble();
				
					String transactionMessageT = transfer(balances, accountIndex, toAccNo, amount);
					report.append(transactionMessageT).append("\n");
				}
			}while(choice != 5);
			System.out.printf("\nLogin successful for Account %d", accountNumbers[accountIndex]);
			System.out.println();
			System.out.println("\n" + report);
			saveATMReport();
			sc.close();
	}
	public static double[] inputAccounts(Scanner sc) {
		System.out.print("How many accounts? ");
				a = sc.nextInt();
				accountNumbers = new int[a];
				pins = new int[a];
				double[] balances = new double[a];
				System.out.println();
		for(int i = 0; i < accountNumbers.length; i++) {
			System.out.printf("Account %d number: ", (i + 1));
				accountNumbers[i] = sc.nextInt();
			System.out.printf("Account %d PIN: ", (i +1));
				pins[i] = sc.nextInt();
			System.out.printf("Account %d starting balance: ", (i + 1));
				balances[i] = sc.nextDouble();
			System.out.println();	
			}
		return balances;	
	}
	public static int authenticate(Scanner sc) { 
			System.out.print("Enter account number: ");
				int accNo = sc.nextInt();
			System.out.print("Enter PIN: ");
				int pin = sc.nextInt();
			
		for(int i = 0; i < accountNumbers.length; i++) {
				if(accountNumbers[i] == accNo && pins[i] == pin) {
		return i;
			}
		}
		return -1;
	}
	public static int showMenuAndGetChoice(Scanner sc) {
			System.out.print("\nChoose: ");
			int choice = sc.nextInt();
		return choice;
	}
	public static String deposit(double[] balances, int accountIndex, double deposit) {
		if(deposit <= 0) {
			System.out.println("Invalid input. Please enter a value greater than 0.");
			return "Deposit failed: Invalid amount (" + deposit + ")";
		}
			balances[accountIndex] += deposit;
			return String.format("Deposit successful: %.2f | New Balance: %.2f", deposit, balances[accountIndex]);
	}
	public static String withdraw(double[] balances, int accountIndex, double withdraw) {
		if(withdraw <= 0) {
			return "Withdraw failed: Invalid amount (" + withdraw + ")";
		}else if(withdraw > balances[accountIndex]) {
			return String.format("Withdraw failed: Insufficient funds | Balance: %.2f", balances[accountIndex]);
		}else { 
			balances[accountIndex] -= withdraw;
			return String.format("Withdraw successful: %.2f | New Balance: %.2f", withdraw, balances[accountIndex]);
		}
	}
	public static String transfer(double[] balances, int fromIndex, int toAccountNumber, double amount) { 
		int toIndex = -1;
		for(int i = 0; i < accountNumbers.length; i++) {
			if(accountNumbers[i] == toAccountNumber) {
				toIndex = i;
				break;
			}
		}
		if(amount <= 0) {
			return "Transfer failed: Invalid amount (" + amount + ")";
		}else if(toIndex == -1) {
			return "Transfer failed: Destination account not found.";
		}else if(fromIndex == toIndex) {
			return "Transfer failed: Cannot transfer to the same account.";
		}else if(balances[fromIndex] < amount) {
			return "Transfer failed: Insufficient balance.";
		}else {
		balances[fromIndex] -= amount;
	    balances[toIndex] += amount;
	    return String.format("Transfer successful: %.2f to account %d | New Balance: %.2f",
                amount, toAccountNumber, balances[fromIndex]);
		}
	}
	public static void saveATMReport() {
		try(FileWriter writer = new FileWriter("atm_report.txt");){
			writer.write(report.toString());
			System.out.println("Saved report to atm_report.txt");
		}catch(IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}
}
