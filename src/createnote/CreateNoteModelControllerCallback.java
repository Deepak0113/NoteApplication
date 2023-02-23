package createnote;

import dto.User;

public interface CreateNoteModelControllerCallback {

    void createNewNoteSuccess(User user, String filePath);
}