/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInfo;

import java.io.*;

public class PlayerAcc {
    private String username;
    private String password;
    private int score;
    private int xPlayer;
    private int yPlayer;

    public PlayerAcc(String name, int score, String password,int xPlayer,int yPlayer) {
        this.username = name;
        this.score = score;
        this.password = password;
        this.xPlayer=xPlayer;
        this.yPlayer= yPlayer;
    }

    public int getxPlayer() {
        return xPlayer;
    }

    public void setxPlayer(int xPlayer) {
        this.xPlayer = xPlayer;
    }

    public int getyPlayer() {
        return yPlayer;
    }

    public void setyPlayer(int yPlayer) {
        this.yPlayer = yPlayer;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
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

    }

