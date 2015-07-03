/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import BOs.BindingInfor;
import BOs.ServerObjectManager;
import h.document_server.ClientComunitorThread;
import h.document_server.HDocument_Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12123_000
 */
public class ServerCommunitorThread extends Thread{
    
    public ObjectInputStream is;
    public  ObjectOutputStream os;
    public  Socket s;
    
    public ServerCommunitorThread (Socket inS, ObjectInputStream inIs, ObjectOutputStream inOs)
    {
        s = inS;
        os = inOs;
        is = inIs;
    }
    
    @Override
    public void run()
    {
        try
		{

                    
                    is= new ObjectInputStream(s.getInputStream());

                    os = new ObjectOutputStream(s.getOutputStream());

                    String receivedMessage = "";
                    
                    do
                    {
                            receivedMessage = (String)is.readObject();
                            //System.out.println("Received : " + receivedMessage);
                            if (receivedMessage.equalsIgnoreCase("quit"))
                            {
                                    
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
			System.out.println("There're some error: "+e);
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientComunitorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

    private void DoWithReseivedMessage(String receivedMessage) {
        switch(receivedMessage)
        {
            case "UpdateView":
            {
                HDocument_Client.loginForm.UpdateView();
            }

        }
       
    }
}
