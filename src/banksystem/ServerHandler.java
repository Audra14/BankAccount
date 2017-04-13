/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author astafursky
 */
public class ServerHandler extends Thread {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    
    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                InputStream in = socket.getInputStream();
                DataInputStream input = new DataInputStream(in);
                OutputStream out = socket.getOutputStream();
                DataOutputStream output = new DataOutputStream(out);
                String message = input.readUTF();
                System.out.println(message);
                String accountNumber = message.substring(0, 3);
                double amount;
                Transaction t;
                //Account a = findAccount(accountNumber);
                //Temporary fake account:
                Account a = new Account(accountNumber, "1111");
                User u = new User("name");
                a.addBalance(100);
                char specifier = message.charAt(5);
                if(specifier == '0'){ //If Balance
                    output.writeUTF(Double.toString(a.getBalance()));
                } else if(specifier == '1'){ //If Deposit
                    amount = Double.parseDouble(message.substring(4));
                    t = new Deposit(u, a, amount);
                    output.writeUTF("Deposit Successful. New balance: " + a.getBalance());
                } else if(specifier == '2'){ //If Withdrawal
                    amount = Double.parseDouble(message.substring(4));
                    t = new Withdrawal(u, a, amount);
                    amount = Double.parseDouble(message.substring(4));
                    output.writeUTF("Withdrawal Successful. New balance: " + a.getBalance());
                } else { //If transfer
                    output.writeUTF("Transfer Successful");
                }
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
