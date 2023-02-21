package login;

import dto.User;

public interface LoginModelControllerCallback {
    void userLoginSuccess(User user);
    void userLoginWarning(String incorrectPassword);
}
