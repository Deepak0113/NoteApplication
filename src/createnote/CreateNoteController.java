package createnote;

public class CreateNoteController implements CreateNoteViewControllerCallback, CreateNoteModelControllerCallback {
    private CreateNoteViewCallback createNoteView;
    private CreateNoteModelCallback createNoteModel;

    CreateNoteController(CreateNoteViewCallback createNoteView) {
        this.createNoteView = createNoteView;
        createNoteModel = new CreateNoteModel(this);
    }
}