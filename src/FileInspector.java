import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileInspector {
    public static void main(String[] args) {
        // Step 1: Open JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src")); // Open in src directory
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getName());

            // Step 2: Initialize counters
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                // Step 3: Read the file line by line
                while ((line = reader.readLine()) != null) {
                    // Echo the line to the screen
                    System.out.println(line);

                    // Count words using split
                    String[] words = line.split("\\s+");
                    wordCount += words.length;

                    // Count characters
                    charCount += line.length();

                    lineCount++;
                }

                // Step 4: Print the summary report
                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
