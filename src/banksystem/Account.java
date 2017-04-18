package banksystem;

import java.util.ArrayList;
import java.util.List;

public class Account {

    //private List<User> users;

    private String accountNumber;

    private String routingNumber;

    private double balance;
    
    private long id;

    public Account(String newAccountNumber, String newRoutingNumber){
        this.id = (long)(Math.random() * 100) + 1;
        this.accountNumber = newAccountNumber;
        this.routingNumber = newRoutingNumber;
    }


    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getRoutingNumber(){
        return this.routingNumber;
    }

    public void addBalance(double toAdd){
        this.balance += toAdd;
    }

    public void subtractBalance(double toSubtract){
        this.balance -= toSubtract;
    }
    
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }

    public double getBalance(){
        return this.balance;
    }

    public long getId(){
        return this.id;
    }
}
