import java.util.Scanner;
//CREATED A CLASS "ACCOUNT"
public class Account {
//=========declaring variables=====================
	int balance;
	int previoustransaction;
	String customerName;
	String customerID;
//=================================================
	
	
	//class constructor
	Account(String cname, String cid){
		customerName=cname;
		customerID=cid;
	}
	//FUNCTION FOR DEPOSTING MONEY
	void deposit(int money) {
		if (money !=0) {
			balance=balance+money;
			previoustransaction= money;
		}
	}
	//FUNCTION FOR WITHDRAWING MONEY
	void withdraw(int money) {
		if (money !=0) {
			balance=balance-money;
			previoustransaction= -money;
		}
	}
	//FUNCTION SHOWING THE PREVIOUS TRANSACTION
	
	void getPreviousTransaction() {
		if (previoustransaction > 0) {
			System.out.println("Deposited:"+previoustransaction);
		} else if (previoustransaction<0) {
			System.out.println("Withdrawn:"+Math.abs(previoustransaction));
		} else {
			System.out.println("No previosu transaction has happend!!!");
		}
		
	}
	
	
	//FUNCTION FOR INTEREST CALCULATION:
	void calcInterest(int years) {
		double intrate= 0.89;
		double new_balance= balance+(balance*intrate*years);
		System.out.println("Current interest rate will be:"+(100*intrate)+"%");
		System.out.println("After "+ years+"years later your balance will be:"+new_balance);
	}
	
	//Function showing the menu:
	void showMenu() {
		char option ='\0';
		Scanner sc =new Scanner(System.in);
		System.out.println("Welcome Mr. "+customerName+"!");
		System.out.println("Your ID is "+ customerID);
		System.out.println();
		System.out.println("What would you like to do:");
		System.out.println();
		System.out.println("A. Balance enquiry:");
		System.out.println("B. Make a Deposit:");
		System.out.println("C. Make a withdrawl:");
		System.out.println("D. View previous transaction:");
		System.out.println("E. Interest Calculation:");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option:");
			char option1 = sc.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("=========================================");
				System.out.println("Balance:"+balance+"/-");
				System.out.println("=========================================");
				System.out.println();
				break;
				
			case 'B':
				System.out.println("Enter an amount to deposit:");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println();
				break;	
			case 'C':
				System.out.println("Enter an amount to withdraw:");
				int amount2= sc.nextInt();
				if (amount2>balance) {
					System.out.println("Unavailabel balance!!!");
					break;
				}
				else{
					withdraw(amount2);
					System.out.println();
					break;
				}
				
			case 'E':
				System.out.println("Enter how many years for interest:");
				int years= sc.nextInt();
				calcInterest(years);
				break;
			case 'F':
				System.out.println("=======================================");
				break;
			default:
				System.out.println("Error: invalid option. ");
				break;
				
			}
		}while (option !='F');
		System.out.println("Thank you for banking with us");
	}
	
}


