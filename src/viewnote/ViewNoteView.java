package viewnote;

public class ViewNoteView implements ViewNoteViewCallback {
    private ViewNoteViewControllerCallback viewNoteController;

    ViewNoteView() {
        viewNoteController = new ViewNoteController(this);
    }

    void viewNotes(String username){
        System.out.println("My notes");
        System.out.println("------------------------------");

        viewNoteController.viewNotes(username);
    }
}