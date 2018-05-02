import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class CompanyEmailSystemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @org.junit.Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testMain_invalidCommand() {
        String input = "J" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "Command not recognised" + System.lineSeparator() +
                "What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it Software" + System
                .lineSeparator() +
                "Goodbye!" + System.lineSeparator(), outContent.toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testMainExit() {
        String input = "X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() + "Goodbye!" + System
                .lineSeparator(), outContent.toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testMain_exitFromProject() {
        String input = "1" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd " +
                "Project, X = E[x]it Software" + System.lineSeparator() + "Goodbye!" + System
                .lineSeparator(), outContent.toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testMain_invalidProjectSelect() {
        String input = "5" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "There is no project with this ID." + System.lineSeparator() +
                "What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it Software" + System
                .lineSeparator() +
                "Goodbye!" + System.lineSeparator(), outContent.toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testmain_addNewEmail() {
        String input = "1" + "\nA" + "\nfrom@email.com" + "\nto@email.com" +
                "\nsubjectline" + "\nmessage" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "Which email address is it from?" + System.lineSeparator() +
                "Which email address is it to?" + System.lineSeparator() +
                "What is the Subject?" + System.lineSeparator() +
                "What is the Message?" + System.lineSeparator() +
                "[Email added to TestProject1 [Feasibility]]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testmain_ListEmails() {
        String input = "1" + "\nL" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "TestProject1 [Feasibility]" + System.lineSeparator() +
                "\n   From                Subject" + System.lineSeparator() +
                "--------------------------------" + System.lineSeparator() +
                "1) me9@me.com - this is a test subject for email9" + System.lineSeparator() +
                "2) me6@me.com - this is a test subject for email6" + System
                .lineSeparator() +
                "3) me3@me.com - this is a test subject for email3" + System.lineSeparator() +
                "4) me0@me.com - this is a test subject for email0" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testmain_ListEmailsForCertainPhase() {
        String input = "1" + "\n1" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "[Feasibility]" + System.lineSeparator() +
                "\n   From                Subject" + System.lineSeparator() +
                "--------------------------------" + System.lineSeparator() +
                "1) me9@me.com - this is a test subject for email9" + System.lineSeparator() +
                "2) me6@me.com - this is a test subject for email6" + System
                .lineSeparator() +
                "3) me3@me.com - this is a test subject for email3" + System.lineSeparator() +
                "4) me0@me.com - this is a test subject for email0" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testmain_ListEmailsForInvalidPhase() {
        String input = "1" + "\n2" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "Error: Unknown Phase" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testmain_ListEmailsLimit() {
        String input = "4" + "\nL" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +

                "TestProject4 [Feasibility]" + System.lineSeparator() +
                "\n   From                Subject" + System.lineSeparator() +
                "--------------------------------" + System.lineSeparator() +
                "1) me20@me.com - this is a test subject for email20" + System.lineSeparator() +
                "2) me19@me.com - this is a test subject for email19" + System.lineSeparator() +
                "3) me18@me.com - this is a test subject for email18" + System.lineSeparator() +
                "4) me17@me.com - this is a test subject for email17" + System.lineSeparator() +
                "5) me16@me.com - this is a test subject for email16" + System.lineSeparator() +
                "6) me15@me.com - this is a test subject for email15" + System.lineSeparator() +
                "7) me14@me.com - this is a test subject for email14" + System.lineSeparator() +
                "8) me13@me.com - this is a test subject for email13" + System.lineSeparator() +
                "9) me12@me.com - this is a test subject for email12" + System.lineSeparator() +
                "10) me11@me.com - this is a test subject for email11" + System.lineSeparator() +
                "11) me10@me.com - this is a test subject for email10" + System.lineSeparator() +
                "..." + System.lineSeparator() +


                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }


    //    Test by Raigo Jerva
    @org.junit.Test
    public void testmain_ListPhasefolder() {
        String input = "1" + "\nF" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "1) Feasibility - 4 Emails" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }

    //    Test by Raigo Jerva
    @org.junit.Test
    public void testmain_ListContacts() {
        String input = "1" + "\nC" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "1) me0@me.com" + System.lineSeparator() +
                "2) me3@me.com" + System.lineSeparator() +
                "3) me6@me.com" + System.lineSeparator() +
                "4) me9@me.com" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }

    //  Test by Harirak Srikureja
    @org.junit.Test
    public void testMainProjects() {
        String input = "P" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "1) TestProject1 [Feasibility] - 4emails" + System.lineSeparator() +
                "2) TestProject2 [Feasibility] - 3emails" + System.lineSeparator() +
                "3) TestProject3 [Feasibility] - 3emails" + System.lineSeparator() +
                "4) TestProject4 [Feasibility] - 21emails" + System.lineSeparator() +
                "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it Software"
                + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent.toString());
    }

    //    Test by Harirak Srikureja
    @org.junit.Test
    public void testMain_addNamelessProject() {
        String input = "A" + "\n\n" + "\nP" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator()
                + "What is the title of the project?" + System.lineSeparator() +
                "[Project added]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() +
                "1) TestProject1 [Feasibility] - 4emails" + System.lineSeparator() +
                "2) TestProject2 [Feasibility] - 3emails" + System.lineSeparator() +
                "3) TestProject3 [Feasibility] - 3emails" + System.lineSeparator() +
                "4) TestProject4 [Feasibility] - 21emails" + System.lineSeparator() +
                "5) New Project [Feasibility] - 0emails" + System.lineSeparator() +
                "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() +
                "Goodbye!" + System.lineSeparator(), outContent.toString());
    }

    //    Test by Harirak Srikureja
    @org.junit.Test
    public void testMain_addValidProject() {
        String input = "A" + "\nProj4\n" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator()
                + "What is the title of the project?" + System.lineSeparator() +
                "[Project added]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent.toString());
    }

    //    Test by Harirak Srikureja
    @org.junit.Test
    public void testMain_addEmailWithBlankFields() {
        String input = "1" + "\nA\n" + "\n" + "\n" + "\n" + "\n" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});

        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "Which email address is it from?" + System.lineSeparator() +
                "Which email address is it to?" + System.lineSeparator() +
                "What is the Subject?" + System.lineSeparator() +
                "What is the Message?" + System.lineSeparator() +
                "[Email added to TestProject1 [Feasibility]]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move" +
                " to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "What do you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() + "Goodbye!" + System.lineSeparator(), outContent
                .toString());
    }

    //test by Vasilis Ieropoulos
    @org.junit.Test
    public void testmain_projNextPhase() {
        String input = "1" + "\nN" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" + " L = [L]ist Emails, A = [A]dd Email, F =" +
                " List Phase [F]olders, N = Move to [N]ext Phase, [num] = List " +
                "Emails in Phase [num], C = List [C]ontacts, X =  E[x]it " +
                "Project" + System.lineSeparator() +
                "[Phase changed: TestProject1 [Design]" + System.lineSeparator() + "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System
                .lineSeparator() + "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd " +
                "Project, X = E[x]it Software" + System.lineSeparator() +
                "Goodbye!" + System.lineSeparator(), outContent.toString());

    }

    //test by Vasilis Ieropoulos
    @org.junit.Test
    public void testmain_projNextPhaseLimit() {
        String input = "1" + "\nN" + "\nN" + "\nN" + "\nN" + "\nN" + "\nN" + "\nX" +
                "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X" +
                " = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" + " L = [L]ist Emails, A = [A]dd Email, F =" +
                " List Phase [F]olders, N = Move to [N]ext Phase, [num] = List " +
                "Emails in Phase [num], C = List [C]ontacts, X =  E[x]it " +
                "Project" + System.lineSeparator() +
                "[Phase changed: TestProject1 [Design]" + System.lineSeparator() + "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System
                .lineSeparator() +
                "[Phase changed: TestProject1 [Implementation]" + System.lineSeparator
                () + "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System
                .lineSeparator() +
                "[Phase changed: TestProject1 [Testing]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System
                .lineSeparator() +
                "[Phase changed: TestProject1 [Deployment]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System
                .lineSeparator() +
                "[Phase changed: TestProject1 [Completed]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "Project already in last phase." + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders," +
                " N = Move to [N]ext Phase, [num] = List Emails in Phase [num]," +
                " C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd " +
                "Project, X = E[x]it Software" + System.lineSeparator() +
                "Goodbye!" + System.lineSeparator(), outContent.toString());

    }

    @org.junit.After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }


}
