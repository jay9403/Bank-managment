package coreClass;

import java.util.Scanner;



import static Utils.BankUtils.*;

import CustomException.InvalidInputExceptions;


import java.util.*;

import java.time.LocalDate;
import java.time.Period;

import static CustomException.CustomerValidations.*;

public class Bank_Tester {

	public static void main(String[] args) throws InvalidInputExceptions {

		try (Scanner sc = new Scanner(System.in)) {
			List<BankAccount> bankAccount = populateList();
			boolean exit = true;
			BankAccount c = null;

			while (exit) {
				try {
					System.out.println("1. sign up  \r\n" + "2. Sign in\r\n" + "3. change password\r\n"
							+ "4. Display all students data using Iterator.\r\n" + "5. sorting as per email\r\n"
							+ "6. sorting(as per accopendate using custom ordering)\r\n" + "7. unsubscribe\r\n"
							+ "8. Withdraw Amount\n9.Deposit Amount\n10.Transfer funds\n" 
							+"11. Customer names of all SAVING a/c holders having last transaction before 3 months."
							+"\n0. exit\r\n"
							+ "Enter Choice :- ");
					switch (sc.nextInt()) {

					case 1:
						System.out.println(
								"Enter  Account Number,email,password,Name,Account Type,Balance,Account Opening Date");
						BankAccount c1 = validateAllInput(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), LocalDate.parse(sc.next()), bankAccount);
						bankAccount.add(c1);
						System.out.println("Account Created Succcessfully!!!"
								+ "\n-------------------------------------------------------------------------------------");
						break;

					case 2:
						System.out.println("Enter email and password :- ");
						c = authenticate(sc.next(), sc.next(), bankAccount);
						System.out.println("Authentication Successful!!!\n" + c);
						break;

					case 3:
						System.out.println("Enter email and password :- ");
						String email = sc.next();
						String password = sc.next();
						authenticate(email, password, bankAccount);
						System.out.println("Authentication Successful!!!\nEnter new Password :- ");
						String newPassword = sc.next();
						bankAccount.stream().filter(p -> p.getEmail().equals(email))
								.peek(p -> p.setPassword(newPassword));
						System.out.println("Password changed successfully!!!"
								+ "\n----------------------------------------------------------------------------------------");
						break;

					case 4:
						Iterator<BankAccount> itr = bankAccount.iterator();
						while (itr.hasNext()) {
							System.out.println(itr.next());
						}

						break;

					case 5:
						bankAccount.stream().sorted().forEach(System.out::println);// Declarative
						// Collections.sort(customer);// imperative
						System.out.println("Sorted as per Email!!!"
								+ "\n----------------------------------------------------------------------------------------");
						break;

					case 6:

						bankAccount.stream()
								.sorted((p1, p2) -> p1.getAccOpeningDate().compareTo(p2.getAccOpeningDate()))
								.forEach(p -> System.out.println(p));
						System.out.println("Sorted as per AccountOpening Date!!!"
								+ "\n-------------------------------------------------------------------------------------------------");
						break;

					case 7:
						Iterator<BankAccount> itr1 = bankAccount.iterator();
						System.out.println("Enter email and password :- ");
						String email1 = sc.next();
						String password1 = sc.next();
						authenticate(email1, password1, bankAccount);
						for (BankAccount i : bankAccount) {
							if (i.getEmail().equals(email1)) {
								System.out.println("Customer " + i.getName() + " having account number " + i.getAccNo()
										+ " has been unsubscribed. "
										+ "\n---------------------------------------------------------------------------------------------------S");
							}
						}

						while (itr1.hasNext()) {
							if (itr1.next().getEmail().equals(email1)) {
								itr1.remove();
							}
						}

						break;

					case 8:
						System.out.print("Enter the account number and amount you want to withdraw:-");
						withdrawAmount( sc.next(),sc.nextDouble(), bankAccount);
						break;

					case 9:
						System.out.print("Enter the account number and amount you want to deposit:-");
						depositAmount( sc.next(),sc.nextDouble(), bankAccount);
						break;

					case 10:
						System.out.println("Enter source and destination account number and amount you want to transfer ");
						transferFunds(sc.next(), sc.next(), sc.nextDouble(), bankAccount);
						
						break;
					
					case 11 :
						System.out.println("Customer names of all SAVING a/c holders "
								+ "having last_transaction before 3 months.");
						
						for(BankAccount b:bankAccount) {
							long duration = Period.between(b.getLastTransactionDate(), LocalDate.now()).toTotalMonths();
							if(duration >3 && b.getAccType().name().equals("SAVING"))
								System.out.println(b);
						}
						break;

					case 0:
						System.out.println("Exiting...");
						exit = false;
						break;

					default:
						System.out.println("Enter valid choice!!!");

					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
	}

}
