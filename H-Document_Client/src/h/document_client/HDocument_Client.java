/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author 12123_000
 */
public class HDocument_Client {

    
    
    
    
    public static LoginForm loginForm;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        loginForm = new LoginForm();
        loginForm.show();
    }
    
}
