package viewnote;

import dto.User;
import home.HomeView;

import java.util.List;

public class ViewNoteView implements ViewNoteViewCallback {
    private final ViewNoteViewControllerCallback viewNoteController;

    public ViewNoteView() {
        viewNoteController = new ViewNoteController(this);
    }

    public void startViewNotesModule(User user){
        System.out.println("\nMy notes");
        System.out.println("------------------------------");
        viewNoteController.viewNotes(user);
    }

    @Override
    public void viewNoteSuccess(User user, List<String> noteIds) {
        int count = 0;
        for(String noteId: noteIds){
            System.out.print(noteId+" ");
            count++;
            if(count%10 == 0) {
                System.out.println();
                count=0;
            }
        }
        gotoHomeModule(user);
    }

    @Override
    public void viewNotesWarning(User user, String message) {
        System.out.println(message);
        gotoHomeModule(user);
    }

    /*------ NAVIGATION ------*/

    private void gotoHomeModule(User user){
        HomeView homeView = new HomeView();
        homeView.startHomeModule(user);
    }
}