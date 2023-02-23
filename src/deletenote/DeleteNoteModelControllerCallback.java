package deletenote;

import dto.User;

public interface DeleteNoteModelControllerCallback {
    void deleteNoteSuccessful(User user);
    void deleteNoteWarning(User user, String error);
}
