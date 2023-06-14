/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import UI.MyButton;
import UserInfo.saveGame;
import java.awt.Color;
import java.awt.Graphics;
import main.GameStates;
import static main.GameStates.SetGameStates;
import main.game;

/**
 *
 * @author HP
 */
public class Setting extends GameScenes implements SceneMethod{
    
    private MyButton bMenu;
    private MyButton bSaveQuit;

    public Setting(game game) {
        super(game);
        initButtons();
    }
    
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 400, 400);
        drawButton(g);
    }
    
    private void drawButton(Graphics g) {
        bMenu.draw(g);
        bSaveQuit.draw(g);
    }
    
    private void initButtons() {
        bMenu = new MyButton("Resume",400, 10, 70, 25); 
        bSaveQuit = new MyButton("Save and Quit", 200,400,100,35);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            SetGameStates(GameStates.PLAYING);
        }
        if(bSaveQuit.getBounds().contains(x,y)){
            // to be add
            saveGame.save();
            SetGameStates(GameStates.MENU);
            System.out.println("saved");
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMouseOver(true);
        }
        bSaveQuit.setMouseOver(false);
        if(bSaveQuit.getBounds().contains(x,y)){
            bSaveQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMousePressed(true);
        }
        if(bSaveQuit.getBounds().contains(x,y)){
            bSaveQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }
    
    private void resetButtons() {
        bMenu.resetBooleans();
        bSaveQuit.resetBooleans();
    }
}
