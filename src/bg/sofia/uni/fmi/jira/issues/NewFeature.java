package bg.sofia.uni.fmi.jira.issues;

import bg.sofia.uni.fmi.jira.Component;
import bg.sofia.uni.fmi.jira.User;
import bg.sofia.uni.fmi.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.jira.enums.IssueType;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidReporterException;

import java.time.LocalDateTime;

public class NewFeature extends Issue {
    private LocalDateTime dueTime;

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    public void setDueTime(LocalDateTime dueTime) {
        this.dueTime = dueTime;
    }

    public NewFeature(IssuePriority priority,
                      Component component, User reporter,
                      String description, LocalDateTime dueTime)
            throws InvalidReporterException {
        super(priority, component, reporter, description);
        setType();
        setDueTime(dueTime);

    }

    @Override
    protected void setType() {
        this.type = IssueType.NEW_FEATURE;
    }
}
