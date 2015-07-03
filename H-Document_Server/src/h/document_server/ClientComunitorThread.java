/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_server;



import BOs.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 12123_000
 */
public class ClientComunitorThread extends Thread{
    
    Socket ss;
    ObjectInputStream is;
    ObjectOutputStream os;
    
    public ClientComunitorThread(Socket s, ObjectInputStream iis, ObjectOutputStream ios)
    {
        ss = s;
        is= iis;
        os = ios;
    }
    
    @Override
    public void run()
    {
        try
		{

                    String receivedMessage;

                    do
                    {
                            receivedMessage = (String)is.readObject();
                            System.out.println("Received : " + receivedMessage);
                            if (receivedMessage.equalsIgnoreCase("quit"))
                            {
                                    HDocument_Server.handlers.remove(this);
                                    break;
                            }
                            else
                            {

                                    DoWithReseivedMessage(receivedMessage);
                            }
                    }
                    while (true);
                    is.close();
                    os.close();
			
			
		}
		catch(IOException e)
		{
			System.out.println("There're some error");
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientComunitorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void DoWithReseivedMessage(String receivedMessage) {
        try
        {
            switch(receivedMessage)
            {
                case "ExecuteStaticMethod":
                {
                    String objectType = (String)is.readObject();
                    System.out.println(objectType);
                    String functionName = (String)is.readObject();
                    System.out.println(functionName);
                    Object param = is.readObject();
                    System.out.println(param);
                    Object o = ServerObjectManager.ExecuteStaticMethod(objectType, functionName, param);
                  
                   
                    os.writeObject(o);
                    break;
                }
                case "ExecuteMethod":
                {
                    String Handle =  (String)is.readObject();
                    String functionName = (String)is.readObject();
                    Object param = is.readObject();
                    os.writeObject(ServerObjectManager.ExecuteMethod(Handle, functionName, param));
                    break;
                }
                case "GetAttributeValue":
                {
                    String Handle =  (String)is.readObject();
                    String attriButeName = (String)is.readObject();
                    os.writeObject(ServerObjectManager.GetAttributeValue(Handle, attriButeName));
                    break;
                }
                case "SetAttributeValue":
                {
                    String Handle =  (String)is.readObject();
                    String attriButeName = (String)is.readObject();
                    Object newValue = (String)is.readObject();
                    os.writeObject(ServerObjectManager.SetAttributeValue(Handle, attriButeName, newValue));
                    break;
                }
                case "CreateNewObject":
                {
                    String objectType = (String)is.readObject();
                    os.writeObject(ServerObjectManager.CreateNewObject(objectType));
                    break;
                }
                case "FindObject":
                {
                    int Handle =  (int)is.readObject();
                    os.writeObject(ServerObjectManager.FindObject(Handle));
                        
                    break;
                }
                case "AddBindingInfor":
                {
                    String Handle =  (String)is.readObject();
                    os.writeObject(ServerObjectManager.AddBindingInfor(Handle, new BindingInfor(ss, is, os)));
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientComunitorThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientComunitorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
    
