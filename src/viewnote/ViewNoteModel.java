package viewnote;

import dto.User;
import repository.Repository;
import statuscalls.NoteStatusCall;

public class ViewNoteModel implements ViewNoteModelCallback {
    ViewNoteModelControllerCallback viewNoteController;

    ViewNoteModel(ViewNoteModelControllerCallback viewNoteController) {
        this.viewNoteController = viewNoteController;
    }

    @Override
    public void viewNotes(User user) {
        NoteStatusCall noteStatusCall = Repository.getInstance().getNotes(user.getUserName());

        switch (noteStatusCall.getStatus()){
            case "SUCCESS" -> viewNoteController.viewNotesSuccess(user, noteStatusCall.getNoteIds());
            case "EMPTY" -> viewNoteController.viewNotesWarning(user, "There are no notes");
        }
    }
}