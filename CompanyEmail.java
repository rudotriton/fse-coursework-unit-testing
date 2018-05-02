public class CompanyEmail {
    private String fromAddress;
    private String toAddress;
    private String subjectLine;
    private String emailMessage;
    
    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
	
    // IMPROVEMENT -> REGEX added for checking email addresses for validity
    // By Alex Melissas and Sam Kendrick
    
    // CLARITY -> Added numbering above each function according to the ID's 
    // we had for them on our test and bugfixing report from the previous lab assignment.
    // By Alex Melissas & Sam Kendrick
    
    //1.1
    public CompanyEmail() {
        fromAddress = null;
        toAddress = null;
        subjectLine = null;
        emailMessage = null;
    }

    //1.2
    public CompanyEmail(String fAddress, String tAddress, String subLine, String eMessage) {
        /*fromAddress = fAddress;
        toAddress = tAddress;
        subjectLine = subLine;
        emailMessage = eMessage;*/
    	
    	// BUG -> Addresses are not checked for validation (only getter functions called by constructor)
    	// Spotted and fixed by Sam Kendrick and Alex Melissas
    	
    	setFrom(fAddress);
    	setTo(tAddress);
    	setSubject(subLine);
    	setMessage(eMessage);
    	
    }

    //1.3
    public String fromAddress() {
        return fromAddress;
    }

    //1.4
    public String toAddress() {
        return toAddress;
    }

    //1.5
    public String subjectLine() {
        return subjectLine;
    }

    //1.6
    public String emailMessage() {
//    recursive call to method
//    bug fix by Raigo Jerva
//      return emailMessage();
        return emailMessage;
    }

    //1.7
    public void setFrom(String fromAddr) {
        //if (fromAddr.contains("@")) {        			// IMPROVEMENT -> Unsatisfactory email checking - Use 
    													// REGEX instead. By Sam Kendrick & Alex Melissas
    	if (fromAddr.matches(EMAIL_VERIFICATION)) {
            fromAddress = fromAddr;
        }
    }

    //1.8
    public void setTo(String toAddr) {
        //if (toAddr.contains("@")) { 					// IMPROVEMENT -> Unsatisfactory email checking - Use 
														// REGEX instead. By Sam Kendrick & Alex Melissas
    	if (toAddr.matches(EMAIL_VERIFICATION)) {
            toAddress = toAddr;
    	}
    }

    //1.9
    public void setSubject(String subLine) {
        subjectLine = subLine;
    }

    //1.10
    public void setMessage(String eMessage) {
        emailMessage = eMessage;
    }

    //1.11
    public boolean isValid() {
        boolean isComplete = true;
        if (fromAddress == null) isComplete = false;
        if (toAddress == null) isComplete = false;
        if (subjectLine == null) isComplete = false;
        if (emailMessage == null) isComplete = false;
        return isComplete;
    }

    //1.12
    public String toString() {
        if (subjectLine=="") { // .equals not working?
	            return "[no subject]";				
        } else {
            return subjectLine;
        }
    }
}
