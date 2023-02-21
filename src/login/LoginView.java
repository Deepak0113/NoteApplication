package login;

import dto.User;

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
        System.out.println("Login");
        System.out.println("------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loginController.userLogin(username, password);
    }

    @Override
    public void userLoginSuccess(User user) {
        System.out.println("Logged in successfully");
        System.out.println("Welcome " + user.getUserName());
    }

    @Override
    public void userLoginWarning(String message) {
        System.out.println("Login failed. " + message);
    }
}