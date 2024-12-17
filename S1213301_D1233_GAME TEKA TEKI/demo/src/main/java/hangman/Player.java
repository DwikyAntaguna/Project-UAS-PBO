// File: src/hangman/Player.java
package hangman;

import java.util.Scanner;

public class Player {
    private Scanner scanner;

    public Player() {
        this.scanner = new Scanner(System.in);
    }

    public String makeGuess() {
        System.out.print("Enter your guess: ");
        return scanner.nextLine();
    }
}
