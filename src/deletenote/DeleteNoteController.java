package deletenote;

public class DeleteNoteController implements DeleteNoteViewControllerCallback, DeleteNoteModelControllerCallback {
    private DeleteNoteViewCallback deleteNoteView;
    private DeleteNoteModelCallback deleteNoteModel;

    DeleteNoteController(DeleteNoteViewCallback deleteNoteView) {
        this.deleteNoteView = deleteNoteView;
        deleteNoteModel = new DeleteNoteModel(this);
    }

    @Override
    public void deleteNote(String noteId, String username) {
        deleteNoteModel.deleteNode(noteId, username);
    }

    @Override
    public void deleteNoteSuccessful() {
        deleteNoteView.deleteNoteSuccessful();
    }

    @Override
    public void deleteNoteWarning(String error) {
        deleteNoteView.deleteNoteWarning(error);
    }
}