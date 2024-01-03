import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testApplication() {
        // Create an instance of the UserAuthenticationTool
        User.UserAuthenticationTool authTool = new User.UserAuthenticationTool();

        // Perform various operations and assertions based on your application's logic
        // ...

        // Example assertion (you can add more)
        assertEquals(2, authTool.getRegisteredUsers().size());
    }

}