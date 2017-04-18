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
    public static ArrayList<Account> list;
    
    private AccountList(){
        importList();
    }
    
    public static AccountList getAccountList(){
        return singleton;
    }
    
    private static void importList(){ //called when class is compiled to import the list if the data is saved, or call makeList() if it isn't yet.
        ArrayList<Account> newList = null;
      try {
         FileInputStream fileIn = new FileInputStream("/tmp/accountlist.ser");
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
        if(list == null){
            list = new ArrayList<Account>();
            System.out.println("New List made.");
        }
        else{
            try {
                FileOutputStream fileOut = new FileOutputStream("/tmp/accountlist.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(list);
                out.close();
                fileOut.close();
                System.out.println("Serialized data is saved in /tmp/accountlist.ser");
            }catch(IOException i) {
                i.printStackTrace();
            }
        }
    }
}
