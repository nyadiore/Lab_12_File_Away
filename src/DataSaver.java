import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DataSaver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean keepAdding = true;

        while (keepAdding) {
            // Step 1: Collect data
            String firstName = SafeInput.getNonEmptyString(sc, "Enter first name: ");
            String lastName = SafeInput.getNonEmptyString(sc, "Enter last name: ");
            String idNumber = String.format("%06d", (int)(Math.random() * 1000000));  // Generates a random 6-digit number
            String email = SafeInput.getNonEmptyString(sc, "Enter email: ");
            int yearOfBirth = SafeInput.getInt(sc, "Enter year of birth: ");

            // Step 2: Create CSV record
            String csvRecord = String.join(", ", firstName, lastName, idNumber, email, String.valueOf(yearOfBirth));
            records.add(csvRecord);

            // Step 3: Ask if user wants to continue
            String response = SafeInput.getNonEmptyString(sc, "Do you want to enter another record? (y/n): ");
            if (response.equalsIgnoreCase("n")) {
                keepAdding = false;
            }
        }

        // Step 4: Prompt for file name and save the data
        String fileName = SafeInput.getNonEmptyString(sc, "Enter the file name (including .csv): ");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
