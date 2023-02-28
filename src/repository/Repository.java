package repository;

import dto.Credentials;
import dto.Note;
import dto.User;
import statuscalls.NoteStatusCall;
import statuscalls.UserStatusCall;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public NoteStatusCall createNewNote(String noteTitle, String username){
        String directoryPath = notesPath + username + "/";
        int fileCount = new File(directoryPath).list().length;

        String fileNumber = "" + (fileCount+1);
        String filePath = directoryPath + username+fileNumber + fileExt;

        notesTable.put(username+fileNumber, new Note(username+fileNumber, noteTitle, filePath, new ArrayList<>()));

        Credentials user = userTable.get(username);
        List<String> noteIdList = user.getNoteIds();
        noteIdList.add(username+fileNumber);
        user.setNoteIds(noteIdList);
        userTable.put(username, user);

        createFile(filePath, noteTitle);

        return new NoteStatusCall("SUCCESS", filePath);
    }

    public NoteStatusCall deleteNote(String noteId, String username) {
        String directoryPath = notesPath + username + "/";
        String filePath = directoryPath + noteId + fileExt;

        if(deleteFile(filePath))
            return new NoteStatusCall("DELETED");
        return new NoteStatusCall("NOT EXIST");
    }

    public NoteStatusCall getNotes(String username) {
        List<String> noteIds = userTable.get(username).getNoteIds();

        if(noteIds.size() == 0){
            return new NoteStatusCall("EMPTY");
        }
        return new NoteStatusCall("SUCCESS", noteIds);
    }

    public NoteStatusCall getNote(String noteId, User user) {
        if(!notesTable.containsKey(noteId))
            return new NoteStatusCall("NOT EXIST");
        Note note = notesTable.get(noteId);
        String path = note.getNotePath();
        StringBuilder stringBuilder = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = reader.readLine();
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        
        return new NoteStatusCall("SUCCESS", stringBuilder);
    }

    public NoteStatusCall saveNote(String noteId, User user, String text) {
        Note note = notesTable.get(noteId);
        String titleCurr = note.getNoteTitle();
        String title = text.substring(0, text.indexOf(" "));

//        if(titleCurr.equals(title)){
//            note.setNoteTitle(title.equals("") ? "untitled" : title);
//        }

        String filepath = notesPath + user.getUserName()+"/" + noteId + fileExt;
        writeFile(filepath, text);

        return new NoteStatusCall("SUCCESS");
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
            return new UserStatusCall("SUCCESS", credentials);
        return new UserStatusCall("INCORRECT PASSWORD");
    }


    /*------ FILE HANDLING ------*/

    void createDirectory(String directoryName) {
        new File(notesPath + directoryName).mkdir();
    }

    void createFile(String filePath, String noteTitle){
        try {
            File file = new File(filePath);
            file.createNewFile();
            writeFile(filePath, noteTitle);

        } catch (IOException e) {
        }
    }

    void writeFile(String filePath, String text){
        try{
            PrintWriter printWriter = new PrintWriter(filePath);
            printWriter.write(text+"\n\n");
            printWriter.close();
        } catch (IOException e) {
        }
    }

    boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }
}
