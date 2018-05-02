import java.util.ArrayList;

public class CompanyProject {
    private int PID;
    private String PTitle;
    private ArrayList<String> ProjectContacts;
    private int ProjectPhase;
    private ArrayList[] ProjectEmails = new ArrayList[6];

    public CompanyProject() {
        CompanyEmailSystem.GlobalProjectCounter++;
        PID = CompanyEmailSystem.GlobalProjectCounter;
        PTitle = "New Project";
        ProjectContacts = new ArrayList<>();
//        ProjectPhase = 1;
        ProjectPhase = 0;
        ProjectEmails[ProjectPhase] = new ArrayList<CompanyEmail>();
    }

    public CompanyProject(String pTitle) {
        CompanyEmailSystem.GlobalProjectCounter++;
        PID = CompanyEmailSystem.GlobalProjectCounter;
//        pTitle is not forced to be more than 10 characters - Raigo
//        PTitle = pTitle;
        setPTitle(pTitle);
        ProjectContacts = new ArrayList<>();
//        ProjectPhase = 1;
        ProjectPhase = 0;
        ProjectEmails[ProjectPhase] = new ArrayList<CompanyEmail>();
    }

    public int getPID() {
        return PID;
    }

    public String getPTitle() {
        return PTitle;
    }

    public void setPTitle(String pTitle) {
        if (pTitle.length() > 10 ) {
            PTitle = pTitle;
        } else {
            PTitle = "New Project";
        }
    }

    public boolean isContact(String emailAddress) {
        return ProjectContacts.contains(emailAddress);
    }

    public void addContact(String emailAddress) {
        ProjectContacts.add(emailAddress);
    }

    public void addEmail(CompanyEmail newEmail) {
        if (newEmail.isValid()) {
            ProjectEmails[ProjectPhase].add(newEmail);
            if (ProjectContacts.contains(newEmail.fromAddress())) {
                //do nothing
            } else {
                ProjectContacts.add(newEmail.fromAddress());
            }
        }
    }

    public ArrayList<CompanyEmail> getEmailsForPhase() {
        return ProjectEmails[ProjectPhase];
    }

    public ArrayList<CompanyEmail> getEmailsForPhase(int thePhase) {
        return ProjectEmails[thePhase];
    }

    public boolean nextPhase() {
        if (ProjectPhase >= CompanyEmailSystem.ProjectPhases.length - 1) {
            return false;
        } else {
            ProjectPhase++;
//            create an arrayList for emails for the phase - Raigo
            ProjectEmails[ProjectPhase] = new ArrayList<CompanyEmail>();
            return true;
        }
    }

    public String getPhaseByName() {
        return CompanyEmailSystem.ProjectPhases[ProjectPhase];
    }

    public int getPhaseByID() {
        return ProjectPhase;
    }

    public ArrayList<String> getProjectContacts() {
        return ProjectContacts;
    }

    public String toString() {
        return PTitle + " [" + getPhaseByName() + "]";
    }
}
