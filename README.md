# Java Command Line User Authentication Tool

## Assignment Description

In this assignment, you will create a Java command line tool for user authentication. The tool should provide functionalities for user sign-up, sign-in, and sign-out. Follow the steps below to complete the assignment.

## Task 1: Set Up the Project

1. Clone this repository:

    ```bash
    git clone <repository-url>
    ```

2. Open the project in your preferred Java development environment.

## Task 2: Implement User Class

1. Create a `User` class with the following attributes:
   - `username` (String)
   - `password` (String)
   - `isLoggedIn` (boolean)



2. Implement the necessary methods in the `User` class:
   - Constructor to initialize the username and password.
   - Getter and setter methods for `isLoggedIn`.

code snippets provide a starting point:

```java
public class User {
    private String username;
    private String password;
    private boolean isLoggedIn;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }

    // Getter and Setter methods
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}

```

## Task 3: Implement User Authentication Tool

1. Create a `UserAuthenticationTool` class to manage user authentication.

2. In the `UserAuthenticationTool` class, maintain a list of `User` objects to store registered users.

code snippets provide a starting point:

```java
import java.util.ArrayList;

public class UserAuthenticationTool {
    private ArrayList<User> userList;

    // Constructor
    public UserAuthenticationTool() {
        this.userList = new ArrayList<>();
    }

    // Additional methods for managing users can be added here
}


```

## Task 4: Implement Sign-Up Functionality

1. Create a method in `UserAuthenticationTool` to handle user sign-up.

2. Prompt the user to enter a username and password.

3. Validate the inputs:
   - Ensure the username is unique.
   - Implement basic password requirements (e.g., minimum length).

4. Create a new `User` object and add it to the list of registered users.


code snippets provide a starting point:

```java
import java.util.Scanner;

public class UserAuthenticationTool {
    // ... (previous code)

    // Method to handle user sign-up
    public void signUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a username:");
        String username = scanner.nextLine();

        // Validate unique username
        if (isUsernameTaken(username)) {
            System.out.println("Username already taken. Please choose another one.");
            return;
        }

        System.out.println("Enter a password:");
        String password = scanner.nextLine();

        // Validate password requirements (e.g., minimum length)
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return;
        }

        // Create a new user and add to the list
        User newUser = new User(username, password);
        userList.add(newUser);

        System.out.println("Sign-up successful!");
    }

    // Helper method to check if username is already taken
    private boolean isUsernameTaken(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}



```

## Task 5: Implement Sign-In Functionality

1. Create a method in `UserAuthenticationTool` to handle user sign-in.

2. Prompt the user to enter their username and password.

3. Check if the entered credentials match any registered user.

4. If successful, set the `isLoggedIn` flag for the corresponding `User` object.


code snippets provide a starting point:

```java
import java.util.Scanner;

public class UserAuthenticationTool {
    // ... (previous code)

    // Method to handle user sign-in
    public void signIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        // Find the user with the given username
        User user = findUserByUsername(username);

        if (user != null) {
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            // Check if the entered password is correct
            if (user.getPassword().equals(password)) {
                user.setLoggedIn(true);
                System.out.println("Sign-in successful!");
            } else {
                System.out.println("Incorrect password. Sign-in failed.");
            }
        } else {
            System.out.println("User not found. Sign-in failed.");
        }
    }

    // Helper method to find a user by username
    private User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}



```

## Task 6: Implement Sign-Out Functionality

1. Create a method in `UserAuthenticationTool` to handle user sign-out.

2. Prompt the user to confirm the sign-out.

3. If confirmed, set the `isLoggedIn` flag to false for the signed-in user.

code snippets provide a starting point:

```java
public class UserAuthenticationTool {
    // ... (previous code)

    // Method to handle user sign-out
    public void signOut() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you sure you want to sign out? (yes/no)");
        String confirmation = scanner.nextLine().toLowerCase();

        if (confirmation.equals("yes")) {
            // Log out the currently logged-in user
            for (User user : userList) {
                if (user.isLoggedIn()) {
                    user.setLoggedIn(false);
                    System.out.println("Sign-out successful!");
                    return;
                }
            }
            System.out.println("No user is currently signed in.");
        } else {
            System.out.println("Sign-out canceled.");
        }
    }
}

```

## Task 7: Implement Main Application

1. Create a `Main` class with the `main` method to serve as the entry point.

2. Instantiate the `UserAuthenticationTool` and provide a menu for users to choose sign-up, sign-in, or sign-out.

3. Implement a loop to keep the application running until the user decides to exit.


code snippets provide a starting point:

```java
public class Main {
    public static void main(String[] args) {
        UserAuthenticationTool authenticationTool = new UserAuthenticationTool();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== User Authentication Tool =====");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Sign Out");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    authenticationTool.signUp();
                    break;
                case 2:
                    authenticationTool.signIn();
                    break;
                case 3:
                    authenticationTool.signOut();
                    break;
                case 4:
                    System.out.println("Exiting User Authentication Tool. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}

```

## Task 8: Testing

1. Test your application thoroughly by:
   - Signing up multiple users.
   - Signing in with valid and invalid credentials.
   - Signing out.

2. Ensure that the application handles edge cases and user input gracefully.


code snippets provide a starting point:

```java
public class Testing {
    public static void main(String[] args) {
        // Instantiate the UserAuthenticationTool and perform testing

        // Example:
        UserAuthenticationTool authenticationTool = new UserAuthenticationTool();

        // Task 8 Testing
        authenticationTool.signUp();
        authenticationTool.signIn();
        authenticationTool.signOut();
    }
}


```

---
