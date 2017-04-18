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


}
