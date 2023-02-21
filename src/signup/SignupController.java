package signup;

public class SignupController implements SignupViewControllerCallback, SignupModelControllerCallback {
    private SignupViewCallback signupView;
    private SignupModelCallback signupModel;

    SignupController(SignupViewCallback signupView) {
        this.signupView = signupView;
        signupModel = new SignupModel(this);
    }


    @Override
    public void createUser(String username, String email, String password) {
        signupModel.createUser(username, email, password);
    }

    @Override
    public void signupUserWarning(String userAlreadyExists) {
        signupView.signupUserWarning(userAlreadyExists);
    }

    @Override
    public void signupUserSuccessfully() {
        signupView.signupUserSuccessfully();
    }
}