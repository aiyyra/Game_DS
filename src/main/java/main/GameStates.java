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
    PLAYING,MENU,SETTINGS,END;
    
    public static GameStates gameStates = MENU;
    
    public static void SetGameStates(GameStates state){
        gameStates=state;
    }
}
