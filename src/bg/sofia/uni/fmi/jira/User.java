package bg.sofia.uni.fmi.jira;

import java.time.LocalDateTime;

public class User {
    String userName;
    LocalDateTime dateOfCreation;

    public User(String userName) {
        setDateOfCreation(dateOfCreation);
        setUserName(userName);
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public LocalDateTime getDateOfCreation(){
        return this.getDateOfCreation();
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
