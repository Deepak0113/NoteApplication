package starting;

public class StartingController implements StartingViewControllerCallback, StartingModelControllerCallback {
    private StartingViewCallback startingView;
    private StartingModelCallback startingModel;

    StartingController(StartingViewCallback startingView) {
        this.startingView = startingView;
        startingModel = new StartingModel(this);
    }

    /*------ NAVIGATION ------*/

    @Override
    public void chooseOption(int option) {
        switch (option){
            case 1 -> startingView.gotoLogin();
            case 2 -> startingView.gotoSignup();
            case 9 -> System.exit(0);
            default -> new StartingView().startingView();
        }
    }
}