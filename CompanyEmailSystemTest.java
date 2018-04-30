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
    public void testMainExit() {
        String input = "X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() + "Goodbye!" + System
                .lineSeparator(), outContent.toString());
    }

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
                "[Email added to Proj1 [Feasibility]]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                        "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() +  "Goodbye!" + System.lineSeparator(), outContent
                .toString());

    }

//  Test by Harirak Srikureja

    @org.junit.Test
    public void testMainProjects() {
        String input = "P";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "1) Proj1 [Feasibility] - 4emails" + System.lineSeparator() +
                "2) Proj2 [Feasibility] - 3emails" + System.lineSeparator() +
                "3) Proj3 [Feasibility] - 3emails" + System.lineSeparator() +
                "What do you want to do?\n" +
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it Software"
                + System.lineSeparator(), outContent.toString());
    }

    @org.junit.Test
	public void testMain_addNamelessProject() {
		 String input = "A" + "\n\n";
		 InputStream in = new ByteArrayInputStream(input.getBytes());
		 System.setIn(in);
		 CompanyEmailSystem.main(new String[] {});
         assertEquals("What do you want to do?\n" + 
				" P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator()
				+ "What is the title of the project?" + System.lineSeparator() +
				"[Project added]" + System.lineSeparator() +
				"What do you want to do?\n" + 
				" P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator(),outContent.toString());
		 }

    @org.junit.After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }


}
