package utilities;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Класс для проверки пользовательского ввода
 */
public class ValidateInput {

    private final Scanner sc;

    public ValidateInput(Scanner sc) {
        this.sc = sc;
    }

    public double validateDouble() throws IOException {
        if (!sc.hasNextDouble()) {
            throw new IOException(ResourceBundle.getBundle("res.Messages").getString("must_double"));
        }
        return sc.nextFloat();
    }

    private static void printNotValid(Scanner sc) {
        String input = sc.next();
        System.out.printf("\"%s\" is not a valid input.\n", input);
    }
}
