// File: src/hangman/GameState.java
package hangman;

public class GameState {
    private String word;
    private StringBuilder maskedWord;
    private int remainingAttempts;

    public GameState(String word) {
        this.word = word;
        this.maskedWord = new StringBuilder("_".repeat(word.length()));
        this.remainingAttempts = 5;
    }

    public boolean updateGameState(String guess) {
        boolean correct = false;
        char guessedChar = guess.toLowerCase().charAt(0);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guessedChar) {
                maskedWord.setCharAt(i, guessedChar);
                correct = true;
            }
        }

        if (!correct) {
            remainingAttempts--;
        }

        return correct;
    }

    public boolean isGameOver() {
        return remainingAttempts <= 0 || isWon();
    }

    public boolean isWon() {
        return maskedWord.toString().equals(word);
    }

    public String getMaskedWord() {
        return maskedWord.toString();
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public String getWord() {
        return word;
    }
}
