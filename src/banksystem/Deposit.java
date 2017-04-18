package banksystem;

public class Deposit extends Transaction{
    
    private double dAmount;
    
    public Deposit(Account newAccount, double newDAmount){
        super(newAccount);
        this.dAmount = newDAmount;
    }
    
    public void run(){
        double amount = this.dAmount;
        Account curAccount = this.getAccount();
        long curId = curAccount.getId();
        double startingBal  = curAccount.getBalance();
        System.out.println("Beginning deposit to account " + curId + ".");
        //curAccount.setBalance(startingBal + amount);
        curAccount.addBalance(amount);
        this.setLog("$" + amount + " deposited to account " + curId + " by user ______. Starting balance: $" + startingBal + ". New Balance: $" + curAccount.getBalance());
        this.close();
    }
}
