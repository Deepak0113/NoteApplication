package dto;

import java.util.List;

public class Note {
    String noteId;
    String noteTitle;
    String notePath;
    List<String> noteKeyWords;

    public String getNoteId() {
        return noteId;
    }

    public String getNotePath() {
        return notePath;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public List<String> getNoteKeyWords() {
        return noteKeyWords;
    }
}
