package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends Person{
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User(String surname, String name, String patronymic) {
        super(surname, name, patronymic);

    }
}
