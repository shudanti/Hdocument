/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.document_client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.AttributedCharacterIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author 12123_000
 */
public class JPGExporter extends Exporter{
    @Override
    public void Export(CDocument doc, String path)
    {
       
        try {
            BufferedImage bufferedImage = new BufferedImage(170, 30,
                    BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.fillRect(0, 0, 200, 50);
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
            graphics.drawString((AttributedCharacterIterator) doc.GetParagragh(), 10, 25);
            ImageIO.write(bufferedImage, "jpg", new File(
                    path + ".jpg"));
            System.out.println("Image Created");
        } catch (IOException ex) {
            Logger.getLogger(JPGExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
