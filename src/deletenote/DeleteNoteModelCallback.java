package deletenote;

import dto.User;

public interface DeleteNoteModelCallback {
    void deleteNode(String noteId, User username);
}