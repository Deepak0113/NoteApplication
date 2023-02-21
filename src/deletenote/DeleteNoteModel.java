package deletenote;

import repository.Repository;
import statuscalls.NoteStatusCall;

public class DeleteNoteModel implements DeleteNoteModelCallback {
    DeleteNoteModelControllerCallback deleteNoteController;

    DeleteNoteModel(DeleteNoteModelControllerCallback deleteNoteController) {
        this.deleteNoteController = deleteNoteController;
    }

    @Override
    public void deleteNode(String noteId, String username) {
        NoteStatusCall noteStatusCall = Repository.getInstance().deleteNote(noteId, username);

        switch (noteStatusCall.getStatus()){
            case "SUCCESS" -> deleteNoteController.deleteNoteSuccessful();
            case "NOT EXIST" -> deleteNoteController.deleteNoteWarning("Note doesn't exist");
        }
    }
}