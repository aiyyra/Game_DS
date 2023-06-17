/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import Map.FinalMap;
import UI.MyButton;
import java.awt.Graphics;
import TTT.*;
import main.game;

/**
 *
 * @author HP
 */
public class FreePlay extends GameScenes implements SceneMethod{

    private int[][] map = new FinalMap().getFin();
    private int PIXEL_SIZE = 25;
    
    private MyButton bNormal,bReverse,b5x5;
    
    public FreePlay(game game) {
        super(game);
        initButtons();
    }

    @Override
    public void render(Graphics g) {
        drawButton(g);
    }

    private void drawButton(Graphics g) {
        bNormal.draw(g);
        bReverse.draw(g);
        b5x5.draw(g);
        
    }

    private void initButtons() {
        
        int w = 150;
        int h = w/3;
        int x = 500/2 - w/2;
        int y = 150;
        int yOffSet = 100;
        
        bNormal = new MyButton("Normal TTT", x, y, w, h);
        bReverse = new MyButton("Reverse TTT", x,( y + yOffSet), w, h);
        b5x5 = new MyButton("5x5 TTT", x, (y + yOffSet*2), w, h);
        
    }

    @Override
    public void mouseClicked(int x, int y) {
        
        if(bNormal.getBounds().contains(x,y)){
            System.out.println("norm");
            new TTTnormal();
        }
        if(bReverse.getBounds().contains(x,y)){
            System.out.println("reverse");
            new ReversePVP();
        }
        if(b5x5.getBounds().contains(x,y)){
            System.out.println("5x5");
            new TTT5x5();
//            new TTT5x5(tgokbalik);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bNormal.setMouseOver(false);
        if(bNormal.getBounds().contains(x,y)){
            bNormal.setMouseOver(true);
        }
        bReverse.setMouseOver(false);
        if(bReverse.getBounds().contains(x,y)){
            bReverse.setMouseOver(true);
        }
        b5x5.setMouseOver(false);
        if(b5x5.getBounds().contains(x,y)){
            b5x5.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(bNormal.getBounds().contains(x,y)){
            bNormal.setMousePressed(true);
        }
        if(bReverse.getBounds().contains(x,y)){
            bReverse.setMousePressed(true);
        }
        if(b5x5.getBounds().contains(x,y)){
            b5x5.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bNormal.resetBooleans();
        bReverse.resetBooleans();
        b5x5.resetBooleans();
    }

    
    public void mouseDragged(int x, int y) {

    }
    
}