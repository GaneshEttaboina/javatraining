package Assessement;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

 class BankAccount {
    int accountNumber;
    String acHolderName;
    String ifscNo;
    String bankName;
    double balance;

    public BankAccount(int accountNumber, String acHolderName, String ifscNo, String bankName, double balance) {
        this.accountNumber = accountNumber;
        this.acHolderName = acHolderName;
        this.ifscNo = ifscNo;
        this.bankName = bankName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "accountNumber=" + accountNumber + ", acHolderName=" + acHolderName + ", ifscNo=" + ifscNo
                + ", bankName=" + bankName + ", balance=" + balance + "\n";
    }
    public void deposit(double amount) throws NegativeBalanceException
    {
        if(amount<0)
        throw new NegativeBalanceException("Please deposite valid balance..!");
        else{
        this.balance+=amount;
        System.out.println("Successfully deposited...");
        }
    }
    public void withdraw(double amount) throws NegativeBalanceException
    {
        if(this.balance<amount)
        throw new NegativeBalanceException("Insufficient Balance..!");
        else{
            this.balance-=amount;
            System.out.println("Amount Successfully withdraw: "+amount);
            System.out.println("Available balance: "+this.balance);

        } 
    }
    public void transfer(BankAccount accNo, double amount) throws NegativeBalanceException{};

}
class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNumber, String acHolderName, String ifscNo, String bankName, double balance) {
        super(accountNumber, acHolderName, ifscNo, bankName, balance);
    }
     public void transfer(BankAccount accNo, double amount) throws NegativeBalanceException {
        if(this.balance<amount)
        throw new NegativeBalanceException("Insufficient Balance..!");
    else{
        accNo.balance += amount;
        this.balance -= amount;
        System.out.println("Transaction Successful");
   
    }
    
}
}
class SalaryAccount extends BankAccount {

    public SalaryAccount(int accountNumber, String acHolderName, String ifscNo, String bankName, double balance) {
        super(accountNumber, acHolderName, ifscNo, bankName, balance);
    }
     public void transfer(BankAccount accNo, double amount) throws NegativeBalanceException {
        if(this.balance<amount)
        throw new NegativeBalanceException("Insufficient Balance..!");
    else{
        accNo.balance += amount;
        this.balance -= amount;
        System.out.println("Transaction Successful");
   
    }
}
}
   

public class Banking{
    
    public static void main(String[] args) throws NegativeBalanceException {
        BankAccount b1=new SavingsAccount(1, "Ganesh", "ICICI002", "ICICI",43475);
        BankAccount b2=new SavingsAccount(2, "Rakesh", "ICICI002", "ICICI",500000);
        BankAccount b3=new SalaryAccount(3, "Mahesh ","SBI01", "SBI",7454);
        Scanner sc=new Scanner(System.in);
    
        List<BankAccount> bankAccounts = new LinkedList<>();
        bankAccounts.add(b1);
        bankAccounts.add(b2);
        bankAccounts.add(b3);
        System.out.println("Accounts:");
        System.out.print(bankAccounts);

        System.out.println("\nPlease enter from account Number :");
        int fromAccNo=sc.nextInt();
        System.out.println("Please enter to account Number : ");
        int toAccNo=sc.nextInt();
        System.out.println("Please enter amount : ");
        double amount=sc.nextInt();
        BankAccount fromAcObj=null;
        BankAccount toAcObj=null;
        for(BankAccount b: bankAccounts)
        {
            if(b.accountNumber==fromAccNo){
            fromAcObj=b;
            }
             if(b.accountNumber==toAccNo){
                toAcObj=b;
            }
        }
       
        fromAcObj.transfer(toAcObj,amount);
        System.out.println(bankAccounts);

    }
    
}
