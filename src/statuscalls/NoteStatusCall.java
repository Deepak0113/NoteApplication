package statuscalls;

public class NoteStatusCall {
    String status;
    String filePath;

    public NoteStatusCall(String status){
        this.status = status;
    }

    public NoteStatusCall(String status, String filePath){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
