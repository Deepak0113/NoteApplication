package statuscalls;

import dto.User;

public class UserStatusCall {
    String status;
    User user;

    public UserStatusCall(String status){
        this.status = status;
    }

    public UserStatusCall(String status, User user){
        this.status = status;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }
}
