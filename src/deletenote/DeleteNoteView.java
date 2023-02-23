package deletenote;

import dto.User;
import home.HomeView;

import java.util.Scanner;

public class DeleteNoteView implements DeleteNoteViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private DeleteNoteViewControllerCallback deleteNoteController;

    public DeleteNoteView() {
        deleteNoteController = new DeleteNoteController(this);
    }

    public void deleteNote(User username){
        System.out.println("Delete Note");
        System.out.println("-----------------------------");
        System.out.print("Enter noteID: ");
        String noteId = scanner.nextLine();

        deleteNoteController.deleteNote(noteId, username);
    }

    @Override
    public void deleteNoteSuccessful(User user) {
        System.out.println("Note successfully deleted.");
        HomeView homeView = new HomeView();
        homeView.startHomeModule(user);
    }

    @Override
    public void deleteNoteWarning(User user, String error) {
        System.out.println("Note deletion failed: " + error);
        HomeView homeView = new HomeView();
        homeView.startHomeModule(user);
    }
}