import java.lang.reflect.Array;
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

    @org.junit.Test
    public void constructor_test() {
        CompanyProject project1 = new CompanyProject(null);
//        CompanyProject project2 = new CompanyProject("1");
        assertNull(project1.getPTitle());
    }


//    Test by Raigo Jerva
    @org.junit.Test
    public void getPID() {
        assertEquals(1, cp.getPID());
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void getPTitle() {
        String title = cp.getPTitle();
        assertEquals("New Project", title);
    }

//    Test by Raigo Jerva
//    set title that is at least 10 characters long
    @org.junit.Test
    public void setPTitle() {
        cp.setPTitle("Project One");
        String title = cp.getPTitle();
        assertEquals("Project One", title);
    }

//    Test by Raigo Jerva
    @org.junit.Test(expected = NullPointerException.class)
    public void setPTitle_null() {
        cp.setPTitle(null);
        String title = cp.getPTitle();
        assertEquals("Project One", title);
    }

//    Test by Raigo Jerva
//    set title that is too short
    @org.junit.Test
    public void setPTitle_tooShort() {
        cp.setPTitle("Project 1");
        String title = cp.getPTitle();
        assertEquals("New Project", title);
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void isContact() {
        String email = "example@mail.com";
        cp.addContact(email);
        assertTrue(cp.isContact(email));
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void addContact() {
        String email = "example@mail.com";
        cp.addContact(email);
        ArrayList<String> contacts = cp.getProjectContacts();
        assertEquals(email, contacts.get(0));
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void addEmail() {
        String from = "sender@email.com";
        String to = "receiver@email.com";
        String subject = "test email";
        String message = "email message";

        CompanyEmail ce = new CompanyEmail(from, to, subject, message);
        cp.addEmail(ce);
        ArrayList<String> contacts = cp.getProjectContacts();
        assertEquals(from, contacts.get(0));
    }

//    Test by Raigo Jerva
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

        ArrayList<CompanyEmail> emails = cp.getEmailsForPhase(3);
        CompanyEmail email = emails.get(0);
        assertEquals(from, email.fromAddress());
        assertEquals(to, email.toAddress());
        assertEquals(subject, email.subjectLine());
        assertEquals(message, email.emailMessage());
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void nextPhase() {
        cp.nextPhase();
        assertEquals("Design", cp.getPhaseByName());
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void getPhaseByName() {
        assertEquals("Feasibility", cp.getPhaseByName());
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void getPhaseByID() {
        assertEquals(1, cp.getPhaseByID());
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void getProjectContacts() {
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
    @org.junit.Test
    public void toString_test() {
        String template = "New Project [Feasibility]";
        assertEquals(template, cp.toString());
    }
}