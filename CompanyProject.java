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
//        project  should start with phase: feasibility
//        ProjectPhase = 1;
//        bug fix by Raigo Jerva
        ProjectPhase = 0;
        ProjectEmails[ProjectPhase] = new ArrayList<CompanyEmail>();
    }

    public CompanyProject(String pTitle) {
        CompanyEmailSystem.GlobalProjectCounter++;
        PID = CompanyEmailSystem.GlobalProjectCounter;
        PTitle = pTitle;
        ProjectContacts = new ArrayList<>();
//        project  should start with phase: feasibility
//        ProjectPhase = 1;
//        bug fix by Raigo Jerva
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

//    Since phase 1 is at index 0, then the parameter is reduced by 1
    public ArrayList<CompanyEmail> getEmailsForPhase(int thePhase) {
        return ProjectEmails[thePhase - 1];
    }

    public boolean nextPhase() {
        ProjectPhase++;
        if (ProjectPhase > CompanyEmailSystem.ProjectPhases.length) {
            return false;
        } else {
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
