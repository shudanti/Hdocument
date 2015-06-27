/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12123_000
 */
public class AccountDAO {
     
    
     
     public static String Validate(String userName, String password)
    {
        String kq = "";
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from account "
                + "where UserName like '"+ userName +"' and Password like '"+ password +"'");
        
        
        try {
           while(rs.next())
                {
                    
                    kq = rs.getString("ID");
                   
                } 
                rs.close();
        } catch (SQLException ex) {
            
        }
        
        return kq;
    }

    public static boolean AddNewAccount(AccountDTO dto) {
        boolean kq = false;
        
        try
        {
            DataProvider.ExecuteUpdtae("INSERT INTO Account  "
                + "values ('"+dto.ID+"','"+dto.UserName+"','"+dto.Password+"','"+dto.Email+"');");
            kq = true;
        }
        catch(Exception e)
        {
            kq = false;
        }
        return kq;
    }

  

    public static Object GetAttributeValue(String Handle, String strAttributeName) 
        {
            Object kq =null;
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from account "
                + "where AccountID like '"+ Handle +"'");
        
        
        try {
           while(rs.next())
                {
                    
                    kq = rs.getObject(strAttributeName);
                   
                } 
                rs.close();
        } catch (SQLException ex) {
            
        }
        
        return kq;
        }

    public static boolean SetAttributeValue(String Handle, String strAttributeName, Object newValue) {
        Object kq =null;
        
        return DataProvider.ExecuteUpdtae("update account set "
                + strAttributeName + "='" + newValue + "' "
                + "where AccountID like '"+ Handle +"'");
        
        
        
    }

    public static List<String> GetAllAccountID() {
        List<String> kq = new ArrayList<String>();
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from account "
               );
        
        try {
                while(rs.next())
                {
                   
                    kq.add(rs.getString("AccountID"));
                    
                    
                } 
                rs.close();
            } 
            catch (SQLException ex) 
            {
                
            }
        
        return kq;
    }
     
}
