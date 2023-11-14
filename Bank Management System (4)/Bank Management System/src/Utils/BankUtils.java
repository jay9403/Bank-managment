package Utils;

import static CustomException.CustomerValidations.isExist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import AccountTyp.AccountType;
import CustomException.InvalidInputExceptions;
import coreClass.BankAccount;

public class BankUtils {

	public static List<BankAccount> populateList() {

		List<BankAccount> custList = new ArrayList<>();

		custList.add(new BankAccount("sbi001", "Harsh", "harsh123@gmail.com", "harsh123", AccountType.valueOf("SAVING"),
				5000, LocalDate.parse("2020-12-12")));

		custList.add(new BankAccount("sbi002", "Akash", "akash123@gmail.com", "akash123", AccountType.valueOf("FIXED"),
				3000, LocalDate.parse("2023-12-23")));

		custList.add(new BankAccount("sbi003", "Mayank", "mayank123@gmail.com", "mayank123",
				AccountType.valueOf("CURRENT"), 4000, LocalDate.parse("2022-12-23")));

		custList.add(new BankAccount("sbi004", "Miya", "miya123@gmail.com", "miya123", AccountType.valueOf("FIXED"),
				3000, LocalDate.parse("2023-10-03")));

		custList.add(new BankAccount("sbi005", "Priya", "priya123@gmail.com", "priya123",
				AccountType.valueOf("CURRENT"), 3000, LocalDate.parse("2023-10-13")));

		custList.add(new BankAccount("sbi006", "Renu", "renu123@gmail.com", "renu123", AccountType.valueOf("SAVING"),
				3000, LocalDate.parse("2019-10-23")));

		System.out.println("List Populated!!!");

		return custList;

	}

	public static void withdrawAmount( String acNo,double amnt, List<BankAccount> list) throws InvalidInputExceptions {
		isExist(acNo, list);

		BankAccount b = new BankAccount(acNo);
		b = list.get(list.indexOf(new BankAccount(acNo)));
		if (!(b.getBalance() >= amnt))
			throw new InvalidInputExceptions("Insufficient balance!!!");
		b.setBalance(b.getBalance() - amnt);
		b.setLastTransactionDate(LocalDate.now());
		System.out.println("Amount debited successfully!!! "
				+ "\n----------------------------------------------------------------------------------------------------");
	}

	public static void depositAmount(String acNo,double amnt,  List<BankAccount> list) throws InvalidInputExceptions {
		isExist(acNo, list);

		BankAccount b = new BankAccount(acNo);
		b = list.get(list.indexOf(new BankAccount(acNo)));
		if (!(b.getBalance() >= amnt))
			throw new InvalidInputExceptions("Insufficient balance!!!");
		b.setBalance(b.getBalance() + amnt);
		b.setLastTransactionDate(LocalDate.now());
		System.out.println("Amount debited successfully!!!"
				+ "\n-------------------------------------------------------------------------------------------------------");
	}
	
	
	public static void transferFunds(String srcAcno,String destAcno,double amount,List<BankAccount>bankAccount) throws InvalidInputExceptions {
		BankAccount src=new BankAccount(srcAcno);
		BankAccount dest=new BankAccount(destAcno);
		
		
		
		if(bankAccount.contains(src))
			System.out.println("ok");
		src = bankAccount.get(bankAccount.indexOf(src));
		//throw new InvalidInputExceptions("Source account doesn't exist!!!");
		
		
		if(!bankAccount.contains(dest))
			throw new InvalidInputExceptions("Source account doesn't exist!!!");
		dest = bankAccount.get(bankAccount.indexOf(dest));
		
		
		if(src.getBalance()<amount)
			throw new InvalidInputExceptions("Insufficient balance!!! ");
		
		dest.setBalance(src.getBalance()+amount);
		src.setBalance(src.getBalance()-amount);
		
		src.setLastTransactionDate(LocalDate.now());
		dest.setLastTransactionDate(LocalDate.now());
		
		System.out.println("Money transfer successfully!!!");
	}
	
	
	
	
	
	
	
	
	
	
	

}
