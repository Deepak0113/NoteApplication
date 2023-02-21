package signup;

import repository.Repository;
import statuscalls.UserStatusCall;

public class SignupModel implements SignupModelCallback {
    SignupModelControllerCallback signupController;

    SignupModel(SignupModelControllerCallback signupController) {
        this.signupController = signupController;
    }

    @Override
    public void createUser(String username, String email, String password) {
        UserStatusCall userStatusCall = Repository.getInstance().createUser(username, email, password);

        switch (userStatusCall.getStatus()){
            case "EXIST" -> signupController.signupUserWarning("User already exists");
            case "SUCCESS" -> signupController.signupUserSuccessfully();
        }
    }
}