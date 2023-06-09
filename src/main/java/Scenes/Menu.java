/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import Map.FinalMap;
import UI.MyButton;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import main.GameStates;
import static main.GameStates.*;
import main.game;

/**
 *
 * @author HP
 */
public class Menu extends GameScenes implements SceneMethod{

    private int[][] map = new FinalMap().getFin();
    private int PIXEL_SIZE = 25;
    Image icon =new ImageIcon("resource/Suzumegif.gif").getImage();
    
    private MyButton bPlaying,bload,bQuit,bLeaderboard,bFree;
    
    public Menu(game game) {
        super(game);
        initButtons();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(icon, 0, 0, 500, 1000, null);
        drawButton(g);
    }
    
    private void drawButton(Graphics g) {
        bPlaying.draw(g);
        bload.draw(g);
        bFree.draw(g);
        bLeaderboard.draw(g);
        bQuit.draw(g);
        g.drawRect(0, 0, 499, 999);
        
    }

    private void initButtons() {
        
        int w = 150;
        int h = w/3;
        int x = 500/2 - w/2;
        int y = 350;
        int yOffSet = 100;
        
        bPlaying = new MyButton("Play", x, y, w, h);
        bload = new MyButton("Load Game", x,( y + yOffSet), w, h);
        bFree = new MyButton("Free Play", x, (y + yOffSet*2), w, h);
        bLeaderboard = new MyButton("Leaderboard", x, (y + yOffSet*3), w, h);
        bQuit = new MyButton("Exit Game", x, (y + yOffSet*4), w, h);
        
    }

    @Override
    public void mouseClicked(int x, int y) {
        
        if(bPlaying.getBounds().contains(x,y)){
            SetGameStates(GameStates.PLAYING);
        }
        if(bload.getBounds().contains(x,y)){
            System.out.println("Loading");
            game.getPlaying().load();
            SetGameStates(GameStates.PLAYING);
        }
        if(bQuit.getBounds().contains(x,y)){
            System.exit(0);
        }
        if(bLeaderboard.getBounds().contains(x,y)){
            SetGameStates(GameStates.END);
        }
        if(bFree.getBounds().contains(x,y)){
            SetGameStates(GameStates.FREEPLAY);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(false);
        if(bPlaying.getBounds().contains(x,y)){
            bPlaying.setMouseOver(true);
        }
        bload.setMouseOver(false);
        if(bload.getBounds().contains(x,y)){
            bload.setMouseOver(true);
        }
        bQuit.setMouseOver(false);
        if(bQuit.getBounds().contains(x,y)){
            bQuit.setMouseOver(true);
        }
        bLeaderboard.setMouseOver(false);
        if(bLeaderboard.getBounds().contains(x,y)){
            bLeaderboard.setMouseOver(true);
        }
        bFree.setMouseOver(false);
        if(bFree.getBounds().contains(x,y)){
            bFree.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(bPlaying.getBounds().contains(x,y)){
            bPlaying.setMousePressed(true);
        }
        if(bload.getBounds().contains(x,y)){
            bload.setMousePressed(true);
        }
        if(bQuit.getBounds().contains(x,y)){
            bQuit.setMousePressed(true);
        }
        if(bLeaderboard.getBounds().contains(x,y)){
            bLeaderboard.setMousePressed(true);
        }
        if(bFree.getBounds().contains(x,y)){
            bFree.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlaying.resetBooleans();
        bload.resetBooleans();
        bQuit.resetBooleans();
        bLeaderboard.resetBooleans();
        bFree.resetBooleans();
    }

    
    public void mouseDragged(int x, int y) {

    }
    
    
    
}
