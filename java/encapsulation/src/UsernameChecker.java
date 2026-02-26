// Another encapsulation practice (not fully polished, can be improved)
// Validates a username to ensure it contains letters only.
// Uses IllegalArgumentException if the input contains non-letter characters
// Handle exception to avoid crashing when the input is invalid (try-catch)

import java.util.Scanner;

public class UsernameChecker{
    static class Accounts{
        private String username;

        public void usernameChecker(String username){
            if(username.matches("[a-zA-Z]+")){
                this.username = username;
            } else{
                throw new IllegalArgumentException("Username must not contain numbers");
            }
        }
        public String getUsername(){
            return username;
        }
    }
    public static void main(String[] args) {
        Accounts a = new Accounts();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- SIGN UP ---");
        System.out.println("Enter your username (numbers is not allowed): ");
        String username = sc.nextLine();

       try{
        a.usernameChecker(username);   
       } catch(IllegalArgumentException e){
        System.out.println(e.getMessage());    
       } 
        System.out.println(a.getUsername());
        sc.close();
    }
}
