package TTT;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;   

public class ReversePVP extends JFrame implements ActionListener {
    private final char[][] board;
    private char currentPlayer;
    private boolean gameEnd;
    private final JButton[][] buttons;

    public ReversePVP() {
        this.board = new char[3][3];
        this.currentPlayer = 'X';
        this.gameEnd = false;
        this.buttons = new JButton[3][3];
        initializeBoard();
        createGUI();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void createGUI() {
        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        boardPanel.setBackground(Color.BLACK);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = new JButton("");
                button.setFont(new Font("Ink Free", Font.BOLD, 60));
                button.setPreferredSize(new Dimension(200, 200));
                button.addActionListener(this);
                buttons[row][col] = button;
                boardPanel.add(button);
            }
        }

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        JLabel title = new JLabel("Reversed Tic Tac");
        title.setFont(new Font("Ink Free", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Ink Free", Font.BOLD, 24));
        newGameButton.addActionListener(this);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.add(title);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(newGameButton);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Reversed Tic-Tac-Toe");
        setResizable(false);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private char getOpponent(char player) {
        return (player == 'X') ? 'O' : 'X';
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("New Game")) {
                resetGame();
            }
            if (button.getText().equals("") && !gameEnd && currentPlayer == 'X') {
                int row = -1, col = -1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (button == buttons[i][j]) {
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }
                if (row != -1 && col != -1) {
                    button.setText("X");
                    button.setForeground(Color.BLUE);
                    board[row][col] = 'X';
                    currentPlayer='O';

                    if (checkWin('X')) {
                        JOptionPane.showMessageDialog(this, "Player O wins!, Score: ");
                        gameEnd = true;
                    }
                }
            }
            
            else if (!isBoardFull()) {
            if (button.getText().equals("") && !gameEnd && currentPlayer == 'O') {
                int row = -1, col = -1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (button == buttons[i][j]) {
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }
                if (row != -1 && col != -1) {
                    button.setText("O");
                    button.setForeground(Color.RED);
                    board[row][col] = 'O';
                    currentPlayer='X';

                    if (checkWin('O')) {
                        JOptionPane.showMessageDialog(this, "Player X wins!, Score: ");
                        gameEnd = true;
                    }
                }
            }
            }
            
        }
    }



    private void resetGame() {
        initializeBoard();
        currentPlayer = 'X';
        gameEnd = false;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean checkWin(char player) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
    
    
    
    public static void main(String[] args) {
        new ReversePVP();
    }
}
