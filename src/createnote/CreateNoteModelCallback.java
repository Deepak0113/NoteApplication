package createnote;

import dto.User;

public interface CreateNoteModelCallback {
    void createNewNote(String noteTitle, User user);
}