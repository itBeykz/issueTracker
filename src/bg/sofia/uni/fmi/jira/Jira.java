package bg.sofia.uni.fmi.jira;

import bg.sofia.uni.fmi.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.jira.enums.IssueType;
import bg.sofia.uni.fmi.jira.interfaces.IssueTracker;
import bg.sofia.uni.fmi.jira.issues.Issue;

import java.time.LocalDateTime;

public class Jira implements IssueTracker {
    Issue[] issues;

    public Jira(Issue[] issues) {
        this.issues = issues;
    }
    // @Override
    // public Issue[] findAll(Component component, IssueStatus status){
    //}

    @Override
    public Issue[] findAll(Component component, IssuePriority priority) {
        Issue[] issuesFound = new Issue[issues.length];
        int counter = 0;
        for (int i = 0; i < issues.length; i++) {
            if (issues[i] != null && component.getName()
                    .equals(issues[i].getComponent().getName()) &&
                    priority.equals(issues[i].getPriority())) {

                issuesFound[counter++] = issues[i];
            }

        }
        return issuesFound;
    }

    @Override
    public Issue[] findAll(Component component, IssueType type) {
        Issue[] issuesFound = new Issue[issues.length];
        int counter = 0;
        for (int i = 0; i < issues.length; i++) {
            if (issues[i] != null && component.getName()
                    .equals(issues[i].getComponent().getName()) &&
                    type.equals(issues[i].getType())) {

                issuesFound[counter++] = issues[i];
            }

        }
        return issuesFound;
    }

    @Override
    public Issue[] findAll(Component component, IssueResolution resolution) {
        Issue[] issuesFound = new Issue[issues.length];
        int counter = 0;
        for (int i = 0; i < issues.length; i++) {
            if (issues[i] != null && component.getName()
                    .equals(issues[i].getComponent().getName()) &&
                    resolution.equals(issues[i].getResolution())) {

                issuesFound[counter++] = issues[i];
            }

        }
        return issuesFound;
    }

    @Override
    public Issue[] findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime) {
        Issue[] issuesFound = new Issue[issues.length];
        int counter = 0;
        for (int i = 0; i < issues.length; i++) {
            if (issues[i] != null && issues[i].getCreatedAt().isBefore(endTime) && issues[i].getCreatedAt().isAfter(startTime))
                issuesFound[counter++] = issues[i];
        }
        return issuesFound;
    }

    @Override
    public Issue[] findAllBefore(LocalDateTime dueTime) {
        Issue[] issuesFound = new Issue[issues.length];
        int counter = 0;


        return issuesFound;
    }

}
