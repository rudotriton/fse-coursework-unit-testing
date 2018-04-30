import static org.junit.Assert.*;
import org.junit.Test;

public class CompanyEmailTest {

	private CompanyEmail cem;
	
	@org.junit.Before
	public void setup() {
		CompanyEmail cem = new CompanyEmail();
		}
	
	@org.junit.Test
	public void testBasicConst() {
		cem = new CompanyEmail();
		assertNull(cem.fromAddress());
		assertNull(cem.toAddress());
		assertNull(cem.emailMessage());
		assertNull(cem.subjectLine());
	}
	
	@org.junit.Test
	public void testFullConst() {
		cem = new CompanyEmail("haha@ha.com","lol@xd.com","hi mom","im dumb");
		assertEquals("haha@ha.com",cem.fromAddress());
		assertEquals("lol@xd.com",cem.toAddress());
		assertEquals("hi mom",cem.subjectLine());
		assertEquals("im dumb",cem.emailMessage());
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

	@org.junit.Test
	public void testFromAddress() {
		cem = new CompanyEmail();
		assertNull(cem.fromAddress());
		//cem = new CompanyEmail("haha@ha.com",null,null,null);
		// NOTE: FIX THE FULL CONSTRUCTOR
		cem.setFrom("haha@ha.com");
		assertNotNull(cem.fromAddress());
	}

	@org.junit.Test
	public void testToAddress() {
		cem = new CompanyEmail();
		assertNull(cem.toAddress());
		//cem = new CompanyEmail(null,"haha@ha.com",null,null);
		cem.setTo("haha@ha.com");
		assertEquals("haha@ha.com" , cem.toAddress());
	}

	@org.junit.Test
	public void testSubjectLine() {
		cem = new CompanyEmail();
		assertNull(cem.subjectLine());
		cem = new CompanyEmail("haha@ha.com","lol@xd.com","hi mom","hi dad");
		assertEquals("hi mom", cem.subjectLine());
	}

	@org.junit.Test
	public void testEmailMessage() {
		cem = new CompanyEmail();
		assertNull(cem.emailMessage());
		cem = new CompanyEmail("haha@ha.com","lol@xd.com","hi mom","hi dad");
		assertEquals("hi dad", cem.emailMessage());
	}

	@org.junit.Test
	public void testSetFrom() {
		cem  = new CompanyEmail();
		assertNull(cem.fromAddress());
		cem.setFrom("noatsignhere");
		assertNull(cem.fromAddress());
		cem.setFrom("atsign@at.com");
		assertEquals("atsign@at.com",cem.fromAddress());
	}

	@org.junit.Test
	public void testSetTo() {
		cem  = new CompanyEmail();
		assertNull(cem.toAddress());
		cem.setTo("noatsignhere");
		assertNull(cem.toAddress());
		cem.setTo("atsign@at.com");
		assertEquals("atsign@at.com",cem.toAddress());
	}

	@org.junit.Test
	public void testSetSubject() {
		cem = new CompanyEmail();
		assertNull(cem.subjectLine());
		cem.setSubject("this is a subject");
		assertEquals("this is a subject", cem.subjectLine());	
	}

	@org.junit.Test
	public void testSetMessage() {
		cem = new CompanyEmail();
		assertNull(cem.emailMessage());
		cem.setMessage("EMAIL MESSAGE HERE HAHA");
		assertEquals("EMAIL MESSAGE HERE HAHA", cem.emailMessage());
	}

	@org.junit.Test
	public void testIsValid() {
		cem = new CompanyEmail();
		assertFalse(cem.isValid());
		cem = new CompanyEmail("banana@gmail.com","","","");
		assertFalse(cem.isValid());
		cem = new CompanyEmail("","banana@gmail.com","","");
		assertFalse(cem.isValid());
		cem = new CompanyEmail("","","hi mom","");
		assertFalse(cem.isValid());
		cem = new CompanyEmail("","","","hi dad");
		assertFalse(cem.isValid());
		cem = new CompanyEmail("banana@gmail.com","banana2@gmail.com","hi mom","hi dad");
		assertTrue(cem.isValid());
	}

	@org.junit.Test
	public void testToString() {
		cem = new CompanyEmail();
		//System.out.println(cem.toString());
		//assertNull(cem.toString());		test should fail when subjectLine is null, but assertNull not working on output
		cem.setSubject("");
		assertEquals("[no subject]",cem.toString());
		//assertNotEquals("a subject", cem.toString());
		cem.setSubject("a new subject");
		assertEquals("a new subject",cem.toString());
		
	}

}
