public class CompanyEmail {
    private String fromAddress;
    private String toAddress;
    private String subjectLine;
    private String emailMessage;
    
    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
	// REGEX added for checking email addresses for validity
    
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
    	
    	// Addresses are not checked for validation (only getter functions called by constructor)
    	// Spotted by Sam Kendrick and Alex Melissas
    	
//    	fromAddress = null;
//        toAddress = null;
//        subjectLine = null;
//        emailMessage = null;
    	
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
        //if (fromAddr.contains("@")) {        // UNSATISFACTORY EMAIL CHECKING -- SAM / ALEX
    	if (fromAddr.matches(EMAIL_VERIFICATION)) {
            fromAddress = fromAddr;
        }
    }

    //1.8
    public void setTo(String toAddr) {
        //if (toAddr.contains("@")) { 
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
//        if (fromAddress == null) isComplete = false;
//        if (toAddress == null) isComplete = false;
//        if (subjectLine == null) isComplete = false;
//        if (emailMessage == null) isComplete = false;
        	//        BUG -> not ANDing - if last thing true it's wrong.
        	//		Spotted by Sam Kendrick & Alex Melissas
        if( (fromAddress == null) || (toAddress == null) || (subjectLine == null) || (emailMessage == null))
        		isComplete=false;
        return isComplete;
    }

    //1.12
    public String toString() {
        if (subjectLine.equals("")) {
            return "[no subject]";				//doesnt make the actual subjectLine [no subject]
        } else {
            return subjectLine;
        }
    }
}
