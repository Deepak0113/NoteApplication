package viewnote;

import dto.User;

import java.util.List;

public interface ViewNoteModelControllerCallback {
    void viewNotesWarning(User user, String message);
    void viewNotesSuccess(User user, List<String> noteIds);
}
