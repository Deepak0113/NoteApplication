package opennote;

import dto.User;
import repository.Repository;
import statuscalls.NoteStatusCall;

public class OpenNoteModel implements OpenNoteModelCallback {
    OpenNoteModelControllerCallback openNoteController;

    OpenNoteModel(OpenNoteModelControllerCallback openNoteController) {
        this.openNoteController = openNoteController;
    }

    @Override
    public void openNote(String noteId, User user) {
        NoteStatusCall noteStatusCall = Repository.getInstance().getNote(noteId, user);

        switch(noteStatusCall.getStatus()){
            case "SUCCESS" -> openNoteController.openNoteSuccess(noteStatusCall.getNote(), user, noteId);
            case "NOT EXIST" -> openNoteController.openNoteWarning("Note does not exist!", user);
        }
    }

    @Override
    public boolean saveNote(String noteId, User user, String text) {
        NoteStatusCall noteStatusCall = Repository.getInstance().saveNote(noteId, user, text);

        switch (noteStatusCall.getStatus()){
            case "SUCCESS" -> {return true;}
        }
        return false;
    }
}