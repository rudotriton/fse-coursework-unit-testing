import static org.junit.Assert.*;

import org.junit.Test;
public class CompanyEmailTest {

	private CompanyEmail cem;
	public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
	
	@org.junit.Before
	public void setup() {
		CompanyEmail cem = new CompanyEmail();
		//cem.fromAddress = "hey hoe";
		}
	
	@org.junit.Test
	public void testBasicConst() {
		
	}
	
	@org.junit.Test
	public void testEmailAdresses() {
		CompanyEmail goodConstructor = new CompanyEmail("haha@ha.com","lol@xd.com","hi mom","im dumb");
			assertTrue(goodConstructor.fromAddress().matches(EMAIL_VERIFICATION));
			assertTrue(goodConstructor.toAddress().matches(EMAIL_VERIFICATION));
		CompanyEmail badConstructor = new CompanyEmail("invalid","notanemail","parrot","poop");
			assertFalse(badConstructor.fromAddress().matches(EMAIL_VERIFICATION));
			assertFalse(badConstructor.toAddress().matches(EMAIL_VERIFICATION));
		CompanyEmail halfbadConstructor = new CompanyEmail("valid@email.com","notanemail","parrot","poop");
			assertTrue(halfbadConstructor.fromAddress().matches(EMAIL_VERIFICATION));
			assertFalse(halfbadConstructor.toAddress().matches(EMAIL_VERIFICATION));
		CompanyEmail sndhalfbadConstructor = new CompanyEmail("invalid","valid@email.com","parrot","poop");
			assertFalse(sndhalfbadConstructor.fromAddress().matches(EMAIL_VERIFICATION));
			assertTrue(sndhalfbadConstructor.toAddress().matches(EMAIL_VERIFICATION));
	}

//	@org.junit.Test
//	public void testFromAddress() {
//		assertTrue("idodo@hdjddj.com".matches(EMAIL_VERIFICATION));
//		assertFalse("idoddjddj.com".matches(EMAIL_VERIFICATION));
//		assertFalse("idoddjddjom".matches(EMAIL_VERIFICATION));
//	}

//	@org.junit.Test
//	public void testToAddress() {
//		assertTrue("idodo@hdjddj.com".matches(EMAIL_VERIFICATION));
//		assertFalse("idoddjddj.com".matches(EMAIL_VERIFICATION));
//		assertFalse("idoddjddjom".matches(EMAIL_VERIFICATION));
//	}

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
		fail("Not yet implemented");
	}

	@org.junit.Test
	public void testSetTo() {
		fail("Not yet implemented");
	}

	@org.junit.Test
	public void testSetSubject() {
		cem = new CompanyEmail();
		cem.setSubject("this is a subject");
		assertEquals("this is a subject", cem.subjectLine());	
	}

	@org.junit.Test
	public void testSetMessage() {
		cem = new CompanyEmail();
		cem.setMessage("EMAIL MESSAGE HERE HAHA");
		assertEquals("EMAIL MESSAGE HERE HAHA", cem.emailMessage());
	}

	@org.junit.Test
	public void testIsValid() {
		fail("Not yet implemented");
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
