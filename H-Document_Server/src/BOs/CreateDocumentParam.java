/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import java.io.Serializable;

/**
 *
 * @author 12123_000
 */
public class CreateDocumentParam extends Param implements Serializable{
    public String Title;

    public CreateDocumentParam(String title) {
        Title = title;
    }

    
}
