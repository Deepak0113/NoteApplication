package deletenote;

import java.util.Scanner;

public class DeleteNoteView implements DeleteNoteViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private DeleteNoteViewControllerCallback deleteNoteController;

    DeleteNoteView() {
        deleteNoteController = new DeleteNoteController(this);
    }

    void deleteNote(String username){
        System.out.println("Delete Note");
        System.out.println("-----------------------------");
        System.out.print("Enter noteID: ");
        String noteId = scanner.nextLine();

        deleteNoteController.deleteNote(noteId, username);
    }

    @Override
    public void deleteNoteSuccessful() {
        System.out.println("Note successfully deleted.");
    }

    @Override
    public void deleteNoteWarning(String error) {
        System.out.println("Note deletion failed: " + error);
    }
}