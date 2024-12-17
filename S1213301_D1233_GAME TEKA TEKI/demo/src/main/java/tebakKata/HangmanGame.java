// File: src/tebakKata/HangmanGame.java
package tebakKata;

import game.Game;
import utils.InputValidator;
import utils.WordGenerator;
import hangman.GameState;
import hangman.Player;

// Pewarisan dan Enkapsulasi
public class HangmanGame extends Game {
    private GameState gameState;
    private Player player;
    private String[] petunjuk; // Array untuk petunjuk

    public HangmanGame() {
        String word = WordGenerator.generateWord();
        this.gameState = new GameState(word);
        this.player = new Player();

        // Menambahkan petunjuk berdasarkan kata yang dihasilkan
        if (word.equalsIgnoreCase("durian")) {
            this.petunjuk = new String[]{
                "Aku besar dan bulat, kulitku tebal dan berduri, baunya menyengat, buah apakah akuu?",
                "Aku adalah buah tropis dengan kulit berduri, dikenal dengan bau yang kuat."
            };
        } else if (word.equalsIgnoreCase("banana")) {
            this.petunjuk = new String[]{
                "Aku buah yang panjang dan kuning saat matang, siapa aku?",
                "Aku tumbuh dalam tandan, dan sering dimakan sebagai camilan sehat."
            };
        } else if (word.equalsIgnoreCase("apple")) {
            this.petunjuk = new String[]{
                "Aku buah yang biasanya berwarna merah atau hijau, siapa aku?",
                "Aku terkenal dengan pepatah 'An apple a day keeps the doctor away.'"
            };
        } else if (word.equalsIgnoreCase("grape")) {
            this.petunjuk = new String[]{
                "Aku kecil dan bulat, bisa menjadi bahan utama wine, siapa aku?",
                "Aku tumbuh dalam kelompok besar dan biasanya berwarna ungu atau hijau."
            };
        } else if (word.equalsIgnoreCase("orange")) {
            this.petunjuk = new String[]{
                "Aku berwarna oranye, sering diperas untuk jus, siapa aku?",
                "Aku adalah buah citrus dengan kulit bertekstur kasar."
            };
        } else if (word.equalsIgnoreCase("gurita")) {
            this.petunjuk = new String[]{
                "Aku hewan laut, punya delapan lengan menyemprot tinta siapakah aku?",
                "Aku adalah buah citrus dengan kulit bertekstur kasar."
            };
        }
    }

    @Override
    public void startGame() {
        System.out.println("Selamat datang di Permainan Hangman!");

        int petunjukIndex = 0; // Index untuk petunjuk
        boolean petunjukDitampilkan = false; // Flag untuk menentukan apakah petunjuk sudah ditampilkan

        while (!gameState.isGameOver()) {
            System.out.println("Kata Saat Ini: " + gameState.getMaskedWord());
            System.out.println("Sisa Percobaan: " + gameState.getRemainingAttempts());

            // Jika tebakan salah dan sisa percobaan habis, tampilkan jawaban petunjuk
            if (gameState.getRemainingAttempts() == 0 && !petunjukDitampilkan) {
                System.out.println("Jawaban Petunjuk: " + gameState.getWord());
                petunjukDitampilkan = true; // Menandakan petunjuk sudah ditampilkan
            }

            // Tampilkan petunjuk hanya jika tebakan sebelumnya salah
            if (!petunjukDitampilkan && gameState.getRemainingAttempts() > 0) {
                System.out.println("Petunjuk: " + petunjuk[petunjukIndex % petunjuk.length]);
            }

            String tebakan = player.makeGuess();
            if (!InputValidator.isValidInput(tebakan)) {
                System.out.println("Tebakan tidak valid. Masukkan satu huruf saja.");
                continue;
            }

            // Cek apakah tebakan benar atau salah
            if (gameState.updateGameState(tebakan)) {
                System.out.println("Tebakan Benar!");
                petunjukDitampilkan = false; // Reset flag jika tebakan benar
            } else {
                System.out.println("Tebakan Salah!");
            }

            petunjukIndex++; // Pindah ke petunjuk berikutnya jika ada
        }

        // Jika pemain menang, tampilkan jawaban lengkap
        if (gameState.isWon()) {
            System.out.println("Selamat! Kamu menang. Kata yang benar adalah: " + gameState.getWord());
        } else {
            System.out.println("Permainan Selesai. Kata yang benar adalah: " + gameState.getWord());
        }
    }
}
