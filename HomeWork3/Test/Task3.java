import org.junit.jupiter.api.Test;
import tdd.User;
import tdd.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

public class Task3 {
    @Test
    void logoutUsers() {
        UserRepository repo = new UserRepository();
        User ivan = new User("Ivan", "12345", false);
        User petr = new User("Petr", "01010", true);
        User semen = new User("Semen", "55555", false);
        User alex = new User("Alex", "97875", true);
        User valera = new User("Valera", "00800", false);

        ivan.authenticate("Ivan", "12345");
        petr.authenticate("Petr", "01010");
        semen.authenticate("Semen", "55555");
        alex.authenticate("Alex", "97875");
        valera.authenticate("Valera", "00800");

        repo.addUser(ivan);
        repo.addUser(petr);
        repo.addUser(semen);
        repo.addUser(alex);
        repo.addUser(valera);

        repo.logoutAllUsers();

        assertFalse(ivan.isAuthenticate());
        assertTrue(petr.isAuthenticate());
        assertFalse(semen.isAuthenticate());
        assertTrue(alex.isAuthenticate());
        assertFalse(valera.isAuthenticate());
    }
}
