/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Map.FinalMap;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author HP
 */
public class Render {
    
    private game game;
    public Render(game game){
        this.game=game;
    }
    
    public void render(Graphics g){
        
        switch(GameStates.gameStates){
            case MENU:
                game.getMenu().render(g);
                break;
            case PLAYING:
                game.getPlaying().render(g);
                break;
            case SETTINGS:
                game.getSetting().render(g);
                break;
            
        }
    }
}
