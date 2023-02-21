package repository;

import dto.Credentials;
import dto.Note;
import dto.User;
import statuscalls.NoteStatusCall;
import statuscalls.UserStatusCall;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Repository {
    private static Repository repository;
    private String notesPath;
    private String dbPath;
    private String fileExt;
    private HashMap<String, Note> notesTable;
    private HashMap<String, Credentials> userTable;

    public static Repository getInstance(){
        if(repository == null){
            repository = new Repository();
            repository.initSetup();
        }

        return repository;
    }

    /*------ INITIALISE SETUP ------*/

    private void initSetup(){
        notesPath = "./src/asserts/notes/";
        dbPath = "./src/asserts/database/";
        fileExt = ".txt";
        notesTable = new HashMap<>();
        userTable = new HashMap<>();
    }


    /*------ NOTES TABLE ------*/

    NoteStatusCall createNewNote(String username){
        String directoryPath = notesPath + username + "/";
        int fileCount = new File(directoryPath).list().length;

        String noteId = "" + (fileCount+1);
        String filePath = directoryPath + noteId + fileExt;
        new File(filePath);

        return new NoteStatusCall("SUCCESS", filePath);
    }

    public NoteStatusCall deleteNote(String noteId, String username){
        String directoryPath = notesPath + username + "/";
        String filePath = directoryPath + noteId + fileExt;

        File file = new File(filePath);

        if(file.delete())
            return new NoteStatusCall("DELETED");
        return new NoteStatusCall("NOT EXIST");
    }

    public NoteStatusCall getNotes(String username) {
        return new NoteStatusCall("");
    }

    /*------ USERS TABLE ------*/

    public UserStatusCall createUser(String username, String email, String password){
        if(userTable.containsKey(username))
            return new UserStatusCall("EXIST");

        Credentials credentials = new Credentials(username, email, password);
        userTable.put(username, credentials);
        createDirectory(username);

        return new UserStatusCall("SUCCESS");
    }

    public UserStatusCall loginUser(String username, String password) {
        if(!userTable.containsKey(username))
            return new UserStatusCall("NOT EXIST");

        Credentials credentials = userTable.get(username);

        if(credentials.getPassword().equals(password))
            return new UserStatusCall("SUCCESS");
        return new UserStatusCall("INCORRECT PASSWORD");
    }


    /*------ FILE HANDLING ------*/

    void createDirectory(String directoryName) {
        new File(notesPath + directoryName).mkdir();
    }
}
