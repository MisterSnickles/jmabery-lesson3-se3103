package model;

import java.util.Random;

public class NumberGuessGame {
    
    public static final int MAX_KEY = 100;

    private int key;
    private int guess;
    private boolean showKeyOn;
    private int attempts;
    private GameState state;
    private PlayStrategy strategy;
    public String progressMessage;

    public NumberGuessGame() {
        key = -1;
        guess = -1;
        showKeyOn = false;
        attempts = 0;
        state = GameState.INIT;
        strategy = PlayStrategy.HighLow;
        
    }

    public void start() {
        key = generateNewKey();
        guess = -1;
        attempts = 0;
        progressMessage = null;
    }

    private int generateNewKey() {
        Random r = new Random();
        int newKey;
        do {
            newKey = r.nextInt(MAX_KEY + 1);
        } while (newKey == key);
        return newKey;
    }

    public void play(int guess) {
        ++attempts;
        if (strategy == PlayStrategy.HighLow) {
            playHighLow(guess);
        } else if (strategy == PlayStrategy.CloseAway) {
            playCloseAway(guess);
        }
    }

    private void playHighLow(int guess) {
        this.guess = guess;
        int diff = guess - key;
        if (diff < 0) {
            progressMessage = "Go Higher!";
        } else if (diff == 0) {
            progressMessage = "You got it! The key was " + key + "!";
        } else {
            progressMessage = "Go Lower!";
        }
    }


    private void playCloseAway(int guess) {
        int prevDiff = Math.abs(key - this.guess);
        int newDiff = Math.abs(key - guess);
        this.guess = guess;
        if (newDiff - prevDiff < 0) {
            progressMessage = "Getting Closer!";
        } else if (newDiff - prevDiff == 0) {
            progressMessage = "No Change!";
        } else {
            progressMessage = "Not Getting Closer!";

        
        }
    }



    // ------------ Getters/Setters ---------------------

    // attempts ---- get/set
    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    } // ------------------


    // strategy ---- get/set
    public PlayStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy) {
        this.strategy = strategy;
    } // --------------------


    // state ---- get/set
    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    } // -----------------


    // showKeyOn ----- get/set
    public boolean isShowKeyOn() {
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn) {
        this.showKeyOn = showKeyOn;
    } // -----------------------


    // guess ---- get/set
    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    } // -----------------


    // key ---- get
    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return String.format("key(%d) guess(%d) attempt(%d)",
                            key, guess, attempts);
    }
}


