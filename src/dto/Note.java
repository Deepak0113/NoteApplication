package dto;

import java.util.List;

public class Note {
    private String noteId;
    private String noteTitle;
    private String notePath;
    private List<String> noteKeyWords;

    public Note(String noteId, String noteTitle, String notePath, List<String> noteKeyWords) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.notePath = notePath;
        this.noteKeyWords = noteKeyWords;
    }

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

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
}
