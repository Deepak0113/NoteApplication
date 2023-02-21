package deletenote;

public interface DeleteNoteModelControllerCallback {
    void deleteNoteSuccessful();
    void deleteNoteWarning(String error);
}
