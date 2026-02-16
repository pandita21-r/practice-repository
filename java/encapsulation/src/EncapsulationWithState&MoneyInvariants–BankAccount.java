// FUTURE ME! VALIDATE FIRST BEFORE MUTATION(CHANGING A STATE OF MUTABLE OBJECT)!!!!!

package package1;

public class TestRoom7 {
    enum AccountState {
        ACTIVE,
        INACTIVE,
        FROZEN
    }

    static class BankAccount {
        private AccountState account = AccountState.INACTIVE;
        private String accountHolder;
        private double balance = 0;

        public synchronized void activateAccount(String accountHolder) {
            if(account == AccountState.FROZEN){
                throw new IllegalStateException("Reactivating blocked.");   
            }
            if (account != AccountState.INACTIVE) {
                throw new IllegalStateException("The account is already active.");
            }
            if (accountHolder == null || !accountHolder.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Account must not contain non-letter characters and not be null.");
            }
            this.accountHolder = accountHolder;
            account = AccountState.ACTIVE;
            this.balance = 0;
        }

        public synchronized String getAccountHolder() {
            return accountHolder;
        }

        public synchronized void deposit(double amount) {
            if (account != AccountState.ACTIVE) {
                throw new IllegalStateException("Account is not active. Cannot deposit funds.");
            }
            if (amount <= 0) {
                throw new IllegalStateException("Amount must be greater than zero.");
            }
            this.balance += amount;
        }

        public synchronized void withdraw(double amount) {
            if (account != AccountState.ACTIVE) {
                throw new IllegalStateException("Account is not active. Cannot withdraw funds.");
            }
            if (amount <= 0) {
                throw new IllegalStateException("Amount must be greater than zero.");
            }
            if (balance - amount < 0){
                throw new IllegalArgumentException("Not enough balance.");
            }
            this.balance -= amount;
        }

        public synchronized double getBalance() {
            return balance;
        }

        public synchronized void freezeAccount() {
            if (account != AccountState.ACTIVE) {
                throw new IllegalStateException("Account is not active.");
            }
            account = AccountState.FROZEN;
        }

        public synchronized AccountState getState() {
            return account;
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        double amount = 50;

        try {
            bankAccount.withdraw(amount);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
