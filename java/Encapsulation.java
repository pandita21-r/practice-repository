// Basic Encapsulation practice

package raymark1;

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
		c.setNumber(67);
		System.out.println(c.getNumber());
	}
}
