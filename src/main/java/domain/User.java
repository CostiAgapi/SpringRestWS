package domain;

/**
 * Created by ConstantinAgapi on 22/09/2017.
 */
public class User {

    String username;
    String email;
    String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
