/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import DataAccess.AccountDAO;
import DataAccess.AccountDTO;
import DataAccess.DocumentDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12123_000
 */
public class Account extends ServerObject{
    
    public static String Validate(String userName, String password)
    {
        return AccountDAO.Validate(userName, password);
    }

    static List<ServerObject> GetAllAccount() {
        List<ServerObject> rs = new ArrayList<ServerObject>();
        
        List<String> accountID = AccountDAO.GetAllAccountID();
        
        for(String s : accountID)
        {
            rs.add(new Account(s));
        }
        
        return rs;
    }
    
    
    private Account(String handle)
    {
        this.Handle = handle;
    }
   // public AttributeList attributes = new AttributeList();
   
   

    public Account() {
        this.Handle = String.valueOf(ServerObject._NextAvailableHandle);
        ServerObject._NextAvailableHandle++;
        
        AccountDTO dto = new AccountDTO(this.Handle, "", "", "");
        
        AccountDAO.AddNewAccount(dto);
        
        ServerObjectManager.RegisterObject(this);
    }

   
    
    @Override
    public  Object GetAttributeValue(String strAttributeName)
        {
            return AccountDAO.GetAttributeValue(this.Handle, strAttributeName);
        }

    @Override
        public  boolean SetAttributeValue(String strAttributeName, Object newValue)
        {
            this.NotifyAll();
            return AccountDAO.SetAttributeValue(this.Handle, strAttributeName, newValue);
        }

        @Override
        public  Object ExecuteFunction(String strFunctionName, Object param)
        {
            switch(strFunctionName)
            {
                
                case "GetAllFriendID": 
                    return GetAllFriendID();
                case "GetAllDocIDBelongToUser":
                    return GetAllDocIDBelongToUser();
            }
            
            return null;
        }
    
        
        public static Object ExecuteStaticFunction(String strFunctionName, Object param)
        {
            switch(strFunctionName)
            {
                
                case "Validate":
                    ValidateParam vp = (ValidateParam)param;
                    return Validate(vp.UserName, vp.Password);
            }
            
            return null;
        }

    private Object GetAllFriendID() {
        List<String> rs = new ArrayList<String>();
        
        rs = DocumentDAO.GetAllFriendIDBelongToAnUser(this.Handle);
        

        
        return rs.toArray(new String[rs.size()]);
    }
    
    
    public String[] GetAllDocIDBelongToUser()
    {
        List<String> rs = new ArrayList<String>();
        
        rs = DocumentDAO.GetAllDocIDBelongToAnUser(this.Handle);
        

        
        return rs.toArray(new String[rs.size()]);
    }
}
