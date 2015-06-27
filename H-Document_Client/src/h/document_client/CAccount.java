/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

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
    
    public List<String> GetAllDocIDBelongToAnUser()
    {
        return (List<String>)ClientObjectManager.ExecuteStaticMethod("Document", "GetAllDocIDBelongToAnUser", this.Handle);
    }
    
    private String GetUserName()
    {
       return (String)ClientObjectManager.GetAttributeValue(Handle, "UserName");
                
    }
    
    public void SetPassword(String newPasword)
    {
        
    }
}
