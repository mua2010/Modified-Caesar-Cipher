public class Decrypt {

   //Declare variables/arrays to use
	private String encryptedStr;
	private String decryptStr;
	private int shift;
	
   //Constructor
   //Initialize any variables or arrays
   public Decrypt(String str, int s) {
	   encryptedStr = str;
	   decryptStr = "";
	   shift = s;
   }
   
   //Do the reverse shifting
   public void reverseShift() {
	   for(int x = 0; x < encryptedStr.length(); x++) {
         // ***(a=97 - z=122)*** ***(A=65 - Z=90)***
		   int ascii_Of_Chr = (int)(encryptedStr.charAt(x)); // ascii_Of_Chr stores the ascii of the character
         char chr = (encryptedStr.charAt(x)); // chr stores the current character
         
		   if (chr >= 'a' && chr <= 'z') {
	            ascii_Of_Chr = (ascii_Of_Chr - shift);
	            if ((char)ascii_Of_Chr < 'a')
	                ascii_Of_Chr = (int)(ascii_Of_Chr + 122 - 97 + 1);  ////(a=97 - z=122)
                   
	            decryptStr += (char)ascii_Of_Chr;
	      }
	      else if (chr >= 'A' && chr <= 'Z') {
	            ascii_Of_Chr = (ascii_Of_Chr - shift);
	            if ((char)ascii_Of_Chr < 'A')
	                ascii_Of_Chr = (int)(ascii_Of_Chr + 90 - 65 + 1); //(A=65 - Z=90)
                   
	            decryptStr += (char)ascii_Of_Chr;
	      }
	      else
	        	decryptStr += (char)ascii_Of_Chr;
	   }//end for loop
   }
   
   //return the Text
   public String getText() {
      return decryptStr;
   }

}