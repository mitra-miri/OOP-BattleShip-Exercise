import java.util.Scanner;

public class InputValidator {
    public static boolean isValidCoordinate(String input) {
        if (input.length() != 2) return false;
        char col = input.charAt(0);
        char row = input.charAt(1);
        return (col >= 'A' && col <= 'J') && (row >= '0' && row <= '9');
    }
}