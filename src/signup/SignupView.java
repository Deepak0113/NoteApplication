package signup;

import login.LoginView;

import java.util.Scanner;

public class SignupView implements SignupViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private SignupViewControllerCallback signupController;

    public SignupView() {
        signupController = new SignupController(this);
    }

    public static void main(String[] args) {
        SignupView signupView = new SignupView();
        signupView.createUser();
    }

    public void createUser(){
        System.out.println("Signup");
        System.out.println("------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        signupController.createUser(username, email, password);
    }

    @Override
    public void signupUserSuccessfully() {
        System.out.println("Signed up successfully.");
        LoginView loginView = new LoginView();
        loginView.userLogin();
    }

    @Override
    public void signupUserWarning(String message) {
        System.out.println("Signing up failed. " + message);
    }
}