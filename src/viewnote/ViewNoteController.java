package viewnote;

import dto.User;

import java.util.List;

public class ViewNoteController implements ViewNoteViewControllerCallback, ViewNoteModelControllerCallback {
    private ViewNoteViewCallback viewNoteView;
    private ViewNoteModelCallback viewNoteModel;

    ViewNoteController(ViewNoteViewCallback viewNoteView) {
        this.viewNoteView = viewNoteView;
        viewNoteModel = new ViewNoteModel(this);
    }

    @Override
    public void viewNotes(User user) {
        viewNoteModel.viewNotes(user);
    }

    @Override
    public void viewNotesSuccess(User user, List<String> noteIds) {
        viewNoteView.viewNoteSuccess(user, noteIds);
    }

    @Override
    public void viewNotesWarning(User user, String message) {
        viewNoteView.viewNotesWarning(user, message);
    }
}