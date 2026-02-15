package package1;

import java.time.LocalTime;

public class TestRoom6 {
    enum UserState {
        ACTIVE,
        INACTIVE
    }

    static class UserSession {
        private String username;
        private UserState state = UserState.INACTIVE;
        private LocalTime loginTime;

        public synchronized void login(String username) {
            if (state != UserState.INACTIVE) {
                throw new IllegalStateException("Session is already active.");
            }
            if (username == null || !username.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException(
                        "Username must contain only letters.");
            }
            this.username = username;
            this.state = UserState.ACTIVE;
            this.loginTime = LocalTime.now();
        }

        public synchronized String getUsername() {
            return username;
        }

        public synchronized void logout() {
            if (state == UserState.ACTIVE) {
                state = UserState.INACTIVE;
                this.username = null;
                this.loginTime = null;
            } else {
                throw new IllegalStateException("Please login first.");
            }
        }

        public synchronized void useSession() {
            if (state == UserState.ACTIVE) {
                System.out.println("You are now using session: " + username + "\nLog in time: " + loginTime);
            } else {
                throw new IllegalStateException("Session is not active. Please login first.");
            }
        }
    }

    public static void main(String[] args) {
        UserSession user = new UserSession();
        String username = "mark";

        try {
            user.useSession();
            user.login(username);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
