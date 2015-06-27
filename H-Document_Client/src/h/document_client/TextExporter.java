/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12123_000
 */
public class TextExporter extends Exporter{
    @Override
    public void Export(CDocument doc, String path)
    {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path + doc.GetTitle() + ".txt", "UTF-8");
            writer.println(doc.GetParagragh());
          
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextExporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TextExporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
}
