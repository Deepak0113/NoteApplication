package signup;

public interface SignupModelCallback {
    void createUser(String username, String email, String password);
}