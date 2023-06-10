/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author HP
 */
public enum GameStates {
    PLAYING,MENU,SETTINGS;
    
    public static GameStates gameStates = PLAYING;
    
    public static void SetGameStates(GameStates state){
        gameStates=state;
    }
}
