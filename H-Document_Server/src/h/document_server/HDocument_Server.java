/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_server;

import BOs.Account;
import BOs.ServerObjectManager;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 12123_000
 */
public class HDocument_Server {

    static int MaxConnection = 50;
    static List<ClientComunitorThread> handlers = new ArrayList<ClientComunitorThread>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerObjectManager.InitAllObject();
        try
		{
			ServerSocket s = new ServerSocket(3200);
			
			do{
				System.out.println("Waiting for a Client");
			
				Socket ss=s.accept(); //synchronous
				
			
				
				System.out.println("Talking to client");
				System.out.println(ss.getPort());
				
                                ObjectInputStream is;
                                ObjectOutputStream os;
                                System.out.println("getInputStream");
				 is= new ObjectInputStream(ss.getInputStream());
                                    //BufferedReader br=new BufferedReader(new InputStreamReader(is));
                                 System.out.println("getOutputStream");
                                 os = new ObjectOutputStream(ss.getOutputStream());
                                    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
	

                                    //lay thong tin dang nhap
                                 System.out.println("getparam");
                                 Object param = is.readObject();

                                  //chung nhan
                                 String id = (String)ServerObjectManager.ExecuteStaticMethod("Account", "Validate", param);

                                 System.out.println("sendresult");
                                 if(id.compareTo("") == 0)
                                 {
                                     os.writeObject("Fail");
                                     is.close();
                                     os.close();
                                 }
                                 else if(id.compareTo("") != 0 && handlers.size() < MaxConnection)
                                 {

                                     

                                     os.writeObject("Success");
                                     os.writeObject(id);

                                     ClientComunitorThread handler = new ClientComunitorThread(ss, is, os);
                                     handler.start();
                                     
                                     handlers.add(handler);
                                 }
                                 else
                                 {
                                     os.writeObject("Limited");
                                     is.close();
                                     os.close();

                                 }
                        } while(true);
 
			
			
		}
		catch(IOException e)
		{
			System.out.println("There're some error");
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(HDocument_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

    private static void DoLogin() {
        
        
    }
        
    
    
}
