// 2D array practice 
// Last semester activity but i apply 2D array for weight and height inputs
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class TestRoom1 {
  public static int peopleCount(Scanner sc) {
    System.out.print("How many people? ");
    int people = sc.nextInt();
    return people;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int people = peopleCount(sc);
    double[][] data = inputData(sc, people);
    double[] bmi = computeBMI(data, people);
    String report = getBMICategory(data, bmi);
    saveReport(report);
    sc.close();
  }

  public static double[][] inputData(Scanner sc, int people) {
    double[][] data = new double[people][2];
    for (int i = 0; i < data.length; i++) {
      System.out.printf("Person %d weight (kg): ", (i + 1));
      data[i][0] = sc.nextDouble();
      System.out.printf("Person %d height (m): ", (i + 1));
      data[i][1] = sc.nextDouble();
    }
    return data;
  }

  public static double[] computeBMI(double[][] data, int people) {
    double[] bmi = new double[people];
    for (int i = 0; i < data.length; i++) {
      bmi[i] = data[i][0] / (data[i][1] * data[i][1]);
    }
    return bmi;
  }

  public static String getBMICategory(double[][] data, double[] bmi) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < bmi.length; i++) {
      if (bmi[i] < 18.5) {
        sb.append(String.format("\nPerson %d: %.1f kg, %.2f m, BMI = %.1f, Category = Underweight", (i + 1), data[i][0],
            data[i][1], bmi[i]));
      } else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) {

        sb.append(String.format("\nPerson %d: %.1f kg, %.2f m, BMI = %.1f, Category = Normal", (i + 1), data[i][0],
            data[i][1], bmi[i]));
      } else if (bmi[i] >= 25.0 && bmi[i] <= 29.9) {

        sb.append(String.format("\nPerson %d: %.1f kg, %.2f m, BMI = %.1f, Category = Overweight", (i + 1), data[i][0],
            data[i][1], bmi[i]));
      } else {
        sb.append(String.format("\nPerson %d: %.1f kg, %.2f m, BMI = %.1f, Category = Obese", (i + 1), data[i][0],
            data[i][1], bmi[i]));
      }
    }
    System.out.println(sb);
    return sb.toString();
  }

  public static void saveReport(String report) {
    try (FileWriter writer = new FileWriter("bmi_report.txt");) {
      writer.write(report);
      System.out.println("Saved report to bmi_report.txt");
    } catch (IOException e) {
      System.out.println("An error occured: " + e.getMessage());
    }
  }
}
