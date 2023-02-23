package opennote;

import dto.User;

public interface OpenNoteModelControllerCallback {

    void openNoteSuccess(String note, User user, String noteId);

    void openNoteWarning(String s, User user);
}
