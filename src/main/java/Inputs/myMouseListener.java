/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.GameStates;
import static main.GameStates.*;
import main.game;

/**
 *
 * @author HP
 */
public class myMouseListener implements MouseListener,MouseMotionListener{

    private game game;
    
    public myMouseListener(game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            switch (GameStates.gameStates){
                case MENU:
                    game.getMenu().mouseClicked(e.getX(),e.getY());
                    break;
                case PLAYING:
                    game.getPlaying().mouseClicked(e.getX(),e.getY());
                    break;
                case SETTINGS:
                    game.getSetting().mouseClicked(e.getX(),e.getY());
                    break;
                case END:
                    game.getEnd().mouseClicked(e.getX(),e.getY());
                    break;
                case FREEPLAY:
                    game.getFree().mouseClicked(e.getX(),e.getY());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            switch (GameStates.gameStates){
                case MENU:
                    game.getMenu().mousePressed(e.getX(),e.getY());
                    break;
                case PLAYING:
                    game.getPlaying().mousePressed(e.getX(),e.getY());
                    break;
                case SETTINGS:
                    game.getSetting().mousePressed(e.getX(),e.getY());
                    break;
                case END:
                    game.getEnd().mousePressed(e.getX(),e.getY());
                    break;
                case FREEPLAY:
                    game.getFree().mousePressed(e.getX(),e.getY());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            switch (GameStates.gameStates){
                case MENU:
                    game.getMenu().mouseReleased(e.getX(),e.getY());
                    break;
                case PLAYING:
                    game.getPlaying().mouseReleased(e.getX(),e.getY());
                    break;
                case SETTINGS:
                    game.getSetting().mouseReleased(e.getX(),e.getY());
                    break;
                case END:
                    game.getEnd().mouseReleased(e.getX(),e.getY());
                    break;
                case FREEPLAY:
                    game.getFree().mouseReleased(e.getX(),e.getY());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            switch (GameStates.gameStates){
                case MENU:
                    game.getMenu().mouseMoved(e.getX(),e.getY());
                    break;
                case PLAYING:
                    game.getPlaying().mouseMoved(e.getX(),e.getY());
                    break;
                case SETTINGS:
                    game.getSetting().mouseMoved(e.getX(),e.getY());
                    break;
                case END:
                    game.getEnd().mouseMoved(e.getX(),e.getY());
                    break;
                case FREEPLAY:
                    game.getFree().mouseMoved(e.getX(),e.getY());
                default:
                    break;
            }
        }
    }
    
}
