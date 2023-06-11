/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import UI.MyButton;
import java.awt.Color;
import java.awt.Graphics;
import main.GameStates;
import static main.GameStates.SetGameStates;
import main.game;

/**
 *
 * @author HP
 */
public class LeaderboardEnd extends GameScenes implements SceneMethod{

     
    private MyButton bQuit;

    public LeaderboardEnd(game game) {
        super(game);
        initButtons();
    }
    
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 400, 400);
        drawButton(g);
    }
    
    private void drawButton(Graphics g) {
        bQuit.draw(g);
    }
    
    private void initButtons() {
        bQuit = new MyButton("Return",400, 10, 70, 25); 
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(bQuit.getBounds().contains(x,y))
            SetGameStates(GameStates.MENU);
    }

    @Override
    public void mouseMoved(int x, int y) {
//        bMenu.setMouseOver(false);
//        if(bMenu.getBounds().contains(x,y)){
//            bMenu.setMouseOver(true);
//        }
    }

    @Override
    public void mousePressed(int x, int y) {
//        if(bMenu.getBounds().contains(x,y)){
//            bMenu.setMousePressed(true);
//        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }
    
    private void resetButtons() {
        bQuit.resetBooleans();
    }
}