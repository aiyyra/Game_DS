/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author HP
 */
public class MyButton {
    private int x,y,width,height;
    private String text;
    
    private Rectangle bounds;
    private boolean mouseOver,mousePressed;

    public MyButton(String text,int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        initBounds();
    }

    private void initBounds(){
        this.bounds = new Rectangle(x,y,width,height);
    }
    
   public void draw(Graphics g){
       //body
       drawBody(g);
       //border
       drawBorder(g);
       //text
       drawText(g);
   }
   
   public void drawText(Graphics g){
       int w = g.getFontMetrics().stringWidth(text);
       int h = g.getFontMetrics().getHeight();
       g.drawString(text, (x-(w/2)+(width/2)), (y+(h/2)+(height/2)));
   }
   
    public void resetBooleans(){
        this.mouseOver=false;
        this.mousePressed=false;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    
    public Rectangle getBounds() {
        return bounds;
    }

    private void drawBody(Graphics g) {
        
        if(mouseOver)
            g.setColor(Color.GRAY);
        else
            g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        if(mousePressed){
            g.drawRect(x+1, y+1, width-2, height-2);
            g.drawRect(x+2, y+2, width-4, height-4);
        }else{
            g.setColor(Color.black);
            g.drawRect(x, y, width, height);
        }
        
    }
   
   
    
}
