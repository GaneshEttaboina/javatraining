package P;
abstract class BankAccounts {
    String accountNumber;
    double balance;
 
    public abstract void transfer(BankAccounts destinationAccount, double amount);
 
}
class SavingsAccount extends BankAccounts {
 
    @Override
    public void transfer(BankAccounts destinationAccount, double amount) {
        this.balance+=amount;
        System.out.println("Successfully deposited amount: "+this.balance);
        }
    }
 
class CheckingAccount extends BankAccounts {
 
    @Override
    public void transfer(BankAccounts destinationAccount, double amount) {
        this.balance+=amount;
        System.out.println("Successfully deposited amount: "+this.balance);
    }
}
 
 /**
  * BankAccount
  */
 public class BankAccount {
 
   
    public static void main(String[] args) {
   
        BankAccounts savingsAccount = new SavingsAccount();
        BankAccounts checkingAccount = new CheckingAccount();
 
        // Perform a fund transfer between accounts using polymorphism
        savingsAccount.transfer(checkingAccount, 10000.0);
    }
}
