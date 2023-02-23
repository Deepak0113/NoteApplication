package deletenote;

import dto.User;
import repository.Repository;
import statuscalls.NoteStatusCall;

public class DeleteNoteModel implements DeleteNoteModelCallback {
    DeleteNoteModelControllerCallback deleteNoteController;

    DeleteNoteModel(DeleteNoteModelControllerCallback deleteNoteController) {
        this.deleteNoteController = deleteNoteController;
    }

    @Override
    public void deleteNode(String noteId, User user) {
        NoteStatusCall noteStatusCall = Repository.getInstance().deleteNote(noteId, user.getUserName());

        switch (noteStatusCall.getStatus()){
            case "DELETED" -> deleteNoteController.deleteNoteSuccessful(user);
            case "NOT EXIST" -> deleteNoteController.deleteNoteWarning(user, "Note doesn't exist");
        }
    }
}