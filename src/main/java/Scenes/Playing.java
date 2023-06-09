/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import TTT.*;
import Character.player;
import Manager.CharacterManager;
import Manager.TileManager;
import UI.MyButton;
import helps.LevelBuilder;
import java.awt.Color;
import java.awt.Graphics;
import main.GameStates;
import static main.GameStates.SetGameStates;
import main.game;

/**
 *
 * @author HP
 */
public class Playing extends GameScenes implements SceneMethod{

    private int tilesSize =25;
    private int[][] map;
    private TileManager tileManager;
    private MyButton bMenu;
    private player player;
    private CharacterManager characterManager;
    private boolean TicTacToeStatus;
    
    public Playing(game game) {
        super(game);
        
        map = LevelBuilder.getLevelData();
        tileManager = new TileManager();
        player = game.getPlayer();
        
        characterManager = new CharacterManager(this);
//                game.getCharacter();
        
        initButtons();
        //map
        //tile
    }
    
    public void update(){
        characterManager.Update();
        if(getTicTacToeStatus()){
            new TTT5x5();
            setTicTacToeStatus(false);
        }
    }
    
    @Override
    public void render(Graphics g) {
        for(int y =0;y<map.length;y++){
            for(int x=0;x<map[y].length;x++){
                int id = map[y][x];
                g.setColor(tileManager.getColor(id));
                g.fillRect(y*tilesSize, x*tilesSize, tilesSize, tilesSize);
            }
        }
//        if(false)update();
        drawButton(g);
        drawPlayer(player,g);
        characterManager.Draw(g);
    }
    
    public void drawPlayer(player player,Graphics g){
        int x =(int) player.getX();
        int y = (int)player.getY();
        //fill border
        g.setColor(Color.black);
        g.drawOval(x, y, 18, 18);
        //fill in
        g.setColor(Color.pink);
        g.fillOval(x, y, 18, 18);
    }
    
    private void drawButton(Graphics g) {
        bMenu.draw(g);
    }
    
    private void initButtons() {
        bMenu = new MyButton("Menu",400, 10, 70, 25); 
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            SetGameStates(GameStates.MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMouseOver(true);
        }
        
    }

    @Override
    public void mousePressed(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bMenu.resetBooleans();
    }

    public int getTilesSize() {
        return tilesSize;
    }

    public int[][] getMap() {
        return map;
    }

    public CharacterManager getCharacterManager() {
        return characterManager;
    }

    public void setTicTacToeStatus(boolean TicTacToeStatus) {
        this.TicTacToeStatus = TicTacToeStatus;
    }

    public boolean getTicTacToeStatus(){
        return this.TicTacToeStatus;
    }
    
    
    
    
}
