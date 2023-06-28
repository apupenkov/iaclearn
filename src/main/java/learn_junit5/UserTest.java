package learn_junit5;

import learn_junit5.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    void exceptionTesting() {
        User user = new User();
//        Throwable exception =
//                assertThrows(IllegalArgumentException.class, () ->
//                        user.setAge("23"));
//        assertEquals("Age must be an Integer.", exception.getMessage());
    }
}