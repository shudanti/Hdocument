/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

/**
 *
 * @author 12123_000
 */
public class DocumentDTO {
    public String ID = "";
    public String Paragragh = "";
    public String Title = "";

   

    public DocumentDTO(String Handle, String title) {
        ID = Handle;
        Title = title;
    }
}
