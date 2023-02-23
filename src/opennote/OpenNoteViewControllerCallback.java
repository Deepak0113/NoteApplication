package opennote;

import dto.User;

public interface OpenNoteViewControllerCallback {

    void openNote(String noteId, User user);

    boolean saveNote(String noteId, User user, String text);
}
