/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInfo;

/**
 *
 * @author HP
 */

import Character.CharacterBase;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.game;

public class saveGame {
    
    game game;
    static CharacterBase savechar;
    static CharacterBase newChar =null;
    static String name;
    static String path;

    public saveGame(game game) {
        this.game = game;
        this.savechar = game.getPlaying().getCharacterManager().testChar;
        name  = game.getUsername();
        path  = "resource/"+name+".dat";
    }
    
    
    
    public static void save(){
        try{
            FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream Objwriter = new ObjectOutputStream(fout);
            Objwriter.writeObject(savechar);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static CharacterBase loadgame(){
        
        try{
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream Objread = new ObjectInputStream(fin);
            newChar = (CharacterBase) Objread.readObject();
            return newChar;
            
        }catch(IOException e){
            System.out.println(e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(saveGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
