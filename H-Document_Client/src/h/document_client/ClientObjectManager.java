/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import h.document_server.HDocument_Server;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 12123_000
 */
public class ClientObjectManager {
    
    public static ServerCommunitorThread thread = null;
    
    public static String CreateNewObject(String ObjectType) 
    {
        try {
            thread.os.writeObject("CreateNewObject");
            thread.os.writeObject(ObjectType);
            return (String)thread.is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
   
    
    public static boolean SetAttributeValue(String Handle, String strAttributeName, Object newValue)
    {
        try {
            thread.os.writeObject("SetAttributeValue");
            thread.os.writeObject(Handle);
            thread.os.writeObject(strAttributeName);
            thread.os.writeObject(newValue);
            return (boolean)thread.is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return false;
        }
    }
    
     public static Object GetAttributeValue(String Handle, String strAttributeName)
     {
         try {
            thread.os.writeObject("GetAttributeValue");
            thread.os.writeObject(Handle);
            thread.os.writeObject(strAttributeName);
        
            return thread.is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return null;
        }
     }
     
    public static Object ExecuteMethod(String Handle, String strFunctionName, Object param)
    {
        try {
            thread.os.writeObject("ExecuteMethod");
            thread.os.writeObject(Handle);
            thread.os.writeObject(strFunctionName);
            thread.os.writeObject(param);
            return thread.is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return null;
        }
    }
    
    public static Object ExecuteStaticMethod(String ObjectType, String strFunctionName, Object param)
    {
        try {
            thread.os.writeObject("ExecuteStaticMethod");
            thread.os.writeObject(ObjectType);
            thread.os.writeObject(strFunctionName);
            thread.os.writeObject((String)param);
            return thread.is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return null;
        }
    }
    
    public static boolean AddBindingInfor(String Handle)
        {
            try {
            thread.os.writeObject("ExecuteStaticMethod");
            thread.os.writeObject(Handle);
          
            return (boolean)thread.is.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientObjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return false;
        }
        }
}
