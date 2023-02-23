package deletenote;

import dto.User;

public class DeleteNoteController implements DeleteNoteViewControllerCallback, DeleteNoteModelControllerCallback {
    private DeleteNoteViewCallback deleteNoteView;
    private DeleteNoteModelCallback deleteNoteModel;

    DeleteNoteController(DeleteNoteViewCallback deleteNoteView) {
        this.deleteNoteView = deleteNoteView;
        deleteNoteModel = new DeleteNoteModel(this);
    }

    @Override
    public void deleteNote(String noteId, User user) {
        deleteNoteModel.deleteNode(noteId, user);
    }

    @Override
    public void deleteNoteSuccessful(User user) {
        deleteNoteView.deleteNoteSuccessful(user);
    }

    @Override
    public void deleteNoteWarning(User user, String error) {
        deleteNoteView.deleteNoteWarning(user, error);
    }
}