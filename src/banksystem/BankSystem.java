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
        
        makeDummyData();
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
    
    public static void makeDummyData(){
        System.out.println("Making dummy data");
        Account a1 = new Account("1111");
        a1.addBalance(100);
        Account a2 = new Account("2222");
        a2.addBalance(200);
        Account a3 = new Account("3333");
        a3.addBalance(300);
        AccountList.getAccountList().accounts.list.add(a1);
        AccountList.getAccountList().accounts.list.add(a2);
        AccountList.getAccountList().accounts.list.add(a3);
        AccountList.makeList();
    }


}
