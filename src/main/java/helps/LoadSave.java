/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helps;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */


public class LoadSave {
    
    public static Color getColor;
    public static BufferedImage getSpriteAtlas(){
        BufferedImage img = null;
        File imagefile = new File("resource/resizetiles.png");
        
        try{
            img = ImageIO.read(imagefile);
        }catch(IOException e){
            e.printStackTrace();
        }
        return img;
    }
    
}
