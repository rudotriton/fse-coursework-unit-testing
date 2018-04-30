import static org.junit.Assert.*;

public class CompanyEmailTest {

    private CompanyEmail cem;

    @org.junit.Before
    public void setup() {
        cem = new CompanyEmail();
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testBasicConst() {
        assertNull(cem.fromAddress());
        assertNull(cem.toAddress());
        assertNull(cem.emailMessage());
        assertNull(cem.subjectLine());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testFullConst() {
        cem = new CompanyEmail("haha@ha.com", "lol@xd.com", "hi mom", "im dumb");
        assertEquals("haha@ha.com", cem.fromAddress());
        assertEquals("lol@xd.com", cem.toAddress());
        assertEquals("hi mom", cem.subjectLine());
        assertEquals("im dumb", cem.emailMessage());
    }

//		CompanyEmail goodConstructor = new CompanyEmail("haha@ha.com","lol@xd.com","hi mom","im dumb");
//			assertTrue(goodConstructor.fromAddress().matches(EMAIL_VERIFICATION));
//			assertTrue(goodConstructor.toAddress().matches(EMAIL_VERIFICATION));
//		CompanyEmail badConstructor = new CompanyEmail("invalid","notanemail","parrot","poop");
//			assertFalse(badConstructor.fromAddress().matches(EMAIL_VERIFICATION));
//			assertFalse(badConstructor.toAddress().matches(EMAIL_VERIFICATION));
//		CompanyEmail halfbadConstructor = new CompanyEmail("valid@email.com","invalid","parrot","poop");
//			assertTrue(halfbadConstructor.fromAddress().matches(EMAIL_VERIFICATION));
//			assertFalse(halfbadConstructor.toAddress().matches(EMAIL_VERIFICATION));
//		CompanyEmail sndhalfbadConstructor = new CompanyEmail("invalid","valid@email.com","parrot","poop");
//			assertFalse(sndhalfbadConstructor.fromAddress().matches(EMAIL_VERIFICATION));
//			assertTrue(sndhalfbadConstructor.toAddress().matches(EMAIL_VERIFICATION));

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testFromAddress() {
        assertNull(cem.fromAddress());
        //cem = new CompanyEmail("haha@ha.com",null,null,null);
        // NOTE: FIX THE FULL CONSTRUCTOR
        cem.setFrom("haha@ha.com");
        assertNotNull(cem.fromAddress());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testToAddress() {
        assertNull(cem.toAddress());
        //cem = new CompanyEmail(null,"haha@ha.com",null,null);
        cem.setTo("haha@ha.com");
        assertEquals("haha@ha.com", cem.toAddress());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testSubjectLine() {
        assertNull(cem.subjectLine());
        cem = new CompanyEmail("haha@ha.com", "lol@xd.com", "hi mom", "hi dad");
        assertEquals("hi mom", cem.subjectLine());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testEmailMessage() {
        assertNull(cem.emailMessage());
        cem = new CompanyEmail("haha@ha.com", "lol@xd.com", "hi mom", "hi dad");
        assertEquals("hi dad", cem.emailMessage());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testSetFrom() {
        assertNull(cem.fromAddress());
        cem.setFrom("noatsignhere");
        assertNull(cem.fromAddress());
        cem.setFrom("atsign@at.com");
        assertEquals("atsign@at.com", cem.fromAddress());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testSetTo() {
        assertNull(cem.toAddress());
        cem.setTo("noatsignhere");
        assertNull(cem.toAddress());
        cem.setTo("atsign@at.com");
        assertEquals("atsign@at.com", cem.toAddress());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testSetSubject() {
        assertNull(cem.subjectLine());
        cem.setSubject("this is a subject");
        assertEquals("this is a subject", cem.subjectLine());
    }

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testSetMessage() {
        assertNull(cem.emailMessage());
        cem.setMessage("EMAIL MESSAGE HERE HAHA");
        assertEquals("EMAIL MESSAGE HERE HAHA", cem.emailMessage());
    }

    //    Test by Sam Kendrick & Alex Melissas
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

    //    Test by Sam Kendrick & Alex Melissas
    @org.junit.Test
    public void testToString() {
        //System.out.println(cem.toString());
        //assertNull(cem.toString());		test should fail when subjectLine is null, but assertNull not working on output
        cem.setSubject("");
        assertEquals("[no subject]", cem.toString());
        //assertNotEquals("a subject", cem.toString());
        cem.setSubject("a new subject");
        assertEquals("a new subject", cem.toString());

    }

}
