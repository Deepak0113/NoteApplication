package opennote;

public class OpenNoteModel implements OpenNoteModelCallback {
    OpenNoteModelControllerCallback openNoteController;

    OpenNoteModel(OpenNoteModelControllerCallback openNoteController) {
        this.openNoteController = openNoteController;
    }
}