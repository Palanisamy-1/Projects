package palani;

import java.util.*;
import service.AccountService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		AccountService obj=new AccountService();
		int choice;
		do {
            System.out.println("\n1.createAccount\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit");
            choice=scanner.nextInt();
            switch(choice) {
            	case 1:
            		System.out.println("Enter the Details of the holder");
            		System.out.println("Enter the Holder Name : ");
            		String name=scanner.next();
            		System.out.println("Enter the Holder Email : ");
            		String email=scanner.next();
            		System.out.println("Enter the Holder phone : ");
            		String phone=scanner.next();
            		System.out.println("Enter the Initial Deposite amount : ");
            		double amt=scanner.nextDouble();
            		obj.createAccount(name, email, phone, amt);
            		break;
            	case 2:
                    System.out.print("Enter amount to ACC\no and deposit: ");
                    int id1=scanner.nextInt();
                    obj.deposit(id1, scanner.nextDouble());
                    break;
            	case 3:
                    System.out.print("Enter amount to ACC\no and withdraw: ");
                    int id2=scanner.nextInt();
                    obj.deposit(id2, scanner.nextDouble());
                    break;
            	case 4:
            		 System.out.println("Enter the account number");
                     obj.checkBalance(scanner.nextInt());
                     break;
            	 
            }
			
		}while(choice!=5);
		
	}

}
