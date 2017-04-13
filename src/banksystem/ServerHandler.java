/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        
    }
}
