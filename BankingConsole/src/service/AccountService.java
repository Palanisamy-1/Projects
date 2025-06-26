package service;

import dao.AccountDAO;
import model.Account;
public class AccountService {
	private final AccountDAO accountDAO=new AccountDAO();
	public void createAccount(String name,String email,String phone,double amt) {
		Account account=accountDAO.createAccount(name, email, phone, amt);
		if(account!=null) {
			System.out.println("Happy Banking 😊"+name);
			System.out.println("Your AccountId is : "+account.getAccno());
		}
		
	}
	public void deposit(int accno,double amount) {
		Account acc=accountDAO.getAccount(accno);
		if(acc!=null && amount>0) {
			double newamount=acc.getBalance()+amount;
			accountDAO.updateBalance(accno, newamount);
			System.out.println("Deposited Amount of Rupees: "+amount);
		}
		else {
			System.out.println("Invalid Deposit☹️.");
		}		
	}
	public void withDraw(int accno,double amount) {
		Account acc=accountDAO.getAccount(accno);
		if(acc!=null && amount<acc.getBalance() && amount>0) {
			double newamount=acc.getBalance()-amount;
			accountDAO.updateBalance(accno, newamount);
			System.out.println("WithDrawn : "+amount);
		}
		else {
			System.out.println("Unable to WithDraw Amount,☹️.");
		}		
	}
	public void checkBalance(int accno) {
		Account account=accountDAO.getAccount(accno);
		if(account!=null) {
			System.out.println("Available Current Balance: "+account.getBalance());
		}
	}
	
}
