import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = """
                   NUMBER CONVERTER
                -------------------------
                [1] Binary to Decimal
                [2] Decimal to Binary
                [0] Exit Program
                """;

        while (true) {
            System.out.println(menu);
            int choice = userChoice(sc);

            /*
             * Executes the selected option
             */
            switch (choice) {

                case 1:
                    binaryToDecimal(sc);
                    break;
                case 2:
                    decimalToBinary(sc);
                    break;
                case 0:
                    System.out.println("Program terminated.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid menu choice!");
            }
            System.out.println();
        }
    }
    /*
     * Gets validated menu input from the user
     */
    public static int userChoice(Scanner sc) {
        int choice;

        while (true) {
            try {

                System.out.print("Choice: ");
                choice = sc.nextInt();
                /*
                 * Clears leftover newline character
                 */
                sc.nextLine();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Numbers only.");
                sc.nextLine();
            }
        }
    }
    /*
     * Converts binary to decimal
     */
    public static void binaryToDecimal(Scanner sc) {
        String binary;
        /*
         * Input validation loop
         */
        while (true) {
            System.out.print("Enter binary number: ");
            binary = sc.nextLine();
            /*
             * Regex explanation:
             * [01]+
             * Means the input must contain only 0 or 1
             */
            if (binary.matches("[01]+")) {
                break;
            }
            System.out.println("Invalid binary number!");
        }
        int decimal = 0;
        /*
         * Processes every bit one by one
         */
        for (int i = 0; i < binary.length(); i++) {
            /*
             * Gets each character from the string
             */
            char bit = binary.charAt(i);
            /*
             * Computes place value power
             *
             * Example:
             * binary = 1010
             *
             * index 0 -> power 3
             * index 1 -> power 2
             * index 2 -> power 1
             * index 3 -> power 0
             */
            int power = binary.length() - 1 - i;

            /*
             * Only add if the current bit is 1
             */
            if (bit == '1') {

                decimal += Math.pow(2, power);
            }
        }
        System.out.print("\n-------------------------");
        System.out.println("\nDecimal value: " + decimal);
        System.out.println("-------------------------");
    }
    /*
     * Converts decimal to binary
     */
    public static void decimalToBinary(Scanner sc) {
        int decimal;
        /*
         * Input validation loop
         */
        while (true) {
            try {
                System.out.print("Enter decimal number: ");
                decimal = sc.nextInt();

                sc.nextLine();
                /*
                 * Rejects negative numbers
                 */
                if (decimal < 0) {
                    System.out.println("Negative numbers are not allowed!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid decimal number!");
                sc.nextLine();
            }
        }
        /*
         * Special case for 0
         */
        if (decimal == 0) {
            System.out.println("Binary value: 0");
            return;
        }
        String binary = "";
        /*
         * Repeated division by 2
         */
        while (decimal > 0) {
            /*
             * Gets remainder
             * Possible values: 0 or 1
             */
            int remainder = decimal % 2;
            /*
             * Adds remainder to the FRONT
             */
            binary = remainder + binary;
            /*
             * Reduces the number
             */
            decimal /= 2;
        }
        System.out.print("\n-------------------------");
        System.out.println("\nBinary value: " + binary);
        System.out.print("-------------------------");
    }
}