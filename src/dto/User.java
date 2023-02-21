package dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String email;
    private List<String> noteIds;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.noteIds = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }
}
