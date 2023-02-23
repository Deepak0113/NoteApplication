package createnote;

import dto.User;

public interface CreateNoteViewControllerCallback {
    void createNewNote(User user, String noteTitle);
    void chooseOption(User user, int option);
}
