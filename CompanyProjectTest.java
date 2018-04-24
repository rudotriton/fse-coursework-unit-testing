import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompanyProjectTest {

//    Test by Raigo Jerva
    @org.junit.Test
    public void getPID() {
        CompanyProject cp = new CompanyProject();
        int pid = cp.getPID();
        assertEquals(1, pid);
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void getPTitle() {
        CompanyProject cp = new CompanyProject();
        String title = cp.getPTitle();
        assertEquals("New Project", title);
    }

//    Test by Raigo Jerva
//    set title that is at least 10 characters long
    @org.junit.Test
    public void setPTitle() {
        CompanyProject cp = new CompanyProject();
        cp.setPTitle("Project One");
        String title = cp.getPTitle();
        assertEquals("Project One", title);
    }

//    Test by Raigo Jerva
//    set title that is too short
    @org.junit.Test
    public void setPTitle_invalid() {
        CompanyProject cp = new CompanyProject();
        cp.setPTitle("Project 1");
        String title = cp.getPTitle();
        assertEquals("New Project", title);
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void isContact() {
        CompanyProject cp = new CompanyProject();
        String email = "example@mail.com";
        cp.addContact(email);
        assertTrue(cp.isContact(email));
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void addContact() {
        CompanyProject cp = new CompanyProject();
        String email = "email";
        cp.addContact(email);
    }

    @org.junit.Test
    public void addEmail() {
        fail("No test supplied");
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void getEmailsForPhase_currentPhase() {
        CompanyProject cp = new CompanyProject();
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
        CompanyProject cp = new CompanyProject();
//        advance phase twice to implementation phase
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

    @org.junit.Test
    public void nextPhase() {
        fail("No test supplied");
    }

    @org.junit.Test
    public void getPhaseByName() {
        fail("No test supplied");
    }

    @org.junit.Test
    public void getPhaseByID() {
        fail("No test supplied");
    }

    @org.junit.Test
    public void getProjectContacts() {
        fail("No test supplied");
    }

    @org.junit.Test
    public void toString_test() {
        fail("No test supplied");

    }
}