package coreClass;

import java.time.LocalDate;

import AccountTyp.AccountType;

public class BankAccount implements Comparable<BankAccount>{

	private String AccNo,name,email,password;
	private double balance;
	private LocalDate AccOpeningDate,LastTransactionDate;
	public AccountType accType;
	
	
	public BankAccount(String AccNo,String name,String email,String password,
			AccountType accType,double balance,LocalDate AccOpeningDate){
		this.AccNo=AccNo;
		this.AccOpeningDate=AccOpeningDate;
		this.balance=balance;
		this.name=name;
		this.accType=accType;
		this.email=email;
		this.password=password;
		this.LastTransactionDate=AccOpeningDate;
	}
	
	

	
	
public LocalDate getLastTransactionDate() {
		return LastTransactionDate;
	}


	public void setLastTransactionDate(LocalDate lastTransactionDate) {
		LastTransactionDate = lastTransactionDate;
	}

	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	
	
	public BankAccount(String accNo) {
		super();
		AccNo = accNo;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BankAccount)
		return this.AccNo.equals(((BankAccount) obj).AccNo);
		return false;
	}

	@Override
	public String toString() {
		return AccNo +" "+ name+" " +email+" "+ balance +" "+ AccOpeningDate+" " + accType+" "+LastTransactionDate+"\n";
	}
	
	public BankAccount() {
		super();
	}

	

	public String getAccNo() {
		return AccNo;
	}

	public void setAccNo(String accNo) {
		AccNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getAccOpeningDate() {
		return AccOpeningDate;
	}

	public void setAccOpeningDate(LocalDate accOpeningDate) {
		AccOpeningDate = accOpeningDate;
	}

	public AccountType getAccType() {
		return accType;
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}

	@Override
	public int compareTo(BankAccount o) {
		
		return this.email.compareTo(o.email);
	}

	
	


}
