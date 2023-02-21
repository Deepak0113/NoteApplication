package viewnote;

public class ViewNoteController implements ViewNoteViewControllerCallback, ViewNoteModelControllerCallback {
    private ViewNoteViewCallback viewNoteView;
    private ViewNoteModelCallback viewNoteModel;

    ViewNoteController(ViewNoteViewCallback viewNoteView) {
        this.viewNoteView = viewNoteView;
        viewNoteModel = new ViewNoteModel(this);
    }

    @Override
    public void viewNotes(String username) {
        viewNoteModel.viewNotes(username);
    }
}