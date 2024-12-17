package Main;

// File: src/Main.java

import tebakKata.HangmanGame;  // Import HangmanGame class from tebakKata package
import game.Game;              // Import Game class from game package

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Project UAS PBO ===");
        // Polymorphism example
        Game game = new HangmanGame();  // Create an instance of HangmanGame as a Game
        game.startGame();  // Start the game
    }
}
