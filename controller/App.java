package controller;
import javax.swing.JFrame;

import model.NumberGuessGame;
import view.AppWindow;

public class App {
    public static final AppWindow win = new AppWindow();
    public static final NumberGuessGame game = new NumberGuessGame();

    public static void main(String[] args) {

        win.init();
        win.setTitle("Number Guess Game");
        win.setLocation(300,200);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        win.pack();
        win.setVisible(true);
    }
}
