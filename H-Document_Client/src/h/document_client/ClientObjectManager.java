/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import h.document_server.HDocument_Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 12123_000
 */
public class ClientObjectManager {
    
    public static ObjectInputStream is;
    public static ObjectOutputStream os;
    public static Socket s;
    
    public static String CreateNewObject(String ObjectType) 
    {
        try {
            os.writeObject("CreateNewObject");
            os.writeObject(ObjectType);
            return (String)is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
    }
    
   
    
    public static boolean SetAttributeValue(String Handle, String strAttributeName, Object newValue)
    {
        try {
            os.writeObject("SetAttributeValue");
            os.writeObject(Handle);
            os.writeObject(strAttributeName);
            os.writeObject(newValue);
            return (boolean)is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            
        }
    }
    
     public static Object GetAttributeValue(String Handle, String strAttributeName)
     {
         try {
            os.writeObject("GetAttributeValue");
            os.writeObject(Handle);
            os.writeObject(strAttributeName);
        
            return is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            
        }
     }
     
    public static Object ExecuteMethod(String Handle, String strFunctionName, Object param)
    {
        try {
            os.writeObject("ExecuteMethod");
            os.writeObject(Handle);
            os.writeObject(strFunctionName);
            os.writeObject(param);
            return is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            
        }
    }
    
    public static Object ExecuteStaticMethod(String ObjectType, String strFunctionName, Object param)
    {
        try {
            os.writeObject("ExecuteStaticMethod");
            os.writeObject(ObjectType);
            os.writeObject(strFunctionName);
            os.writeObject((String)param);
            Object o = is.readObject();
            System.out.println(o);
                return o;
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {
            
        }
    }
    
    public static boolean AddBindingInfor(String Handle)
        {
            try {
            os.writeObject("ExecuteStaticMethod");
            os.writeObject(Handle);
          
            return (boolean)is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
           
        }
        }
}
