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
}
