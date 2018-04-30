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
                "[Email added to Proj1 [Feasibility]]" + System.lineSeparator() +
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
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "Proj1 [Feasibility]" + System.lineSeparator() +
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

//    Test by Harirak Srikureja

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

//    Test by Harirak Srikureja
    @org.junit.Test
	public void testMain_addValidProject() {
		 String input = "A" + "\nProj4\n";
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
	
	@org.junit.Test
	public void testMain_addEmailWithBlankFields() {
		 String input = "1" + "\nA\n" + "\n" + "\n" + "\n" + "\n";
		 InputStream in = new ByteArrayInputStream(input.getBytes());
		 System.setIn(in);
		 CompanyEmailSystem.main(new String[] {});

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
				" P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator(),outContent.toString());
		 }
	
//test by Vasilis Ieropoulos
    @org.junit.Test
    public void testmain2_addNewEmail() {
        String input = "P"+"\n1"+"\nF"+"\nN" +"\nC"+"\nL" + "\nA" + "\nfrom@email.com" + "\nto@email.com" +
                "\nsubjectline" + "\nmessage" + "\nX" + "\nX";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[]{});
        assertEquals("What do you want to do?\n" + 
                " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it" + System.lineSeparator() +
                "1) Proj1 [Feasibility] - 4emails"+ System.lineSeparator() +
                "2) Proj2 [Feasibility] - 3emails"+ System.lineSeparator() +
                "3) Proj3 [Feasibility] - 3emails"+ System.lineSeparator() +
                "What do you want to do?"+ System.lineSeparator() +
                 " P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it Software"+ System.lineSeparator()+
                "What do you want to do?\n" + 
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator() +
                "1) Feasibility - 4 Emails"+ System.lineSeparator() +
               "What do you want to do?"+ System.lineSeparator() +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator()+
                "[Phase changed: Proj1 [Design]"+ System.lineSeparator() +
                "What do you want to do?"+ "\n"+
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator()+
               "1) me0@me.com"+ System.lineSeparator() +
               "2) me3@me.com"+ System.lineSeparator() +
               "3) me6@me.com"+ System.lineSeparator() +
               "4) me9@me.com"+ System.lineSeparator() +
               "What do you want to do?"+ "\n"+
               " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project" + System.lineSeparator()+
               "Proj1 [Design]"+ System.lineSeparator() + "\n"+
   				"   From                Subject"+ System.lineSeparator() +
   				"--------------------------------"+ System.lineSeparator() +
   				"What do you want to do?"+ "\n"+
   				" L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project"+ System.lineSeparator()+
                "Which email address is it from?" + System.lineSeparator() +
                "Which email address is it to?" + System.lineSeparator() +
                "What is the Subject?" + System.lineSeparator() +
                "What is the Message?" + System.lineSeparator() +
                "[Email added to Proj1 [Design]]" + System.lineSeparator() +
                "What do you want to do?\n" +
                " L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = " +
                "Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List " +
                "[C]ontacts, X =  E[x]it Project" + System.lineSeparator() + "What do " +
                        "you want to do?\n" + " P =" +
                " List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = " +
                "E[x]it Software" + System.lineSeparator() +  "Goodbye!" + System.lineSeparator(), outContent
                .toString());

    }

    @org.junit.After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }


}
