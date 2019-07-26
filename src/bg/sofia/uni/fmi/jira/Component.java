package bg.sofia.uni.fmi.jira;

import java.time.LocalDateTime;

public class Component {
    String name;
    String shortName;
    User creator;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastModification;
    public Component(String name, String shortName, User creator) {
setName(name);
setShortName(shortName);
setCreator(creator);
setDateOfCreation(dateOfCreation);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public User getCreator() {
        return creator;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfLastModification() {
        return dateOfLastModification;
    }

    public void setDateOfLastModification(LocalDateTime dateOfLastModification) {
        this.dateOfLastModification = dateOfLastModification;
    }
}
