package package1;

public class TestRoom9 {
    static class TicketCounter {
        private int tickets = 10;

        public synchronized void buyTicket(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero.");
            }
            if (amount > tickets) {
                throw new IllegalArgumentException("Not enough tickets available.");
            }
            tickets = tickets - amount;
            System.out.printf("\nBought %d ticket(s).", amount);
        }

        public int getRemainingTickets() {
            return tickets;
        }
    }

    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        try {
            counter.buyTicket(3);
            counter.buyTicket(2);

            System.out.println("\n" + counter.getRemainingTickets());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
