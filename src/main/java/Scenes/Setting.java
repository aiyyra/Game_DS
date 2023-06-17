/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import UI.MyButton;
import UserInfo.saveGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GameStates;
import static main.GameStates.SetGameStates;
import main.game;

/**
 *
 * @author HP
 */
public class Setting extends GameScenes implements SceneMethod{
    
    private MyButton bResume;
    private MyButton bSaveQuit,bQuit;

    public Setting(game game) {
        super(game);
        initButtons();
    }
    
    public static BufferedImage getBG(){
        BufferedImage img = null;
        File imagefile = new File("resource/SuzuPause.jpg");
        
        try{
            img = ImageIO.read(imagefile);
        }catch(IOException e){
            e.printStackTrace();
        }
        return img;
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getBG(), 0, 0, 500, 1000, null);
        drawButton(g);
        g.drawRect(0, 0, 499, 999);
    }
    
    private void drawButton(Graphics g) {
        bResume.draw(g);
        bSaveQuit.draw(g);
        bQuit.draw(g);
    }
    
    private void initButtons() {
        bResume = new MyButton("Resume",400, 10, 70, 25); 
        bSaveQuit = new MyButton("Save and Quit", 200,525,100,35);
        bQuit = new MyButton("Quit",200,675,100,35);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(bResume.getBounds().contains(x,y)){
            SetGameStates(GameStates.PLAYING);
        }
        if(bSaveQuit.getBounds().contains(x,y)){
            // to be add
            saveGame.save();
            SetGameStates(GameStates.MENU);
        }
        if(bQuit.getBounds().contains(x,y)){
            SetGameStates(GameStates.MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bResume.setMouseOver(false);
        if(bResume.getBounds().contains(x,y)){
            bResume.setMouseOver(true);
        }
        bSaveQuit.setMouseOver(false);
        if(bSaveQuit.getBounds().contains(x,y)){
            bSaveQuit.setMouseOver(true);
        }
        bQuit.setMouseOver(false);
        if(bQuit.getBounds().contains(x,y)){
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(bResume.getBounds().contains(x,y)){
            bResume.setMousePressed(true);
        }
        if(bSaveQuit.getBounds().contains(x,y)){
            bSaveQuit.setMousePressed(true);
        }
        if(bQuit.getBounds().contains(x,y)){
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }
    
    private void resetButtons() {
        bResume.resetBooleans();
        bSaveQuit.resetBooleans();
        bQuit.resetBooleans();
    }
}
