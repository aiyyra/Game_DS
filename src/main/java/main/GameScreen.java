/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Inputs.KeyBoardListener;
import Inputs.myMouseListener;
import Map.FinalMap;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 *
 * @author HP
 */
public class GameScreen extends JPanel{

    
    private int PIXEL_SIZE = 25;

    private myMouseListener myMouseListener;
    private KeyBoardListener keyBoardsListener;
    
    private game game;
    private Dimension size;
    
    public GameScreen(game game) {
        
        this.game = game;
        setPanelSize();
    }
    
    public void initInputs(){
        myMouseListener = new myMouseListener(game);
        keyBoardsListener = new KeyBoardListener(game);
        
        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyBoardsListener);
        
        requestFocus();
    }
    
    public void setPanelSize(){
        size = new Dimension(PIXEL_SIZE*20,PIXEL_SIZE*40);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.getRender().render(g);
    }
    
    public int getPIXEL_SIZE() {
        return PIXEL_SIZE;
    }
    
}
