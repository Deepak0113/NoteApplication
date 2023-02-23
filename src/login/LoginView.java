package login;

import dto.User;
import home.HomeView;
import starting.StartingView;

import java.util.Scanner;

public class LoginView implements LoginViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private final LoginViewControllerCallback loginController;

    public LoginView() {
        loginController = new LoginController(this);
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.userLogin();
    }

    public void userLogin(){
        System.out.println("\nLogin");
        System.out.println("------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loginController.userLogin(username, password);
    }

    @Override
    public void userLoginSuccess(User user) {
        System.out.println("\nLogged in successfully");
        System.out.println("Welcome " + user.getUserName());
        HomeView homeView = new HomeView();
        homeView.startHomeModule(user);
    }

    @Override
    public void userLoginWarning(String message) {
        System.out.println("\nLogin failed. " + message);
        StartingView startingView = new StartingView();
        startingView.startingView();
    }
}