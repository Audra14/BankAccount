package banksystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author ljf5124
 */
public class AccountList {
    
    private static AccountList singleton = new AccountList();
    public static Accounts accounts;
    
    private AccountList(){
        importList();
    }
    
    public static AccountList getAccountList(){
        return singleton;
    }
    
    private static void importList(){ //called when class is compiled to import the list if the data is saved, or call makeList() if it isn't yet.
        ArrayList<Account> newList = null;
      try {
         FileInputStream fileIn = new FileInputStream("src/accountlist.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         newList = (ArrayList<Account>) in.readObject();
         in.close();
         fileIn.close();
      }catch(FileNotFoundException f){
          makeList();
      }catch(IOException i) {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c) {
         System.out.println("Account class not found");
         c.printStackTrace();
         return;
      }
    }
    
    public static void makeList(){ //called to make a new List if one doesn't exist yet, or write the current list to a file if it does.
        if(accounts == null){
            accounts = new Accounts();
            System.out.println("New List made.");
        }
        else{
            System.out.println("Saving data");
            
            try {
                FileOutputStream fileOut = new FileOutputStream("src/accountlist.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(accounts);
                out.close();
                fileOut.close();
                System.out.println("Serialized data is saved in src/accountlist.ser");
            }catch(IOException i) {
                i.printStackTrace();
            }
        }
    }
}
