package test;

import model.NumberGuessGame;

public class GameTester {
    
    public static void main(String[] args) {

        NumberGuessGame game = new NumberGuessGame();
        game.start();
        System.out.println("" + game);

        game.play(50);
        System.out.println(game);
        System.out.println(game.progressMessage);

        game.play(30);
        System.out.println(game);
        System.out.println(game.progressMessage);
    }
}
