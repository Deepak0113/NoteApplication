package opennote;

public class OpenNoteController implements OpenNoteViewControllerCallback, OpenNoteModelControllerCallback {
    private OpenNoteViewCallback openNoteView;
    private OpenNoteModelCallback openNoteModel;

    OpenNoteController(OpenNoteViewCallback openNoteView) {
        this.openNoteView = openNoteView;
        openNoteModel = new OpenNoteModel(this);
    }
}