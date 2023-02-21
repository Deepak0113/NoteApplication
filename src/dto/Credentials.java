package dto;

public class Credentials extends User {
    private String password;

    public Credentials(String username, String email, String password) {
        super(username, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
