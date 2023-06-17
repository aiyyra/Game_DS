/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import page.Exit_n_leaderboard;
import Inputs.*;
import Manager.CharacterManager;
import Scenes.*;
import javax.swing.JFrame;
import static main.GameStates.*;
import Scenes.leaderboardGUInew;
import UserInfo.saveGame;

/**
 *
 * @author HP
 */
public class game extends JFrame implements Runnable{
    
    private String username;
    private GameScreen gameScreen;
    private Thread gameThread;
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;
    
    //classes
    private Render render;
    private Menu menu;
    private static Playing playing;
    private Setting setting;
    private LeaderboardEnd end;
    private FreePlay free;
    private leaderboardGUInew board;
    private static saveGame saver;
       
    public game(String username) throws ClassNotFoundException {
        
        this.username = username;
        initClasses();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(gameScreen);
        
        pack();
        setVisible(true);
    }
    
    
    
    public void start(){
        gameThread = new Thread(this){
        };
        gameThread.start();
    }
    
    private void updateGame() {
        switch (GameStates.gameStates) {
            case MENU:
                 break;
            case PLAYING:
                playing.update();
                 break;
            case SETTINGS:
                 break;
            case FREEPLAY:
                 break;
            case END:
                end.update(this);
                break;
            default:
                break; 
        }
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        
        long lastUpdate = System.nanoTime();
        long lastFrame = System.nanoTime();
        long lastTimeCheck=System.currentTimeMillis();
        
        int frames=0;
        int updates =0;
        
        long now;
        
        
        while(true){
            now = System.nanoTime();
            //render
            if(now - lastFrame >= timePerFrame){
                repaint();
                lastFrame = System.nanoTime();
                frames++;
            }
            //Update
            if(now - lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = System.nanoTime();
                updates++;
            }
            
            if(System.currentTimeMillis() - lastTimeCheck >= 1000){
                System.out.println("FPS = "+ frames + " | UPS = "+updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }

    
    public static void main(String[] args) throws ClassNotFoundException {
        game game = new game("afiq");
        SoundHandler.RunMusic("resource/suzume_instrument.wav");
        game.gameScreen.initInputs();
        game.start();
    }

    private void initClasses() throws ClassNotFoundException {
        render = new Render(this);
        gameScreen=new GameScreen(this);
        menu = new Menu(this);
        playing = new Playing(this);
        setting = new Setting(this);
        end = new LeaderboardEnd(this);
        free = new FreePlay(this);
        board = new leaderboardGUInew(this);
        saver = new saveGame(this);
        
    }
    
    public void showBoard() throws ClassNotFoundException{
        board = new leaderboardGUInew(this);
        getGameScreen().setVisible(false);
        board.setVisible(true);
        this.add(board);
    }
    
    public void loadGame(){
        
    }
    

    //getter setter
    
    public String getUsername() {
        return username;
    }

    public Render getRender() {
        return render;
    }
    
    public Menu getMenu() {
        return menu;
    }

    public static Playing getPlaying() {
        return playing;
    }

    public Setting getSetting() {
        return setting;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public LeaderboardEnd getEnd() {
        return end;
    }

    public static saveGame getSaver() {
        return saver;
    }

    public FreePlay getFree() {
        return free;
    }
    
    
    

}
