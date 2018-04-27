import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class CompanyEmailSystemTest{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @org.junit.Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

//    Test by Raigo Jerva
    @org.junit.Test
    public void testMainExit() {

//        inContent = new ByteArrayInputStream("X".getBytes());
//        System.setIn(inContent);
//        CompanyEmailSystem.main(new String[] {});
//        System.out.println(outContent);
        String input = "X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CompanyEmailSystem.main(new String[] {});
        assertEquals("What do you want to do?\n P = List [P]rojects, [num] = Open " +
                "Project [num], A = [A]dd Project, X = E[x]it" +System.lineSeparator() + "Goodbye!" + System
                .lineSeparator(), outContent.toString());
    }
    
    //Test by Harirak Srikureja
    
    	@org.junit.Test
	    public void testMainProjects() {
		//CompanyEmailSystem ios = new CompanyEmailSystem();
		 String input = "P";
		 InputStream in = new ByteArrayInputStream(input.getBytes());
		 System.setIn(in);
		 CompanyEmailSystem.main(new String[] {});

		assertEquals("What do you want to do?\n" + 
				" P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it1) Proj1 [Feasibility] - 4emails\n" + 
				"1) Proj1 [Feasibility] - 4emails\n" + 
				"2) Proj2 [Feasibility] - 3emails\n" + 
				"3) Proj3 [Feasibility] - 3emails\n" + 
				"What do you want to do?\n" + 
				" P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it Software" 
				+System.lineSeparator(),outContent.toString());
		 }
	

    @org.junit.After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }


}
