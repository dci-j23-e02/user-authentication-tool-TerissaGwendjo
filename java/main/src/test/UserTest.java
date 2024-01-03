import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserAuthentication() {
        // Create users
        User user1 = new User("user1", "password1", false);
        User user2 = new User("user2", "password2", false);

        // Authenticate users
        assertTrue(user1.isLoggedIn());
        assertTrue(user2.isLoggedIn());

        // Logout user
        user1.setLoggedIn(false);
        assertFalse(user1.isLoggedIn());
    }

    class UserAuthenticationToolTest {

        @Test
        void testSignUpUser() {
            User.UserAuthenticationTool authTool = new User.UserAuthenticationTool();

            // Sign up a user
            authTool.signUpUser();
        }

        @Test
        void testSignInUser() {
            User.UserAuthenticationTool authTool = new User.UserAuthenticationTool();

            // Sign in with valid credentials
            authTool.signInUser();

            // Sign in with invalid credentials
            authTool.signInUser();
        }

        @Test
        void testSignOutUser() {
            User.UserAuthenticationTool authTool = new User.UserAuthenticationTool();

            // Sign out user
            authTool.signOutUser();
        }

    }




}
