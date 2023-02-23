package statuscalls;

import dto.User;

public class UserStatusCall extends Status{
    User user;

    public UserStatusCall(String status){
        super(status);
    }

    public UserStatusCall(String status, User user){
        super(status);
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }
}
