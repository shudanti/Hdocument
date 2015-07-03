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
public class DocumentDAO {
    
    
    
    public static boolean AddNewDocument(DocumentDTO dto)
    {
        boolean kq = false;
        
        try
        {
            kq = DataProvider.ExecuteUpdtae("INSERT INTO document  "
                + "values ('"+dto.ID+"','" + dto.Title+"','" + dto.Paragragh+"')");
            
        }
        catch(Exception e)
        {
            kq = false;
        }
        return kq;
    }
    
    public static List<String> GetAllDocIDBelongToAnUser(String userID)
    {
        List<String> kq = new ArrayList<String>();
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from account_document "
                + "where AccountID like '"+ userID +"' ");
        
        try {
                while(rs.next())
                {
                   
                    kq.add(rs.getString("DocumentID"));
                    
                    
                } 
                rs.close();
            } 
            catch (SQLException ex) 
            {
                
            }
        
        return kq;
    }

    public static Object GetAttributeValue(String Handle, String strAttributeName) {
        Object kq =null;
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from document "
                + "where ID like '"+ Handle +"'");
        
        
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

                return DataProvider.ExecuteUpdtae("update document set "
                        + strAttributeName + "='" + newValue + "' "
                        + "where ID like '"+ Handle +"'");    
    }

    

    public static List<String> GetAllDocumentID() {
        List<String> kq = new ArrayList<String>();
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from document "
               );
        
        try {
                while(rs.next())
                {
                   
                    kq.add(rs.getString("ID"));
                    
                    
                } 
                rs.close();
            } 
            catch (SQLException ex) 
            {
                
            }
        
        return kq;
    }

    public static void RegisterToDocument(String Handle, String string) {
          DataProvider.ExecuteUpdtae("INSERT INTO account_document  "
                + "values ('"+string+ "','"  + Handle +"')");  
    }

    public static List<String> GetAllFriendIDBelongToAnUser(String Handle) {
        List<String> kq = new ArrayList<String>();
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from friend "
                + "where AccountID1 like '"+ Handle +"' ");
        
        try {
                while(rs.next())
                {
                   
                    kq.add(rs.getString("AccountID2"));
                    
                    
                } 
                rs.close();
            } 
            catch (SQLException ex) 
            {
                
            }
        
        return kq;
    }

    public static void AddHistoryChange(String Handle, String comment, String date) {
        DataProvider.ExecuteUpdtae("INSERT INTO document_history  "
                + "values ('"+Handle+ "','"  + comment + "','"  + date + "')");  
    }

    public static Object GetAllChangeHistory(String Handle) {
        String kq = "";
        
        ResultSet rs = DataProvider.ExecuteSelect("select * from document_history "
                + "where DocumentID like '"+ Handle +"' ");
        
        try {
                while(rs.next())
                {
                   
                    kq += "\r\n" + rs.getString("Comment") + " at " + rs.getString("Date");
                    
                    
                } 
                rs.close();
            } 
            catch (SQLException ex) 
            {
                
            }
        
        return kq;
    }
}
