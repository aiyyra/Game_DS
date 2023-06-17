package Scenes;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author baest
 */
import Character.CharacterBase;
import UserInfo.PlayerAcc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import main.game;

public class leaderboardGUInew extends JPanel {
    private List<PlayerAcc> players;
    private game game;

   
    private JLabel titleLabel;
    private JPanel leaderboardPanel;
    
    public leaderboardGUInew(game game) throws ClassNotFoundException {
        players = new ArrayList<>();
        this.game = game;

        // Read player data from text file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resource/playerInfo.txt"));
            String line;
            while ((line = reader.readLine())!= null) {
                String[] userInfo = line.split(",");
                String username = userInfo[0];

                String tempPath = "resource/"+username+".dat";
                File tempfile = new File(tempPath);

                if(tempfile.exists()){
                    FileInputStream fin = new FileInputStream(tempPath);
                    ObjectInputStream Objsc = new ObjectInputStream(fin);
                    CharacterBase tempchar = (CharacterBase) Objsc.readObject();
                    players.add(new PlayerAcc(username, tempchar.getScore(), ""));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading player information.");
            e.printStackTrace();
        }
        
        
        // Sort players based on score in descending order
        Collections.sort(players, Comparator.comparingInt(PlayerAcc::getScore).reversed());

        // Create the leaderboard panel
        leaderboardPanel = new JPanel(new GridLayout(players.size() + 1, 3, 10, 10));
        leaderboardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Set the background color of the leaderboard panel
        leaderboardPanel.setBackground(new Color(255, 255, 255));

        // Add labels for column headers
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rankLabel.setHorizontalAlignment(JLabel.CENTER);
        leaderboardPanel.add(rankLabel);

        JLabel playerNameLabel = new JLabel("Player Name");
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerNameLabel.setHorizontalAlignment(JLabel.CENTER);
        leaderboardPanel.add(playerNameLabel);

        JLabel scoreLabel = new JLabel("Score");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        leaderboardPanel.add(scoreLabel);

        // Add player data
        int rank = 1;
        for (PlayerAcc player : players) {
            JLabel rankValueLabel = new JLabel(String.valueOf(rank));
            rankValueLabel.setHorizontalAlignment(JLabel.CENTER);
            leaderboardPanel.add(rankValueLabel);

            JLabel playerNameValueLabel = new JLabel(player.getUsername());
            playerNameValueLabel.setHorizontalAlignment(JLabel.CENTER);
            leaderboardPanel.add(playerNameValueLabel);

            JLabel scoreValueLabel = new JLabel(String.valueOf(player.getScore()));
            scoreValueLabel.setHorizontalAlignment(JLabel.CENTER);
            leaderboardPanel.add(scoreValueLabel);

            rank++;
        }

        
        
        titleLabel = new JLabel("LeaderBoard");
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(0, 255, 255)); // Set the background color
        titleLabel.setOpaque(true); // Make the label opaque to display the background color
        
        setLayout(new GridBagLayout()); // Use GridBagLayout as the layout manager
        GridBagConstraints gbc = new GridBagConstraints();

        // Set the constraints for the titleLabel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(titleLabel, gbc);

        // Set the constraints for the leaderboardPanel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(leaderboardPanel, gbc);
        
        setVisible(true);
    }
}
