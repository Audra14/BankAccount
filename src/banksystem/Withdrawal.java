package banksystem;

public class Withdrawal extends Transaction{
    
    private double wAmount;
    
    public Withdrawal(User newUser, Account newAccount, double newWAmount){
        super(newUser, newAccount);
        this.wAmount = newWAmount;
    }
    
    public void run(){
        double amount = this.wAmount;
        Account curAccount = this.getAccount();
        long curId = curAccount.getId();
        double startingBal  = curAccount.getBalance();
        System.out.println("Beginning withdrawal from account " + curId + ".");

            if(amount > curAccount.getBalance()){//If more money is withdrawn than is in account
                System.out.println("There are not enough funds in the account.");
            }else{//If there are enough funds to be withdrawn
                curAccount.subtractBalance(amount);
                //curAccount.setBalance(startingBal - amount);
                this.setLog("$" + amount + " withdrawn from account " + curId + " by user " + this.getUser().getId() + ". Starting balance: $" + startingBal + ". New Balance: $" + curAccount.getBalance());
                this.close();
            }
    }
    
}
