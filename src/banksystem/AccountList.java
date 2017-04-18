package banksystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


/**
 *
 * @author ljf5124
 */
public class AccountList {
    
    private static AccountList singleton = new AccountList();
    private ArrayList<Account> list;
    
    private AccountList(){
        importList();
    }
    
    public static AccountList getAccountList(){
        return singleton;
    }
    
    private void importList(){
        ArrayList<Account> newList = null;
      try {
         FileInputStream fileIn = new FileInputStream("/tmp/accountlist.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         newList = (ArrayList<Account>) in.readObject();
         in.close();
         fileIn.close();
      }catch(FileNotFoundException f){
          
      }catch(IOException i) {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c) {
         System.out.println("Account class not found");
         c.printStackTrace();
         return;
      }
    }
}
