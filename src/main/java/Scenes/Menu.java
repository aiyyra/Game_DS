/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import Map.FinalMap;
import UI.MyButton;
import java.awt.Color;
import java.awt.Graphics;
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
    
    private MyButton bPlaying,bSettings,bQuit,bLeaderboard;
    
    public Menu(game game) {
        super(game);
        initButtons();
    }

    @Override
    public void render(Graphics g) {
        drawButton(g);
    }

    private void drawButton(Graphics g) {
        bPlaying.draw(g);
        bSettings.draw(g);
        bQuit.draw(g);
        bLeaderboard.draw(g);
    }

    private void initButtons() {
        
        int w = 150;
        int h = w/3;
        int x = 500/2 - w/2;
        int y = 150;
        int yOffSet = 100;
        
        bPlaying = new MyButton("Play", x, y, w, h);
        bSettings = new MyButton("Settings", x,( y + yOffSet), w, h);
        bQuit = new MyButton("Quit", x, (y + yOffSet*2), w, h);
        bLeaderboard = new MyButton("Leaderboard", x, (y + yOffSet*3), w, h);
    }

    @Override
    public void mouseClicked(int x, int y) {
        
        if(bPlaying.getBounds().contains(x,y)){
            SetGameStates(GameStates.PLAYING);
        }
        if(bSettings.getBounds().contains(x,y)){
            SetGameStates(GameStates.SETTINGS);
        }
        if(bQuit.getBounds().contains(x,y)){
            System.exit(0);
        }
        if(bLeaderboard.getBounds().contains(x,y)){
            SetGameStates(GameStates.END);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(false);
        if(bPlaying.getBounds().contains(x,y)){
            bPlaying.setMouseOver(true);
        }
        bSettings.setMouseOver(false);
        if(bSettings.getBounds().contains(x,y)){
            bSettings.setMouseOver(true);
        }
        bQuit.setMouseOver(false);
        if(bQuit.getBounds().contains(x,y)){
            bQuit.setMouseOver(true);
        }
        bLeaderboard.setMouseOver(false);
        if(bLeaderboard.getBounds().contains(x,y)){
            bLeaderboard.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(bPlaying.getBounds().contains(x,y)){
            bPlaying.setMousePressed(true);
        }
        if(bSettings.getBounds().contains(x,y)){
            bSettings.setMousePressed(true);
        }
        if(bQuit.getBounds().contains(x,y)){
            bQuit.setMousePressed(true);
        }
        if(bLeaderboard.getBounds().contains(x,y)){
            bLeaderboard.setMousePressed(true);
        }
        
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlaying.resetBooleans();
        bSettings.resetBooleans();
        bQuit.resetBooleans();
        bLeaderboard.resetBooleans();
    }

    
    public void mouseDragged(int x, int y) {

    }
    
    
    
}
