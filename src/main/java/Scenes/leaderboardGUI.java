package Scenes;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author baest
 */
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//import java.io.BufferedReader;
//import java.io.FileReader;

public class leaderboardGUI extends JPanel {
    private List<Player> players;
   
    private JLabel titleLabel;
    private JPanel leaderboardPanel;
    private JButton button = new JButton();
    
    public leaderboardGUI() {
        //example data
        // Initialize players
        players = new ArrayList<>();
        players.add(new Player("Player 1", 5)); // Example player data
        players.add(new Player("Player 2", 7));
        players.add(new Player("Player 3", 9));
        players.add(new Player("Player 4", 6));
        players.add(new Player("Player 5", 4));
        players.add(new Player("Player 6", 1));
        players.add(new Player("Player 7", 0));
        // Add more players as needed
        
        // Read player data from text file
        //try {
            //BufferedReader reader = new BufferedReader(new FileReader("playerdata.txt"));
            //String line;
            //while ((line = reader.readLine()) != null) {
                //String[] data = line.split(",");
                //String playerName = data[0];
                //int score = Integer.parseInt(data[1]);
                //players.add(new Player(playerName, score));
            //}
            //reader.close();
        //} catch (Exception e) {
            //e.printStackTrace();
        //}
        
        
        // Sort players based on score in descending order
        Collections.sort(players, Comparator.comparingInt(Player::getScore).reversed());

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
        for (Player player : players) {
            JLabel rankValueLabel = new JLabel(String.valueOf(rank));
            rankValueLabel.setHorizontalAlignment(JLabel.CENTER);
            leaderboardPanel.add(rankValueLabel);

            JLabel playerNameValueLabel = new JLabel(player.getName());
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
        
        // Set up the frame
//        setTitle("Leaderboard ");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getContentPane().add(new JScrollPane(leaderboardPanel));
        
//        pack();
//        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        leaderboardGUI lb = new leaderboardGUI();
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(lb);
        
        
        frame.pack();
//        SwingUtilities.invokeLater(leaderboardGUI::new);
    }
   
    
    
}

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}