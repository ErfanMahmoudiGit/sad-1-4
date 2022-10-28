package ir.znu.sad.datatype.ui;

public class Authentication {
    String user;
    String pass;

    public Authentication(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }
}
