package home;

import dto.User;

public interface HomeViewCallback {
    void gotoCreateNote();
    void gotoOpenNote();
    void gotoViewNote(User user);
    void deleteNode();
    void gotoStart();
}