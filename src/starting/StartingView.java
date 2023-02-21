package starting;

import login.LoginView;
import signup.SignupView;

import java.util.Scanner;

public class StartingView implements StartingViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private final StartingViewControllerCallback startingController;

    StartingView() {
        startingController = new StartingController(this);
    }

    public static void main(String[] args) {
        StartingView startingView = new StartingView();
        startingView.startingView();
    }

    void startingView() {
        System.out.println("Welcome to NoteTaker");
        System.out.println("------------------------------");
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        System.out.println("9. Exit");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());

        startingController.chooseOption(option);
    }

    @Override
    public void gotoLogin() {
        LoginView loginView = new LoginView();
        loginView.userLogin();
    }

    @Override
    public void gotoSignup() {
        SignupView signupView = new SignupView();
        signupView.createUser();
    }
}