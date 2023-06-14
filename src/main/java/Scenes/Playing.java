/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scenes;

import Character.CharacterBase;
import TTT.*;
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
    private int [][] spath;
    private TileManager tileManager;
    private MyButton bMenu;
    private CharacterManager characterManager;
    private boolean TicTacToeStatus;
    private boolean lossTicTacToe=false;
    private int level =1;
    private boolean endgame =false;
    
    public Playing(game game) {
        super(game);
        
        map = LevelBuilder.getLevelData();
        spath = LevelBuilder.getshortpath();
        tileManager = new TileManager();
        
        characterManager = new CharacterManager(this);
        
        initButtons();
        //map
        //tile
    }
    
    public void update(){
        characterManager.Update();
        if(lossTicTacToe){
            System.out.println("loss ttt");
            
            characterManager.respawn();
            setLossTicTacToe(false);
        }
        if(getTicTacToeStatus()){
            generateTicTacToe(level);
            setTicTacToeStatus(false);
        }
        if(endgame){
            System.out.println("hai");
            GameStates.SetGameStates(GameStates.END);
            setEndgame(false);
        }
    }
    
    @Override
    public void render(Graphics g) {
        
        drawtiles(g);
        drawSPath(g);
        drawButton(g);
        characterManager.Draw(g);
    }
    
    private void drawtiles(Graphics g){
        for(int y =0;y<map.length;y++){
            for(int x=0;x<map[y].length;x++){
                int id = map[y][x];
                g.setColor(tileManager.getColor(id));
                g.fillRect(y*tilesSize, x*tilesSize, tilesSize, tilesSize);
            }
        }
    }
    
    private void drawSPath(Graphics g){
        for(int x=0;x<spath.length;x++){
            for(int y=0;y<spath[0].length;y++){
                if(spath[x][y]==1){
                    g.setColor(Color.blue);
                    g.fillOval(y*tilesSize+14, x*tilesSize+14, 5, 5);
                }
                
            }
        }
    }
    
    private void drawButton(Graphics g) {
        bMenu.draw(g);
    }
    
    private void initButtons() {
        bMenu = new MyButton("Pause",400, 10, 70, 25); 
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            SetGameStates(GameStates.SETTINGS);
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
    
    public void load() {
        this.characterManager.testChar = (CharacterBase) game.getSaver().loadgame();
    }
    
    
    private void generateTicTacToe(int level){
        
        int i = new java.util.Random().nextInt(1,6);
        switch (i) {
            case 1,4:new TTT5x5(level,this);
                break;
            case 2,5:new ReversedTTT(level,this);
                break;
            case 3,6:new TTTtreble(12);//TTTtreble(12,this);
                break;
        }
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

    public void setLossTicTacToe(boolean lossTicTacToe) {
        this.lossTicTacToe = lossTicTacToe;
    }

    
    
    public void setLevel(int level) {
        this.level = level;
    }

    public void setEndgame(boolean endgame) {
        this.endgame = endgame;
    }

    
    
    
}
