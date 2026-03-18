import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] days = inputDays(sc);
        String data = checkLoanStatus(days);
        saveReport(data);
        sc.close();
    }

    public static int[] inputDays(Scanner sc) {
        System.out.print("How many books to audit? ");
        int books = sc.nextInt();

        int[] days = new int[books];
        for (int i = 0; i < days.length; i++) {
            System.out.printf("Book %d: ", (i + 1));
            days[i] = sc.nextInt();
        }
        return days;
    }

    public static String checkLoanStatus(int[] days) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < days.length; i++) {
            if(days[i] > 30){
                sb.append(String.format("\nBook %d: %d days - Overdue", (i + 1), days[i]));
            }else if(days[i] >= 15 && days[i] <= 30){
                sb.append(String.format("\nBook %d: %d days - Warning", (i + 1), days[i]));
            }else{
                sb.append(String.format("\nBook %d: %d days - On Time", (i + 1), days[i]));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
    public static void saveReport(String data){
        try(FileWriter writer = new FileWriter("loan_audit.txt")){
            writer.write(data);
            System.out.println("\nSave report to loan_audit.txt");
        }catch(IOException e){
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}