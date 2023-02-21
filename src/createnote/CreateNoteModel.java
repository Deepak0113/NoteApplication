package createnote;

public class CreateNoteModel implements CreateNoteModelCallback {
    CreateNoteModelControllerCallback createNoteController;

    CreateNoteModel(CreateNoteModelControllerCallback createNoteController) {
        this.createNoteController = createNoteController;
    }
}