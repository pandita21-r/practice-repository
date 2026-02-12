// Basic Encapsulation practice with scanner

package raymark1;

import java.util.Scanner;

public class TestRoom5 {
	static class Checker{
		private int number;
		
		public void setNumber(int number) {
			if(number >= 0) {
				this.number = number;
			}
		}
		public int getNumber() {
			return number;
		}
	}
	public static void main(String[] args) {
		Checker c = new Checker();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int input = sc.nextInt();

        c.setNumber(input);
        System.out.println(c.getNumber());
		sc.close();
	}
}
