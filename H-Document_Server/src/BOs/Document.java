/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import DataAccess.AccountDAO;
import DataAccess.DocumentDAO;
import DataAccess.DocumentDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 12123_000
 */
public class Document extends ServerObject{
     //public AttributeList attributes = new AttributeList();
     
    
     
    

    static List<ServerObject> GetAllDocument() {
        List<ServerObject> rs = new ArrayList<ServerObject>();
        
        List<String> documentID = DocumentDAO.GetAllDocumentID();
        
        for(String s : documentID)
        {
            rs.add(new Document(s));
        }
        
        return rs;
    }

    private Object RegisterToDocument(String string) {
        
        DocumentDAO.RegisterToDocument(this.Handle, string);
        
        return null;
    }
    
     
     private Document(String handle)
     {
         this.Handle = handle;
     }

    //private Document(DocumentDTO documentDTO) {
        
        
     //   this.Handle = documentDTO.ID;
     //   attributes.AddAttribute(new Attribute("Title", "String", documentDTO.Title));
     //   attributes.AddAttribute(new Attribute("Paragragh", "String", documentDTO.Paragragh)); 
     //   ServerObjectManager.RegisterObject(this);
    //}

    public Document() {
        this.Handle = String.valueOf(ServerObject._NextAvailableHandle);
        ServerObject._NextAvailableHandle++;
        
         DocumentDTO dto = new DocumentDTO(this.Handle ,"");
         
         DocumentDAO.AddNewDocument(dto);
         
    
         
         ServerObjectManager.RegisterObject(this);
    }

    
     
     
     
     
      @Override
    public  Object GetAttributeValue(String strAttributeName)
        {
            return DocumentDAO.GetAttributeValue(this.Handle, strAttributeName);
        }

    @Override
        public  boolean SetAttributeValue(String strAttributeName, Object newValue)
        {
            //this.NotifyAll();
            return DocumentDAO.SetAttributeValue(this.Handle, strAttributeName, newValue);
        }

        @Override
        public  Object ExecuteFunction(String strFunctionName, Object param)
        {
            switch(strFunctionName)
            {
                case "GetAllChangeHistory":
                    return GetAllChangeHistory();
                case "AddHistoryChange":
                    return AddHistoryChange(param);
                case "RegisterToDocument":
                    return RegisterToDocument((String)param);
            }
            return null;
        }
        
         public static Object ExecuteStaticFunction(String strFunctionName, Object param)
        {
            switch(strFunctionName)
            {
                
                
                
            }
            
            return null;
        }

    private Object AddHistoryChange(Object param) {
        
        String date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "-" 
                + Calendar.getInstance().get(Calendar.MONTH) + "-" 
                + Calendar.getInstance().get(Calendar.YEAR);
        DocumentDAO.AddHistoryChange(this.Handle, param + " has change the document.", date);
        return null;
    }

    private Object GetAllChangeHistory() {

        return DocumentDAO.GetAllChangeHistory(this.Handle);
    }
}
