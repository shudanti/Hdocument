/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import BOs.CreateDocumentParam;

/**
 *
 * @author 12123_000
 */
public class CDocument extends ClientObject{
    
    public CDocument(String title, String paragragh)
    {
        
        
        this.Handle = ClientObjectManager.CreateNewObject("Document");
        ClientObjectManager.SetAttributeValue(Handle, "Title", title);
        ClientObjectManager.SetAttributeValue(Handle, "Paragragh", paragragh);
        ClientObjectManager.AddBindingInfor(Handle);
    }
    
    public CDocument(String handle)
    {
        this.Handle = handle;
        ClientObjectManager.AddBindingInfor(Handle);
    }
   
    
    public void SetTitle(String newTitle)
    {
        ClientObjectManager.SetAttributeValue(Handle, "Title", newTitle);
    }
    
    public String GetTitle()
    {
        return (String)ClientObjectManager.GetAttributeValue(Handle, "Title");
    }
    
    public void SetParagragh(String newParagragh)
    {
        ClientObjectManager.SetAttributeValue(Handle, "Paragragh", newParagragh);
    }
    
    public String GetParagragh()
    {
        return (String)ClientObjectManager.GetAttributeValue(Handle, "Paragragh");
    }
    
}
