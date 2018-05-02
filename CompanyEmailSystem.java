import java.util.*;

public class CompanyEmailSystem {

    public static int GlobalProjectCounter;
    public static String[] ProjectPhases = new String[]{"Feasibility", "Design", "Implementation", "Testing", "Deployment", "Completed"};

    private static ArrayList<CompanyProject> AllProjects;
    private static int currentProjShowing;

    public static void main(String[] args) {

        ///////
        //Startup
        //////
        GlobalProjectCounter = 0;
        AllProjects = new ArrayList<>();

        //////////////
        //example test data
        //////////////

        CompanyProject cp1 = new CompanyProject("TestProject1");
        CompanyProject cp2 = new CompanyProject("TestProject2");
        CompanyProject cp3 = new CompanyProject("TestProject3");
        CompanyProject cp4 = new CompanyProject("TestProject4");

        for (int x = 0; x < 10; x++) {
            CompanyEmail ce = new CompanyEmail("me" + x + "@me.com", "you" + x + "@you.com", "this is a test subject for email" + x, "this is a test message for email " + x);

            switch (x % 3) {
                case 0:
                    cp1.addEmail(ce);
                    break;
                case 1:
                    cp2.addEmail(ce);
                    break;
                case 2:
                    cp3.addEmail(ce);
                    break;
            }
        }
        for (int x = 0; x <= 20; x++) {
            CompanyEmail ce = new CompanyEmail("me" + x + "@me.com", "you" + x + "@you.com", "this is a test subject for email" + x, "this is a test message for email " + x);
            cp4.addEmail(ce);
        }


        AllProjects.add(cp1);
        AllProjects.add(cp2);
        AllProjects.add(cp3);
        AllProjects.add(cp4);

        /// END OF TEST DATA ///

        System.out.println("What do you want to do?\n P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.next();
            try {
                if (currentProjShowing == 0) {
                    if (s.equals("P")) {
                        ListProjects();
                    } else if (s.equals("A")) {
                        AddProject(in);
                    } else if (s.equals("X")) {
                        System.out.println("Goodbye!");
                        break;
                    } else if (Integer.parseInt(s) != -1) {
//                        only access valid projects
                        if (Integer.parseInt(s) <= GlobalProjectCounter && Integer
                                .parseInt(s) > 0) {
//                            first project couldn't be accessed - Raigo
//                            currentProjShowing = Integer.parseInt(s)-1;
                            currentProjShowing = Integer.parseInt(s);
                        } else {
                            System.out.println("There is no project with this ID.");
                        }
                    } //else {
//                        this is never reached, since any value tht is not P,A or X
//                          will be parsed as an int and an exception is thrown - Raigo
//                        System.out.println("Command not recognised");
//                    }
                } else {
                    if (s.equals("A")) {
                        AddEmail(in);
                    } else if (s.equals("L")) {
                        ListEmails(0);
                    } else if (s.equals("F")) {
                        ListPhases();
                    } else if (s.equals("C")) {
                        ListContacts();
                    } else if (s.equals("N")) {
                        ChangeProjectPhase();
                    } else if (s.equals("X")) {
                        currentProjShowing = 0;
                    } else if (Integer.parseInt(s) != -1) {
                        ListEmails(Integer.parseInt(s));
                    } //else {
//                    Once again, this part is never reached
//                        System.out.println("Command not recognised");
//                    }
                }
            } catch (Exception e) {
                System.out.println("Command not recognised");
//                System.out.println("Something went wrong: " + e.toString() + "\n");
            }
            if (currentProjShowing == 0) {
                System.out.println("What do you want to do?\n P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it Software");
            } else {
                System.out.println("What do you want to do?\n L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project");
            }
        }
        in.close();

    }

    private static void ListProjects() {
        for (int x = 0; x < AllProjects.size(); x++) {
            CompanyProject cp = AllProjects.get(x);
            int emailCount = cp.getEmailsForPhase().size();
            System.out.println((x + 1) + ") " + cp.toString() + " - " + emailCount + "emails");
        }
    }

    private static void AddProject(Scanner in) {
        System.out.println("What is the title of the project?");
        in.nextLine(); // to remove read-in bug
        String title = in.nextLine();
        AllProjects.add(new CompanyProject(title));
        System.out.println("[Project added]");
    }

    private static void ListEmails(int phaseToShow) {
//        fix for indexing
        CompanyProject cp = AllProjects.get(currentProjShowing - 1);
        ArrayList<CompanyEmail> projectPhaseEmails = null;
        if (phaseToShow == 0) {
            projectPhaseEmails = cp.getEmailsForPhase();
        } else if ((phaseToShow - 1) <= cp.getPhaseByID()) {
//            phase to show - 1 indexing fix
            projectPhaseEmails = cp.getEmailsForPhase(phaseToShow - 1);
        } else {
            System.out.println("Error: Unknown Phase");
        }
        if (projectPhaseEmails != null) {
            if (phaseToShow == 0) {
                System.out.println(cp.toString());
            } else {
//                phase to show - 1 indexing fix
                System.out.println("[" + ProjectPhases[phaseToShow - 1] + "]");
            }
            System.out.println("\n   From                Subject");
            System.out.println("--------------------------------");
            for (int x = 0; x < projectPhaseEmails.size(); x++) {
                CompanyEmail ce = projectPhaseEmails.get(projectPhaseEmails.size() - x - 1);
                System.out.println((x + 1) + ") " + ce.fromAddress() + " - " + ce.subjectLine());
                if (x == 10) {
                    System.out.println("...");
                    break;
                }
            }
        }
    }

    private static void ListPhases() {
//        indexing fix
//        CompanyProject cp = AllProjects.get(currentProjShowing);
        CompanyProject cp = AllProjects.get(currentProjShowing - 1);
        for (int x = 0; x <= cp.getPhaseByID(); x++) {
            System.out.println((x + 1) + ") " + ProjectPhases[x] + " - " + cp
                    .getEmailsForPhase(x).size() + " Emails");
        }
    }

    private static void ListContacts() {
//        indexing fix
//        CompanyProject cp = AllProjects.get(currentProjShowing);
        CompanyProject cp = AllProjects.get(currentProjShowing - 1);
        ArrayList<String> projectContacts = cp.getProjectContacts();
        for (int x = 0; x < projectContacts.size(); x++) {
            System.out.println((x + 1) + ") " + projectContacts.get(x));
        }
    }

    private static void AddEmail(Scanner in) {
        System.out.println("Which email address is it from?");
        in.nextLine(); //to remove read-in bug
        String fromAddress = in.nextLine();
        System.out.println("Which email address is it to?");
        String toAddress = in.nextLine();
        System.out.println("What is the Subject?");
        String subjectLine = in.nextLine();
        System.out.println("What is the Message?");
        String emailBody = in.nextLine();
//        indexing fix
//        CompanyProject cp = AllProjects.get(currentProjShowing);
        CompanyProject cp = AllProjects.get(currentProjShowing - 1);
        CompanyEmail ce = new CompanyEmail(fromAddress, toAddress, subjectLine, emailBody);
        cp.addEmail(ce);
        System.out.println("[Email added to " + cp.toString() + "]");
    }

    private static void ChangeProjectPhase() {
//        indexing fix
//        CompanyProject cp = AllProjects.get(currentProjShowing);
        CompanyProject cp = AllProjects.get(currentProjShowing - 1);
        if (cp.nextPhase()) {
            System.out.println("[Phase changed: " + cp.toString());
        } else {
            System.out.println("Project already in last phase.");
        }
    }

}

