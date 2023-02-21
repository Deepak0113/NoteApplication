package login;

import dto.User;

public class LoginController implements LoginViewControllerCallback, LoginModelControllerCallback {
    private LoginViewCallback loginView;
    private LoginModelCallback loginModel;

    LoginController(LoginViewCallback loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    @Override
    public void userLogin(String username, String password) {
        loginModel.userLogin(username, password);
    }

    @Override
    public void userLoginSuccess(User user) {
        loginView.userLoginSuccess(user);
    }

    @Override
    public void userLoginWarning(String incorrectPassword) {
        loginView.userLoginWarning(incorrectPassword);
    }
}