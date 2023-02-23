package opennote;

import dto.User;

public interface OpenNoteModelCallback {

    void openNote(String noteId, User user);

    boolean saveNote(String noteId, User user, String text);
}