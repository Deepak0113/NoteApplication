package signup;

import login.LoginView;
import starting.StartingView;

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
        System.out.println("\nSignup");
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
        System.out.println("\nSigned up successfully. Login to continue.");
        StartingView startingView = new StartingView();
        startingView.startingView();
    }

    @Override
    public void signupUserWarning(String message) {
        System.out.println("\nSigning up failed. " + message);
        StartingView startingView = new StartingView();
        startingView.startingView();
    }
}