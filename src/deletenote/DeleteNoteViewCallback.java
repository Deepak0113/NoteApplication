package deletenote;

import dto.User;

public interface DeleteNoteViewCallback {
    void deleteNoteSuccessful(User user);
    void deleteNoteWarning(User user, String error);
}