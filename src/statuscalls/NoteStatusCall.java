package statuscalls;

import java.util.List;

public class NoteStatusCall extends Status{
    String filePath;
    List<String> noteIds;
    String note;

    public NoteStatusCall(String status){
        super(status);
    }

    public NoteStatusCall(String status, String filePath){
        super(status);
        this.filePath = filePath;
    }

    public NoteStatusCall(String status, List<String> noteIds){
        super(status);
        this.noteIds = noteIds;
    }

    public NoteStatusCall(String status, StringBuilder stringBuilder){
        super(status);
        this.note = stringBuilder.toString();
    }

    public String getStatus() {
        return status;
    }

    public String getFilePath() {
        return filePath;
    }

    public List<String> getNoteIds() {
        return noteIds;
    }

    public String getNote() {
        return note;
    }
}
