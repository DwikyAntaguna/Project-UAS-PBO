// File: src/utils/WordGenerator.java
package utils;

import java.util.Random;

public class WordGenerator {
    private static final String[] WORDS = {"apple", "banana", "cherry", "grape", "orange", "gurita"};

    public static String generateWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }
}
