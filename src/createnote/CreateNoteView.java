package createnote;

import dto.User;
import home.HomeView;
import starting.StartingView;

import java.util.Scanner;

public class CreateNoteView implements CreateNoteViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private final CreateNoteViewControllerCallback createNoteController;

    public CreateNoteView() {
        createNoteController = new CreateNoteController(this);
    }


    /*------ NAVIGATION ------*/

    public void startCreateNoteModule(User user){
        System.out.println("\n1. Continue Creating note");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit application");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());

        createNoteController.chooseOption(user, option);
    }

    @Override
    public void gotoHome(User user) {
        HomeView homeView = new HomeView();
        homeView.startHomeModule(user);
    }

    @Override
    public void gotoStart() {
        StartingView startingView = new StartingView();
        startingView.startingView();
    }

    private void gotoOpenNote(){

    }


    /*------ CREATE NOTE ------*/

    @Override
    public void createNewNote(User user){
        System.out.println("\nCreate Note");
        System.out.println("------------------------------");
        System.out.println("Enter note title: ");
        String noteTitle = scanner.nextLine();

        createNoteController.createNewNote(user, noteTitle);
    }

    @Override
    public void createNewNoteSuccess(User user, String filePath) {
        System.out.println("\nSuccessfully created new note.");
        System.out.println("Opening note.....");

        gotoHome(user);
    }

    @Override
    public void createNewNoteWarning(User user, String message) {
        System.out.println("\nNew note creation is failed. " + message);
        startCreateNoteModule(user);
    }
}