package banksystem;

import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author ljf5124
 */
public class BankSystem {
    
    private static final int PORT = 6666;
    
    public static void main(String[] args) throws IOException {
        
        AccountList list = AccountList.getAccountList();
        System.out.println("The bank server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                ServerHandler handler = new ServerHandler(listener.accept());
                handler.start();

            }
        } finally {
            listener.close();
        }
    }

        /*Account a = new Account("xxxxxxxx", "xxxxxxxx");
        a.addBalance(100);
        User user = new User("user");
        user.addAccount(a);
        System.out.println("This is meant to demonstrate thread safety problems. It creates 100 threads making a $1 transfer from the same bank account with $100 in it at the same time. \n If every thing works correctly, the final balance will be $0. The last thread to execute is not necessarily the last to print, so you may have to look for a moment. \n It works correctly without thread safety problems.");
        for(int i =0; i<100; i++){
            Transaction t = new Transfer(user, a, 1, "x");
            try{
                t.sleep((long)Math.random()*101);
            }catch(InterruptedException e){
            }
            t.start();
        }
        Transaction balInq = new BalanceInquiry(user,a);
        try{
            balInq.sleep(1000);
        }catch(InterruptedException e){

        }
        balInq.start(); 
    }*/
}
