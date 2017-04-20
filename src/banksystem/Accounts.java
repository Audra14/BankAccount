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
        for(Account a : list){
            if(a.getAccountNumber().equals(accountNumber)){
                return a;
            }
        }
        return null;
    }
}
