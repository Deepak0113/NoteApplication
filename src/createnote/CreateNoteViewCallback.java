package createnote;

import dto.User;

public interface CreateNoteViewCallback {
    void createNewNote(User user);
    void gotoHome(User user);
    void gotoStart();
    void createNewNoteWarning(User user, String message);

    void createNewNoteSuccess(User user, String filePath);
}