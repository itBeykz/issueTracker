package bg.sofia.uni.fmi.jira.issues;

import bg.sofia.uni.fmi.jira.Component;
import bg.sofia.uni.fmi.jira.User;
import bg.sofia.uni.fmi.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.jira.enums.IssueType;
import bg.sofia.uni.fmi.jira.interfaces.IIssue;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidComponentException;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidDescriptionException;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidPriorityException;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidReporterException;

import java.time.LocalDateTime;


public abstract class Issue implements IIssue {

    private static int counter = 0;
    private IssuePriority priority;
    private Component component;
    private User reporter;
    private String description;
    private String id;
    private IssueResolution resolution;
    // private IssueStatus status;
    protected IssueType type;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    public Issue(IssuePriority priority, Component component, User reporter, String description) throws InvalidReporterException {

        validateComponent(component);
        validateDescription(description);
        validateReporter(reporter);
        validateIssuePriority(priority);
        this.id = component.getName() + "-" + generateID();
        this.priority = priority;
        this.component = component;
        this.reporter = reporter;
        this.description = description;
        this.resolution = IssueResolution.UNRESOLVED;
        //this.status=IssueStatus.OPEN;
    }

    private int generateID() {
        return counter++;
    }

    private void validateReporter(User reporter) throws InvalidReporterException{
        if(reporter==null)
            throw new InvalidReporterException("Invalid Reporter");

    }

    private void validateIssuePriority(IssuePriority priority) throws InvalidPriorityException {
if(priority==null)
    throw new InvalidPriorityException("Invalid priority");
    }

    private void validateComponent(Component component) throws InvalidComponentException {
if(component==null)
    throw new InvalidComponentException("Invalid component");
    }

    private void validateDescription(String description) throws InvalidDescriptionException {
if(description==null)
    throw new InvalidDescriptionException("Invalid description");
    }

    @Override
    public void resolve(IssueResolution resolution) {
        setResolution(resolution);
    }


    /* public IssueStatus getStatus() {
         return status;
     }

     public void setStatus(IssueStatus status) {
         this.status = status;
         setLastModifiedAt(LocalDateTime.now());
     }
 */
    public IssuePriority getPriority() {
        return priority;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
        setLastModifiedAt(LocalDateTime.now());
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
        setLastModifiedAt(LocalDateTime.now());
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
        setLastModifiedAt(LocalDateTime.now());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        setLastModifiedAt(LocalDateTime.now());
    }

    public IssueResolution getResolution() {
        return resolution;
    }

    public void setResolution(IssueResolution resolution) {
        this.resolution = resolution;
        setLastModifiedAt(LocalDateTime.now());
    }

    public IssueType getType() {
        return type;
    }

   protected abstract void setType();


    @Override
    public String getId() {

        return this.id;
    }

    public void setId(String id) {

        this.id = id;
        setLastModifiedAt(LocalDateTime.now());
    }


    @Override
    public LocalDateTime getCreatedAt() {

        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        setLastModifiedAt(LocalDateTime.now());
    }


    @Override
    public LocalDateTime getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }
}
