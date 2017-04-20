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
    public AccountList list;
    
    public static void main(String[] args) throws IOException {
        
        AccountList list = new AccountList();
        makeDummyData(list);
        System.out.println("The bank server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                ServerHandler handler = new ServerHandler(listener.accept(), list);
                handler.start();

            }
        } finally {
            listener.close();
        }
    }
    
    public static void makeDummyData(AccountList list){
        System.out.println("Making dummy data");
        Account a1 = new Account("1111");
        a1.addBalance(100);
        Account a2 = new Account("2222");
        a2.addBalance(200);
        Account a3 = new Account("3333");
        a3.addBalance(300);
        
        list.accounts.list.add(a1);
        list.accounts.list.add(a2);
        list.accounts.list.add(a3);
        list.makeList();
    }


}
