package CustomException;

import java.time.LocalDate;
import java.util.List;

import AccountTyp.AccountType;
import coreClass.BankAccount;




public class CustomerValidations {

	
	
	
// Authentication------------------------------------------------------------------------------------------------------
	
	public static BankAccount authenticate(String email,String password,List<BankAccount>custList) throws InvalidInputExceptions {
		//validateFormat(email);
		
		BankAccount c=null;
		for(BankAccount i:custList) {
			if(i.getEmail().equals(email)) {
				if(i.getPassword().equals(password)) {
					c=i;
					break;
				}else
					throw new InvalidInputExceptions("Incorrect password!!!");
			}
		}
		if(c==null)
			throw new InvalidInputExceptions("Email doesn't exist!!!");
		return c;
	}
	
	
	
	
// VALIDATE EMAIL FORMAT
	public static void validateFormat(String email) throws InvalidInputExceptions {
		if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
			throw new InvalidInputExceptions("Enter email in given format\n***harsh123@gmail.com***");
	}
	
	
	
// PARSE AND VALIDATE ACCOUNT TYPE
	
	public static AccountType parseAndValidateAccType(String accTyp) throws InvalidInputExceptions {
		boolean status = false;
		
		for (AccountType i : AccountType.values()) {
	        if (i.name().equalsIgnoreCase(accTyp)) {
	            status = true;
	            break; // Exit the loop when a match is found
	        }
	    }

	    if (!status) {
	        throw new InvalidInputExceptions("Choose a valid account type!!!");
	    }

	    return AccountType.valueOf(accTyp.toUpperCase());
		
	}


//AccOpeningDate: must be in after 1st Jan 2000---------------------------------------------------------------
	
	
	
	public static void validateDate(LocalDate AccOpenDate) throws InvalidInputExceptions {
		
		LocalDate accOpendate=LocalDate.parse("2000-01-01");
		if(AccOpenDate.isBefore(accOpendate) )
			throw new InvalidInputExceptions("Account opening date must be after 1st Jan 2000");
		}
	
	
//VALIDATE ACCOUNT NUMBER---------------------------------------------------------------------------------------------	
	
	public static void validateAccountNumber(String accType,List<BankAccount> bankAccount) throws InvalidInputExceptions {
		BankAccount c=new BankAccount(accType);
	
		if(bankAccount.contains(c)) 
			throw new InvalidInputExceptions("Account number already exists!!!");
		}

	
// Checking is account exist or not
	public static void isExist(String acno,List<BankAccount >list) throws InvalidInputExceptions {
		boolean status=false;
		for(BankAccount i:list) {
			if((i.getAccNo().equals(acno))) {
				status=true;
				break;}
				
		}
		if(status==false)
			throw new InvalidInputExceptions("Account doesn't exist!!! ");
	}
	
	
	
	
	
// ALL INPUT VALIDATION-------------------------------------------------------------------------------------------------	
	
	public static BankAccount validateAllInput(String AccNo,String name,String email,String password,String accTyp,
			double balance,LocalDate AccOpenDate,List<BankAccount> bankAccount) throws InvalidInputExceptions {
		
		validateAccountNumber(AccNo, bankAccount);
		//validateFormat(email);
		AccountType AccountType=parseAndValidateAccType(accTyp);
		validateDate(AccOpenDate);
		return new BankAccount(AccNo,name,email,password,AccountType,balance,AccOpenDate);
		
	}
	

}
