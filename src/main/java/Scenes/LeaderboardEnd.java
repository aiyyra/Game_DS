/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import UI.MyButton;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import main.GameStates;
import static main.GameStates.SetGameStates;
import main.game;

/**
 *
 * @author HP
 */
public class LeaderboardEnd extends GameScenes implements SceneMethod{


    public LeaderboardEnd(game game) {
        super(game);
        
        initButtons();
    }
    
    
    public void update(game game){
        try {
            game.showBoard();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LeaderboardEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    @Override
    public void render(Graphics g) {
        g.drawRect(0, 0, 499, 999);
    }
    
    private void drawButton(Graphics g) {
    }
    
    private void initButtons() {
    }

    @Override
    public void mouseClicked(int x, int y) {
    }

    @Override
    public void mouseMoved(int x, int y) {
    }

    @Override
    public void mousePressed(int x, int y) {
    }

    @Override
    public void mouseReleased(int x, int y) {
    }
    
    private void resetButtons() {
    }
}
