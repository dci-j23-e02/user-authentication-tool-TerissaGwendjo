import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    String username;
    String password;
    boolean isLoggedIn;

    //Constructor to initialize the username and password
    public User(String username, String password, boolean isLoggedIn) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }

    // Getter and setter methods

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Create a UserAuthenticationTool class to manage user authentication.
    //In the UserAuthenticationTool class, maintain a list of User objects to store registered users.


    public static class UserAuthenticationTool {
        private List<User> userList;
        private Scanner scanner;

        // Constructor
        public UserAuthenticationTool() {
            this.userList = new ArrayList<>();
        }

        // Method to register a new user
        public void registerUser(User user) {
            userList.add(user);
        }

        // Method to authenticate a user
        public boolean authenticateUser(String username, String password) {
            for (User user : userList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    user.setLoggedIn(true);
                    return true; // Authentication successful
                }
            }
            return false; // Authentication failed
        }

        // Method to logout a user
        public void logoutUser(String username) {
            for (User user : userList) {
                if (user.getUsername().equals(username)) {
                    user.setLoggedIn(false);
                    break;
                }
            }
        }

        // Method to handle user sign-up
        public void signUpUser() {
            System.out.print("Enter a username: ");
            String username = scanner.nextLine();

            // Validate if the username is unique
            while (isUsernameTaken(username)) {
                System.out.println("Username already taken. Please choose another one.");
                System.out.print("Enter a username: ");
                username = scanner.nextLine();
            }

            System.out.print("Enter a password (minimum length 6 characters): ");
            String password = scanner.nextLine();

            // Validate password length
            while (password.length() < 6) {
                System.out.println("Password must be at least 6 characters long.");
                System.out.print("Enter a password: ");
                password = scanner.nextLine();
            }

            // Create a new User object and add it to the list of registered users
            User newUser = new User(username, password, false);
            registerUser(newUser);

            System.out.println("User signed up successfully!");
        }


        // Method to handle user sign-in
        public void signInUser() {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Authenticate the user
            boolean isAuthenticated = authenticateUser(username, password);

            if (isAuthenticated) {
                System.out.println("User signed in successfully.");
            } else {
                System.out.println("Authentication failed. Incorrect username or password.");
            }
        }

        // Method to handle user sign-out
        public void signOutUser() {
            System.out.print("Do you want to sign out? (yes/no): ");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("yes")) {
                // Assume the user is already authenticated before signing out
                User signedInUser = getSignedInUser();

                if (signedInUser != null) {
                    logoutUser(signedInUser.getUsername());
                    System.out.println("User signed out successfully.");
                } else {
                    System.out.println("No user is currently signed in.");
                }
            } else {
                System.out.println("Sign out canceled.");
            }
        }

        // Helper method to get the signed-in user
        private User getSignedInUser() {
            for (User user : userList) {
                if (user.isLoggedIn()) {
                    return user;
                }
            }
            return null;
        }


        // Helper method to check if a username is already taken
        private boolean isUsernameTaken(String username) {
            for (User user : userList) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
            return false;
        }


        // Method to get the list of registered users
        public List<User> getRegisteredUsers() {
            return userList;
        }

    }
}



