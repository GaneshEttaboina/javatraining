abstract class BankAccount{
    int balance;
    int transactions=0;
    public double deposit(double amount) throws NegativeBalanceException{
        if(amount<0){
            throw new NegativeBalanceException("Please specify valid amount to deposit");
        }
        balance+=amount;
        transactions+=1;
        System.out.println("Successfully deposited the amount : "+amount);
        System.out.println("Total amount : "+balance);
        return amount;
    }
    public double withdraw(double amount) throws NegativeBalanceException{
        if(amount>balance){
            throw new NegativeBalanceException("Insufficient Balance");
        }
        else{
            balance-=amount;
            transactions+=1;
            System.out.println("successsfully with drawn amount : "+amount);
            System.out.println("Remaining amount : "+balance);
        }
        return balance;
    }
    abstract void endOfMonth() throws NegativeBalanceException;
    public BankAccount(int balance) throws NegativeBalanceException {
        if(balance<=0){
            throw new NegativeBalanceException("Please mention correct amount");
        }
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "BankAccount [balance=" + balance + ", transactions=" + transactions + "]";
    }
    
}

class SavingsAccount extends BankAccount{
    public SavingsAccount(int balance) throws NegativeBalanceException {
        super(balance);
    }
 
    public void addInterest(){
        balance+=((balance*0.12*5)/100);
    }
 
    @Override
    void endOfMonth() {
        this.addInterest();
    }

    
}
class CheckingAccount extends BankAccount{
    final int free_transaction=15;
    final double transaction_fee=10;
    public CheckingAccount(int balance) throws NegativeBalanceException {
        super(balance);
    }
    @Override
    void endOfMonth() throws NegativeBalanceException {
        this.deductFees();
    }
    private void deductFees() throws NegativeBalanceException {
        if(this.transactions>free_transaction){
            this.withdraw(transaction_fee);
        }
       
    }
    @Override
    public String toString() {
        return "CheckingAccount [free_transaction=" + free_transaction + ", transaction_fee=" + transaction_fee + "]";
    }
    
}

public class Banking {
public static void main(String[] args) throws NegativeBalanceException {
    SavingsAccount savings=new SavingsAccount(10000);
    CheckingAccount checking=new CheckingAccount(10000);
    savings.deposit(500);
    checking.deposit(443);
    savings.withdraw(1657);
    checking.withdraw(1957);

}
}


