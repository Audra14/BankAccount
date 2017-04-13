package banksystem;


public class Transfer extends Transaction{
    
    private double tAmount;
    
    private String receivingAccount;
    
    public Transfer(User newUser, Account newAccount, double newTAmount, String rAccount){
        super(newUser, newAccount);
        this.tAmount = newTAmount;
        this.receivingAccount = rAccount;
    }
    
    public void run(){
        double amount = this.tAmount;
        String receivingAccnt = this.receivingAccount;
        Account curAccount = this.getAccount();
        long curId = curAccount.getId();
        double startingBal  = curAccount.getBalance();
        System.out.println("Beginning transfer from account " + curId + " to account number " + receivingAccnt);

        if(amount > curAccount.getBalance()){//If more money is withdrawn than is in account
            System.out.println("There are not enough funds in the account.");
        }
        else{//If there are enough funds to be withdrawn
            curAccount.subtractBalance(amount);
            //curAccount.setBalance(startingBal - amount);
            this.setLog("$" + amount + " transferred from account " + curId + " to account number " + receivingAccnt + " by user " + this.getUser().getId() +". Starting balance: $" + startingBal + ". New Balance: $" + curAccount.getBalance());
            this.close();
        }
    }
}
