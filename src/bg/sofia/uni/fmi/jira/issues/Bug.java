package bg.sofia.uni.fmi.jira.issues;

import bg.sofia.uni.fmi.jira.Component;
import bg.sofia.uni.fmi.jira.User;
import bg.sofia.uni.fmi.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidReporterException;

import static bg.sofia.uni.fmi.jira.enums.IssueType.BUG;

public class Bug extends Issue{


    public Bug(IssuePriority priority, Component component, User reporter, String description) throws InvalidReporterException {
        super(priority,component,reporter,description);
        setType();

    }

    @Override
    protected void setType(){
        this.type=BUG;
    }
}
