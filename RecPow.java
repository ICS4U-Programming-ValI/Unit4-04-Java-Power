import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




/**
 * This is the package for RecPow.java
 *
 * The RecPow program reads an int from a file
 * calculates the exponent of the int
 * using recursion
 * then writes the result to a file.
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @author Val Ijaola
 * @version 1.0
 * @since 2025-04-23
 */


public final class RecPow {


    private RecPow() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This method calculates exponent using recursion.
     *
     * @param base the base of the int
     * @param exp the exponent of the int
     * @return the exponent of the int
     */
    public static int exponent(final int base, final int exp) {
        if (exp == 0) {
            return 1;
        }
        return base * exponent(base, exp - 1);
    }



    /**
     * This is the main method.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        try {
            // Specify the file paths
            String filePath = "input.txt";
            File outputFile = new File("output.txt");


            // Create a FileWriter and PrintWriter for the output file
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);


            // Read the word from the input file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                // Convert the string to an int
                try {
                    // split the string into words
                    String[] words = word.split(" ");
                    // if words amount is not 2
                    if (words.length != 2) {
                        printWriter.println("Please provide two integers.");
                    } else {
                        // parse the first word as base
                        int num = Integer.parseInt(words[0]);
                        // parse the second word as exponent
                        int exponent = Integer.parseInt(words[1]);

                        // Check if the exponent is negative
                        if (exponent < 0) {
                            printWriter.println("Exponent cannot be negative.");
                        } else {
                            int exponentValue = exponent(num, exponent);
                            printWriter.println(exponentValue);
                        }

                    }

                } catch (NumberFormatException ex) {
                    printWriter.println("Integers only!");
                }
            }


            // Close the scanner and writer
            scanner.close();
            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading the file: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error writing to the file: " + ex.getMessage());
        }
    }
}
