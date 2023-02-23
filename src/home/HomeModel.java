package home;

public class HomeModel implements HomeModelCallback {
    HomeModelControllerCallback homeController;

    HomeModel(HomeModelControllerCallback homeController) {
        this.homeController = homeController;
    }
}