package signup;

public interface SignupViewCallback {
    void signupUserSuccessfully();
    void signupUserWarning(String message);
}