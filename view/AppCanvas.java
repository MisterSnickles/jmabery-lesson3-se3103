package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.App;
import model.NumberGuessGame;

public class AppCanvas extends JPanel {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;
    
    public AppCanvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch (App.game.getState()) {
            case INIT:
                drawInitCanvas(g2);
                break;
            case PLAYING:
                drawPlayingCanvas(g2);
                break;
            case OVER:
                drawOverCanvas(g2);
                break;
        }
    }

    private void drawOverCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        var message_1 = String.format("%d is correct! (Attempts = %d)",
            App.game.getKey(), App.game.getAttempts()
        );
        var message_2 = "Press <New Game> to play again.";
        g2.drawString(message_1, 50, 100);
        g2.drawString(message_2, 50, 150);

    }

    private void drawPlayingCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        NumberGuessGame game = App.game;

        if (game.isShowKeyOn()) {
            var keyString = String.format("Key: %d", game.getKey());
            g2.drawString(keyString, 50, 50);
        }

        String promptString;
        if (game.getGuess() >= 0) {
            promptString = String.format("Your Guess: %d (Attempts: %d)", game.getGuess(), game.getAttempts());
        } else {
            promptString = "Enter your guess";
        }
        g2.drawString(promptString, 50, 150);

        if (game.progressMessage != null) {
            g2.drawString(game.progressMessage, 100, 200);
        }
    }

    private void drawInitCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
       var message = "Press <New Game> to start!";
       g2.drawString(message, 50, 150);
    }
}
