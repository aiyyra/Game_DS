/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author HP
 */
public class Tile {
    
    private BufferedImage sprite;
    
    private Color color;
    private int val;

    public Tile(Color color,int val) {
        this.color = color;
        this.val = val;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getVal() {
        return val;
    }
    
    public Tile(BufferedImage sprite){
        this.sprite = sprite;
    }
    
    public BufferedImage getSprite() {
        return sprite;
    }
    

    
    
    //can change all the tiles to picture
    
    //not sure about this one
//    public int[][] getMaparray() {
//        return maparray;
//    }
//    //tgok balik
//    public Tile(int[][] maparray) {
//        this.maparray = maparray;

    

    

    
    

}
