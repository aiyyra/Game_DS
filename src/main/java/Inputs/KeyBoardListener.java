/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inputs;

import Character.CharacterBase.Move;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GameStates;
import static main.GameStates.*;
import main.game;
import Manager.CharacterManager;


/**
 *
 * @author HP
 */
public class KeyBoardListener implements KeyListener{

    game game;
    public KeyBoardListener(game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (GameStates.gameStates){
                case MENU:
                    break;
                case PLAYING:
                    if(e.getKeyCode()==KeyEvent.VK_A)
                        game.getPlaying().getCharacterManager().goleft();
                    else if(e.getKeyCode()==KeyEvent.VK_S)
                        game.getPlaying().getCharacterManager().godown();
                    else if(e.getKeyCode()==KeyEvent.VK_D)
                        game.getPlaying().getCharacterManager().goright();
                    else if(e.getKeyCode()==KeyEvent.VK_W)
                        game.getPlaying().getCharacterManager().goup();
                    // will remove later
                    else if(e.getKeyCode()==KeyEvent.VK_SPACE)
                        game.getPlaying().getCharacterManager().respawn();
                    break;
                case SETTINGS:
                    break;
                case END:
                    break;
                default:
                    break;
            }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
