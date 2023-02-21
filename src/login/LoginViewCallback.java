package login;

import dto.User;

public interface LoginViewCallback {
    void userLoginSuccess(User user);
    void userLoginWarning(String message);
}