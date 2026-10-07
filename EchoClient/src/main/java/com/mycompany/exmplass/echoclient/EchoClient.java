/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exmplass.echoclient;

import java.io.*;
import java.net.*;

/**
 *
 * @author reatl
 */
public class EchoClient {

    public static void main(String[] args) {
        //Connection Attributes
        Socket clientSocket = null;
        PrintWriter output = null;
        BufferedReader input = null;
        
        //Create a connect string of the client device
        try{
            //My client details with port number connection
            clientSocket = new Socket("127.0.0.1", 16000);
            
            //Output some message to send to the server
            output = new PrintWriter (clientSocket.getOutputStream(), true);
            
            //Input for getting any input response from the server
            input = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
            
        }catch(IOException e){
            System.out.println("Client Error occured " + e);
        }
        
        //Create a oppotunity for the client  to also read and write tothe server
        BufferedReader stdln = new BufferedReader (new InputStreamReader(System.in));
        String userInput;
        
        //Communication between to two parties
        try{
            
            while((userInput = stdln.readLine()) != null){
                output.println(userInput);
                System.out.println(input.readLine());
            } 
        }catch(Exception e){
            System.out.println(" Communication error has occured :" + e);
        }
    }
}
