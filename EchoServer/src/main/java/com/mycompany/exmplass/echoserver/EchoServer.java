/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exmplass.echoserver;

import java.io.*;
import java.net.*;

/**
 *
 * @author reatl
 */
public class EchoServer {

    public static void main(String[] args) {
        //Connection Attributes
        ServerSocket echoServer = null;
        String line;
        DataInputStream input;
        PrintStream output;
        Socket clientSocket = null;
        
        //Print out a cnnection 
        System.out.println("Hello user! Starting to connect.....");
        
        try{
            //Retrieve a socket connection from client using port number
            echoServer = new ServerSocket(16000);
            
        }catch(IOException e){
            System.out.println("Server error: " + e);
        }
        
        try{
            
            //Accept the Client socket passed
            clientSocket = echoServer.accept();
            
            //Create the  DataInputStream
            input = new DataInputStream(clientSocket.getInputStream());
            
            //Now read the input from a client
            BufferedReader is = new BufferedReader(new InputStreamReader(input));
            
            //Output the info to the client 
            output = new PrintStream(clientSocket.getOutputStream());
            
            while (true){
                line = is.readLine();
                
                // The following line print to the client
                output.println("Server Echoing back : " + line);
                
                //This client response is printed on the server
                System.out.println("Received from client : " + line);
            }
        
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
}
