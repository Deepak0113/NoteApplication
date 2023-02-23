package viewnote;

import dto.User;

import java.util.List;

public interface ViewNoteViewCallback {
    void viewNotesWarning(User user, String message);
    void viewNoteSuccess(User user, List<String> noteIds);
}