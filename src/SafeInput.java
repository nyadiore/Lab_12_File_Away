import java.util.Scanner;

public class SafeInput {
    private static Scanner sc = new Scanner(System.in);

    public static String getNonEmptyString(Scanner sc, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine();
        } while (input.isEmpty());
        return input;
    }

    public static int getInt(Scanner sc, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
