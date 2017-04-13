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
                if(message.charAt(0) == 0){ //If Balance
                    output.writeUTF("Balance");
                } else if(message.charAt(0) == 1){ //If Deposit
                    output.writeUTF("Deposit Successful");
                } else if(message.charAt(0) == 2){ //If Withdrawal
                    output.writeUTF("Withdrawal Successful");
                } else { //If transfer
                    output.writeUTF("Transfer Successful");
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
