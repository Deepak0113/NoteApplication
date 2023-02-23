package opennote;

import dto.User;

public interface OpenNoteViewCallback {

    void openNoteSuccess(String note, User user, String noteId);

    void openNoteWarning(String message, User user);
}