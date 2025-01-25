package backEnd;

import java.io.Serializable;

public class Login implements Printable, Serializable {
    private String login;
    public Login(String login) {
        this.login = login;
    }

    public Login() throws NoLoginException{
        throw new NoLoginException();
    }

    public void changeLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    @Override
    public String listData() {
        return "Login: " + getLogin();
    }
}

