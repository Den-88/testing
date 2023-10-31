package tdd;

import java.util.Objects;

public class User {

    String name;
    String password;
    boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public void authenticate(String name, String password) {
        isAuthenticate = (Objects.equals(this.name, name) && Objects.equals(this.password, password));
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void logout() {
        isAuthenticate = false;
    }
}