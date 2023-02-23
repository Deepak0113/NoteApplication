package home;

import dto.User;

public class HomeController implements HomeViewControllerCallback, HomeModelControllerCallback {
    private HomeViewCallback homeView;
    private HomeModelCallback homeModel;

    HomeController(HomeViewCallback homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel(this);
    }

    /*------ NAVIGATION ------*/

    @Override
    public void chooseOption(int option, User user) {
        switch (option){
            case 1 -> homeView.gotoCreateNote();
            case 2 -> homeView.gotoOpenNote(user);
            case 3 -> homeView.gotoViewNote(user);
            case 4 -> homeView.deleteNode();
            case 5 -> homeView.gotoStart();
            case 9 -> System.exit(0);
        }
    }
}