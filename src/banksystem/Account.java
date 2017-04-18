package banksystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable{

    private String accountNumber;


    private double balance;
    
    private long id;

    public Account(String newAccountNumber){
        this.id = (long)(Math.random() * 100) + 1;
        this.accountNumber = newAccountNumber;
    }


    public String getAccountNumber(){
        return this.accountNumber;
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
