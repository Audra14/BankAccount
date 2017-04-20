package banksystem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ljf5124
 */
public class Accounts implements Serializable{
    public ArrayList<Account> list;
    
    public Accounts(){
        list = new ArrayList<Account>();
    }
    
    public Account getAccount(String accountNumber){
        System.out.println(accountNumber);
        for(Account a : list){
            System.out.println("Account number: " + a.getAccountNumber());
            if(a.getAccountNumber().equals(accountNumber)){
                return a;
            }
        }
        return null;
    }
}
