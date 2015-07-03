/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12123_000
 */
public class CAccount extends ClientObject{
    public CAccount(String userName, String password, String email)
    {
        this.Handle = ClientObjectManager.CreateNewObject("Account");
        ClientObjectManager.SetAttributeValue(Handle, "UserName", userName);
        ClientObjectManager.SetAttributeValue(Handle, "Password", password);
        ClientObjectManager.SetAttributeValue(Handle, "Email", email);
    }
    
    public CAccount(String handle)
    {
        this.Handle = handle;
        
    }
    
    
    
    public String GetUserName()
    {
       return (String)ClientObjectManager.GetAttributeValue(Handle, "UserName");
                
    }
    
    public void SetPassword(String newPasword)
    {
        
    }

    public List<String> GetAllFriendID() {
       List<String> kq = new ArrayList<String>();
       
        String[] strs = (String[])ClientObjectManager.ExecuteMethod(this.Handle, "GetAllFriendID", null);
        
        for(int i = 0; i< strs.length; i++)
        {
            kq.add(strs[i]);
        }
        return kq;
    }

    List<String> GetAllDocIDBelongToUser() {
       List<String> kq = new ArrayList<String>();
        String[] strs = (String[])ClientObjectManager.ExecuteMethod(this.Handle, "GetAllDocIDBelongToUser", null);
        
        for(int i = 0; i< strs.length; i++)
        {
            kq.add(strs[i]);
        }
        return kq;
    }
}
