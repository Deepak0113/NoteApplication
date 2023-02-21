package login;

import repository.Repository;
import statuscalls.UserStatusCall;

public class LoginModel implements LoginModelCallback {
    LoginModelControllerCallback loginController;

    LoginModel(LoginModelControllerCallback loginController) {
        this.loginController = loginController;
    }

    @Override
    public void userLogin(String username, String password) {
        UserStatusCall userStatusCall = Repository.getInstance().loginUser(username, password);

        switch (userStatusCall.getStatus()){
            case "SUCCESS" -> loginController.userLoginSuccess(userStatusCall.getUser());
            case "INCORRECT PASSWORD" -> loginController.userLoginWarning("Incorrect Password");
            case "NOT EXIST" -> loginController.userLoginWarning("User doesn't exist");
        }
    }
}