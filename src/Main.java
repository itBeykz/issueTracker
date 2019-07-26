import bg.sofia.uni.fmi.jira.Component;
import bg.sofia.uni.fmi.jira.Jira;
import bg.sofia.uni.fmi.jira.User;
import bg.sofia.uni.fmi.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.jira.interfaces.IssueTracker;
import bg.sofia.uni.fmi.jira.issues.Bug;
import bg.sofia.uni.fmi.jira.issues.Issue;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidReporterException;

public class Main {

    public static void main(String[] args) throws InvalidReporterException {
        User ivan = new User("Ivan");
        User pesho = new User("Pesho");
        Component peshosComponent = new Component("Pesho", "pc", pesho);
        Issue[] issues = new Issue[2];
        issues[0] = new Bug(IssuePriority.MAJOR, peshosComponent, ivan, "Big Bug");
        issues[1] = new Bug(IssuePriority.CRITICAL, peshosComponent, ivan, "Bigger Bug");
        IssueTracker petio = new Jira(issues);
    }
}
