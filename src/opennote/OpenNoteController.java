package opennote;

import dto.User;

public class OpenNoteController implements OpenNoteViewControllerCallback, OpenNoteModelControllerCallback {
    private OpenNoteViewCallback openNoteView;
    private OpenNoteModelCallback openNoteModel;

    OpenNoteController(OpenNoteViewCallback openNoteView) {
        this.openNoteView = openNoteView;
        openNoteModel = new OpenNoteModel(this);
    }

    @Override
    public void openNote(String noteId, User user) {
        openNoteModel.openNote(noteId, user);
    }

    @Override
    public boolean saveNote(String noteId, User user, String text) {
        return openNoteModel.saveNote(noteId, user, text);
    }

    @Override
    public void openNoteSuccess(String note, User user, String noteId) {
        openNoteView.openNoteSuccess(note, user, noteId);
    }

    @Override
    public void openNoteWarning(String message, User user) {
        openNoteView.openNoteWarning(message, user);
    }
}