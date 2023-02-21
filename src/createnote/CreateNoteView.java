package createnote;

import java.util.Scanner;

public class CreateNoteView implements CreateNoteViewCallback {
    private final Scanner scanner = new Scanner(System.in);
    private CreateNoteViewControllerCallback createNoteController;

    CreateNoteView() {
        createNoteController = new CreateNoteController(this);
    }

    /*------ NAVIGATION ------*/

    public void startCreateNoteModule(){
        System.out.println("Create Note");
        System.out.println("------------------------------");
    }

    void getNewNoteDetails(){
        System.out.println("Enter note title: ");
        String noteTitle = scanner.nextLine();
    }
}