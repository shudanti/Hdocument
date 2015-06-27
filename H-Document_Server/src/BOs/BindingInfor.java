/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 12123_000
 */
public class BindingInfor {
    
     private Socket s;
     ObjectInputStream is;
             ObjectOutputStream os;
     

    public BindingInfor(Socket ss, ObjectInputStream is, ObjectOutputStream os) {
        s = ss;
        this.is = is;
        this.os = os;
    }
     
    public void Notify()
    {
         try {
             os.writeObject("UpdateView");
         } catch (IOException ex) {
             Logger.getLogger(BindingInfor.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
