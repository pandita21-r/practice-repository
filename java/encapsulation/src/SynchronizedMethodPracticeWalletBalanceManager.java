public class SynchronizedMethodPracticeWalletBalanceManager {
    static class Wallet {
        private int balance = 100;

        public synchronized void deposit(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero.");
            }
            balance += amount;
            System.out.printf("\nDeposited %d.", amount);
        }

        public synchronized void withdraw(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero.");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Not enough balance.");
            }
            balance -= amount;
            System.out.printf("\nWithdrew %d.", amount);
        }

        public int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet();

        try {
            wallet.deposit(50);
            wallet.withdraw(30);
            System.out.println("\n" + wallet.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
