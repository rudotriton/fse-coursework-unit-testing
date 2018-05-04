import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompanyProjectTest {

    private CompanyProject cp;

    //    Test by Raigo Jerva
    @org.junit.Before
    public void setup() {
        CompanyEmailSystem.GlobalProjectCounter = 0;
        cp = new CompanyProject();
    }

    //    Test by Raigo Jerva
//    2.1
    @org.junit.Test
    public void constructor_test() {
        CompanyProject project1 = new CompanyProject("Some Project");
        assertEquals("Some Project", project1.getPTitle());
    }

    //    Test by Raigo Jerva
//    2.2
    @org.junit.Test
    public void constructor_test_invalidName() {
        CompanyProject project1 = new CompanyProject("too short");
        assertEquals("New Project", project1.getPTitle());
    }


    //    Test by Raigo Jerva
//     2.3
    @org.junit.Test
    public void getPIDTest() {
        assertEquals(1, cp.getPID());
    }

    //    Test by Raigo Jerva
//    2.4
    @org.junit.Test
    public void getPTitleTest() {
        String title = cp.getPTitle();
        assertEquals("New Project", title);
    }

    //    Test by Raigo Jerva
//    2.5
//    set title that is at least 10 characters long
    @org.junit.Test
    public void setPTitleTest() {
        cp.setPTitle("Project One");
        String title = cp.getPTitle();
        assertEquals("Project One", title);
    }

    //    Test by Raigo Jerva
//    2.6
    @org.junit.Test(expected = NullPointerException.class)
    public void setPTitle_null() {
        cp.setPTitle(null);
        fail("Should have thrown NullPointerException.");
    }

    //    Test by Raigo Jerva
//    2.7
//    set title that is too short
    @org.junit.Test
    public void setPTitle_tooShort() {
        cp.setPTitle("Project 1");
        String title = cp.getPTitle();
        assertEquals("New Project", title);
    }

    //    Test by Raigo Jerva
//    2.8
    @org.junit.Test
    public void isContactTest() {
        String email = "example@mail.com";
        cp.addContact(email);
        assertTrue(cp.isContact(email));
    }

    //    Test by Raigo Jerva
//    2.9
    @org.junit.Test
    public void addContactTest() {
        String email = "example@mail.com";
        cp.addContact(email);
        ArrayList<String> contacts = cp.getProjectContacts();
        assertEquals(email, contacts.get(0));
    }

    //    Test by Raigo Jerva
//    2.10
    @org.junit.Test
    public void addEmail_toSecondPhase() {
        String from = "sender@email.com";
        String to = "receiver@email.com";
        String subject = "test email";
        String message = "email message";

        CompanyEmail ce = new CompanyEmail(from, to, subject, message);
        cp.nextPhase();
        cp.addEmail(ce);
        ArrayList<String> contacts = cp.getProjectContacts();
        assertEquals(from, contacts.get(0));
    }

    //    Test by Raigo Jerva
//    2.11
    @org.junit.Test
    public void addEmail_invalidEmail() {
        String from = "sender@email.com";
        String to = "receiver@email.com";

        String message = "email message";

        CompanyEmail ce = new CompanyEmail(from, to, null, message);
        cp.addEmail(ce);
        ArrayList<String> contacts = cp.getProjectContacts();
        assertEquals(0, contacts.size());
    }

    //    Test by Raigo Jerva
//    2.12
    @org.junit.Test
    public void getEmailsForPhase_currentPhase() {
        String from = "sender@email.com";
        String to = "receiver@email.com";
        String subject = "test email";
        String message = "email message";

        CompanyEmail ce = new CompanyEmail(from, to, subject, message);
        cp.addEmail(ce);
        ArrayList<CompanyEmail> emails = cp.getEmailsForPhase();
        CompanyEmail email = emails.get(0);
        assertEquals(from, email.fromAddress());
        assertEquals(to, email.toAddress());
        assertEquals(subject, email.subjectLine());
        assertEquals(message, email.emailMessage());
    }

    //    Test by Raigo Jerva
//    2.13
    @org.junit.Test
    public void getEmailsForPhase_certainPhase() {
//        advance phase twice to Implementation phase
        cp.nextPhase();
        cp.nextPhase();

        String from = "sender@email.com";
        String to = "receiver@email.com";
        String subject = "test email";
        String message = "email message";
        CompanyEmail ce = new CompanyEmail(from, to, subject, message);
        cp.addEmail(ce);

        ArrayList<CompanyEmail> emails = cp.getEmailsForPhase(2);
        CompanyEmail email = emails.get(0);
        assertEquals(from, email.fromAddress());
        assertEquals(to, email.toAddress());
        assertEquals(subject, email.subjectLine());
        assertEquals(message, email.emailMessage());
    }

    //    Test by Raigo Jerva
//    2.14
    @org.junit.Test
    public void nextPhaseTest() {
        cp.nextPhase();
        assertEquals("Design", cp.getPhaseByName());
    }

    //    Test by Raigo Jerva
//    2.15
    @org.junit.Test
    public void nextPhase_limit() {
        cp.nextPhase(); // phase 2
        cp.nextPhase(); // phase 3
        cp.nextPhase(); // phase 4
        cp.nextPhase(); // phase 5
        cp.nextPhase(); // phase 6
        cp.nextPhase(); // still phase 6
        assertEquals("Completed", cp.getPhaseByName());
    }

    //    Test by Raigo Jerva
//    2.16
    @org.junit.Test
    public void getPhaseByNameTest() {
        assertEquals("Feasibility", cp.getPhaseByName());
    }

    //    Test by Raigo Jerva
//    2.17
    @org.junit.Test
    public void getPhaseByIDTest() {
        assertEquals(0, cp.getPhaseByID());
    }

    //    Test by Raigo Jerva
//    2.18
    @org.junit.Test
    public void getProjectContactsTest() {
        String from = "sender@email.com";
        String to = "receiver@email.com";
        String subject = "test email";
        String message = "email message";

        String from2 = "someOtherSender@mail.com";

        CompanyEmail ce = new CompanyEmail(from, to, subject, message);
        CompanyEmail ce2 = new CompanyEmail(from2, to, subject, message);
        cp.addEmail(ce);
        cp.addEmail(ce2);

        ArrayList<String> contacts = new ArrayList<>();
        contacts.add(from);
        contacts.add(from2);
        assertEquals(contacts, cp.getProjectContacts());

        assertEquals(from, cp.getProjectContacts().get(0));
        assertEquals(from2, cp.getProjectContacts().get(1));
    }

    //    Test by Raigo Jerva
//    2.19
    @org.junit.Test
    public void toString_test() {
        String template = "New Project [Feasibility]";
        assertEquals(template, cp.toString());
    }


}