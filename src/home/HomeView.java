package home;

import createnote.CreateNoteView;
import deletenote.DeleteNoteView;
import dto.User;
import opennote.OpenNoteView;
import starting.StartingView;
import viewnote.ViewNoteView;

import java.util.Scanner;

public class HomeView implements HomeViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private final HomeViewControllerCallback homeController;
    private User user;

    public HomeView() {
        homeController = new HomeController(this);
    }

    /*------ NAVIGATION ------*/

    public void startHomeModule(User user){
        System.out.println("\nHome");
        System.out.println("------------------------------");
        System.out.println("1. Create note");
        System.out.println("2. Open note");
        System.out.println("3. View note");
        System.out.println("4. Delete note");
        System.out.println("5. Go to start");
        System.out.println("9. Exit application");
        System.out.print("Enter option: ");
        int option = Integer.parseInt(scanner.nextLine());

        this.user = user;

        homeController.chooseOption(option, user);
    }

    @Override
    public void gotoCreateNote(){
        CreateNoteView createNoteView = new CreateNoteView();
        createNoteView.startCreateNoteModule(user);
    }

    @Override
    public void gotoOpenNote(User user){
        OpenNoteView openNoteModel = new OpenNoteView();
        openNoteModel.startOpenNoteModule(user);
    }

    @Override
    public void gotoViewNote(User user){
        ViewNoteView viewNoteView = new ViewNoteView();
        viewNoteView.startViewNotesModule(user);
    }

    @Override
    public void deleteNode(){
        DeleteNoteView deleteNoteView = new DeleteNoteView();
        deleteNoteView.deleteNote(user);
    }

    @Override
    public void gotoStart(){
        StartingView startingView = new StartingView();
        startingView.startingView();
    }
}