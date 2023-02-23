package deletenote;

import dto.User;

public interface DeleteNoteViewControllerCallback {
    void deleteNote(String noteId, User username);
}
