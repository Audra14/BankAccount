package banksystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljf5124 on 1/15/2017.
 */
public class User {
    private String name;

    private List<Account> accounts;

    private long id;

    public User(String newName){
        this.name = newName;
        List<Account> newAccounts = new ArrayList<>();
        this.accounts = newAccounts;
        this.id = (long)(Math.random() * 10) + 1;
    }

    public void addAccount(Account newAccount){
        this.accounts.add(newAccount);
    }

    public void removeAccount(Account oldAccount){
        this.accounts.remove(oldAccount);
    }

    public List<Account> getAccounts(){
        return this.accounts;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return this.name;
    }

    public long getId(){
        return this.id;
    }
}
