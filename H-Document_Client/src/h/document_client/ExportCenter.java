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
public class ExportCenter {
    List<Exporter> exporters;
    
    public ExportCenter()
    {
        exporters = new ArrayList<Exporter>();
        exporters.add(new TextExporter());
        exporters.add(new JPGExporter());
    }
    
    public void Export(String type, CDocument doc, String path)
    {
        switch(type)
        {
            case "Text":
                exporters.get(0).Export(doc, path);
                break;
            case "JPG":
                exporters.get(0).Export(doc, path);
                break;
        }
    }
}
