package viewnote;

import repository.Repository;
import statuscalls.NoteStatusCall;

public class ViewNoteModel implements ViewNoteModelCallback {
    ViewNoteModelControllerCallback viewNoteController;

    ViewNoteModel(ViewNoteModelControllerCallback viewNoteController) {
        this.viewNoteController = viewNoteController;
    }

    @Override
    public void viewNotes(String username) {
        NoteStatusCall noteStatusCall = Repository.getInstance().getNotes(username);
    }
}