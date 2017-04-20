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
    private AccountList list;
    
    public ServerHandler(Socket socket, AccountList list) {
        this.socket = socket;
        this.list = list;
    }

    public void run() {
        try {
            while (true) {
                
                InputStream in = socket.getInputStream();
                DataInputStream input = new DataInputStream(in);
                OutputStream out = socket.getOutputStream();
                DataOutputStream output = new DataOutputStream(out);
                
                while(true){
                    String pin = input.readUTF();
                    if(checkPin(pin)){
                        output.writeUTF("1");
                        break;
                    } else {
                        output.writeUTF("0");
                    }
                }
                
                String message = input.readUTF();
                System.out.println(message);
                String accountNumber = message.substring(0, 3);
                double amount;
                Transaction t;
                //Account a = findAccount(accountNumber);
                //Temporary fake account:
                Account a = new Account(accountNumber);
                
                a.addBalance(100);
                char specifier = message.charAt(5);
                
                if(specifier == '0'){ //If Balance
                    
                    output.writeUTF("Your balance: " + Double.toString(a.getBalance()));
                    
                } else if(specifier == '1'){ //If Deposit
                    
                    amount = Double.parseDouble(message.substring(7, message.length()));
                    t = new Deposit(a, amount);
                    t.start();
                    try{
                        t.join();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    output.writeUTF("Deposit Successful. New balance: " + a.getBalance());
                    this.list.makeList();
                    
                } else if(specifier == '2'){ //If Withdrawal
                    
                    amount = Double.parseDouble(message.substring(7, message.length()));
                    t = new Withdrawal(a, amount);
                    t.start();
                    try{
                        t.join();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    output.writeUTF("Withdrawal Successful. New balance: " + a.getBalance());
                    this.list.makeList();
                    
                } else { //If transfer
                    
                    Account newAccount = new Account(message.substring(7, 10));
                    amount = Double.parseDouble(message.substring(12, message.length()));
                    t = new Transfer(a, amount, newAccount);
                    t.start();
                    try{
                        t.join();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    output.writeUTF("Transfer Successful");
                    this.list.makeList();
                    
                }
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    
    public boolean checkPin(String pin){
        ArrayList<Account> thisList = this.list.accounts.list;
        for(Account account: thisList){
            if(account.getAccountNumber().equals(pin)){
                return true;
            }
        }
        return false;
    
    }
}
