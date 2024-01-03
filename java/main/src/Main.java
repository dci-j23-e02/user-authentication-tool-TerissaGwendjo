import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Registering users
        User user1 = new User("user1", "password1", false);
        User user2 = new User("user2", "password2", false);
        User.UserAuthenticationTool authTool = new User.UserAuthenticationTool();
        Scanner scanner = new Scanner(System.in);

        authTool.registerUser(user1);
        authTool.registerUser(user2);

        // Authenticating users
        boolean isAuthenticated = authTool.authenticateUser("user1", "password1");
        if (isAuthenticated) {
            System.out.println("User authenticated successfully.");
            System.out.println("Is user1 logged in? " + user1.isLoggedIn());
        } else {
            System.out.println("Authentication failed.");
        }

        // Logging out user
        authTool.logoutUser("user1");
        System.out.println("Is user1 logged in after logout? " + user1.isLoggedIn());

        // Signing up a new user
        authTool.signUpUser();

        // Signing in User
        authTool.signInUser();

        //Signing out User
        authTool.signOutUser();


        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== User Authentication Menu ===");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Sign Out");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    authTool.signUpUser();
                    break;
                case 2:
                    authTool.signInUser();
                    break;
                case 3:
                    authTool.signOutUser();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the User Authentication System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option (1-4).");
            }
        }

        scanner.close();

    }

}

