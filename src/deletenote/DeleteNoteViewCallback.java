package deletenote;

public interface DeleteNoteViewCallback {
    void deleteNoteSuccessful();
    void deleteNoteWarning(String error);
}