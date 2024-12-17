// File: src/utils/InputValidator.java
package utils;

// Encapsulation example
public class InputValidator {
    public static boolean isValidInput(String input) {
        return input != null && input.matches("[a-zA-Z]") && input.length() == 1;
    }
}
