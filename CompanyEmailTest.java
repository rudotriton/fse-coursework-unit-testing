import static org.junit.Assert.*;

import org.junit.Test;

public class CompanyEmailTest {

    // CLARITY -> Added numbering above each test according to the ID's 
    // we had for the functions on our test and bugfixing report from the previous lab assignment.
    // By Alex Melissas & Sam Kendrick	

    // ISSUE 1 -> When setting values in constructor to null, it doesn't work properly. It works as if
    // they were set to null if we set them to the empty string "".

    // ISSUE 2 -> Using set functions when testing get functions

    //ISSUE 3 -> toString using .equals("") fails test (due to null pointer exception being thrown)

    private CompanyEmail cem;

    @org.junit.Before
    public void setup() {
        cem = new CompanyEmail();
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.1
    @org.junit.Test
    public void testBasicConst() {
        assertNull(cem.fromAddress());
        assertNull(cem.toAddress());
        assertNull(cem.emailMessage());
        assertNull(cem.subjectLine());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.2
    @org.junit.Test
    public void testFullConst() {
        cem = new CompanyEmail("haha@ha.com", "lol@xd.com", "hi mom", "hi dad");
        assertEquals("haha@ha.com", cem.fromAddress());
        assertEquals("lol@xd.com", cem.toAddress());
        assertEquals("hi mom", cem.subjectLine());
        assertEquals("hi dad", cem.emailMessage());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.3
    @org.junit.Test
    public void testFromAddress() {
        assertNull(cem.fromAddress());
        cem = new CompanyEmail("haha@ha.com", "", "", "");
        //cem.setFrom("haha@ha.com");
        assertNotNull(cem.fromAddress());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.4
    @org.junit.Test
    public void testToAddress() {
        assertNull(cem.toAddress());
        cem = new CompanyEmail("", "haha@ha.com", "", "");
        //cem.setTo("haha@ha.com");
        assertEquals("haha@ha.com", cem.toAddress());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.5
    @org.junit.Test
    public void testSubjectLine() {
        assertNull(cem.subjectLine());
        cem = new CompanyEmail("", "", "hi mom", "");
        assertEquals("hi mom", cem.subjectLine());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.6
    @org.junit.Test
    public void testEmailMessage() {
        assertNull(cem.emailMessage());
        cem = new CompanyEmail("", "", "", "hi dad");
        assertEquals("hi dad", cem.emailMessage());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.7
    @org.junit.Test
    public void testSetFrom() {
        assertNull(cem.fromAddress());
        cem.setFrom("notanemail");
        assertNull(cem.fromAddress());
        cem.setFrom("stillnotanemail@"); // this would fail because of improper email validation in class
        assertNull(cem.fromAddress());
        cem.setFrom("validemail@site.com");
        assertEquals("validemail@site.com", cem.fromAddress());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.8
    @org.junit.Test
    public void testSetTo() {
        assertNull(cem.toAddress());
        cem.setTo("notanemail");
        assertNull(cem.toAddress());
        cem.setTo("stillnotanemail@"); // this would fail because of improper email
        // validation in class
        assertNull(cem.toAddress());
        cem.setTo("validemail@site.com");
        assertEquals("validemail@site.com", cem.toAddress());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.9
    @org.junit.Test
    public void testSetSubject() {
        assertNull(cem.subjectLine());
        cem.setSubject("this is a subject");
        assertEquals("this is a subject", cem.subjectLine());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.10
    @org.junit.Test
    public void testSetMessage() {
        assertNull(cem.emailMessage());
        cem.setMessage("EMAIL MESSAGE HERE HAHA");
        assertEquals("EMAIL MESSAGE HERE HAHA", cem.emailMessage());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.11
    @org.junit.Test
    public void testIsValid() {
        assertFalse(cem.isValid());
        cem = new CompanyEmail("banana@gmail.com", "", "", "");
        assertFalse(cem.isValid());
        cem = new CompanyEmail("", "banana@gmail.com", "", "");
        assertFalse(cem.isValid());
        cem = new CompanyEmail("", "", "hi mom", "");
        assertFalse(cem.isValid());
        cem = new CompanyEmail("", "", "", "hi dad");
        assertFalse(cem.isValid());
        cem = new CompanyEmail("banana@gmail.com", "banana2@gmail.com", "hi mom", "hi dad");
        assertTrue(cem.isValid());
    }

    // By Alex Melissas & Sam Kendrick
    //Test 1.12
    @org.junit.Test
    public void testToString() {
        assertNull(cem.toString());
        cem.setSubject("");
        assertEquals("[no subject]", cem.toString());
        cem.setSubject("a new subject");
        assertEquals("a new subject", cem.toString());
    }
}
