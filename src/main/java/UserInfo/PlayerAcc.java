/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInfo;

import java.io.*;
import java.util.Scanner;

public class PlayerAcc {
    private String username;
    private String password;
    private int score;

    public PlayerAcc(String name, int score, String password) {
        this.username = name;
        this.password = password;
        this.score = score;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public boolean authenticatePlayer(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resource/playerInfo.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(",");
                String savedUsername = userInfo[0];
                String savedPassword = userInfo[1];
                if (savedUsername.equals(username) && savedPassword.equals(password)) {
                    reader.close();
                    return true; // Authentication successful
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading player information.");
            e.printStackTrace();
        }
        return false; // Authentication failed
    }

    public static void saveGame(String username){
        String path = "resource/"+username+".dat";
    }
    
}

