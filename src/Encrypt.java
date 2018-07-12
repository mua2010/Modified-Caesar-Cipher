public class Encrypt {

   //Declare variables
	private int shift;
	private String textStr;
	private String encryptStr;
	
   //Constructor
   public Encrypt(String str, int s) {
	   textStr = str;
	   shift = s;
	   encryptStr = "";
   }
   
   //Do the shifting and store the shifted characters
   public void shiftString() {
	   for(int x = 0; x < textStr.length(); x++) {
         // ***(a=97 - z=122)*** ***(A=65 - Z=90)***
		   int ascii_Of_Chr = (int)(textStr.charAt(x)); // ascii_Of_Chr stores the ascii of the current character
         char chr = (textStr.charAt(x)); // chr stores the current character
         
		   if (chr >= 'a' && chr <= 'z') {
	            ascii_Of_Chr = (int)(ascii_Of_Chr + shift);
	            if ((char)ascii_Of_Chr > 'z')
	                ascii_Of_Chr = (int)(ascii_Of_Chr - 122 + 97 - 1);  //(a=97 - z=122)
                   
	            encryptStr += (char)ascii_Of_Chr;
	        }
	        else if (chr >= 'A' && chr <= 'Z') {
	            ascii_Of_Chr = (int)(ascii_Of_Chr + shift);
	            if ((char)ascii_Of_Chr > 'Z')
	                ascii_Of_Chr = (int)(ascii_Of_Chr - 90 + 65 - 1);  //(A=65 - Z=90)
                   
	            encryptStr += (char)ascii_Of_Chr;
	        }
	        else
	        	encryptStr += (char)ascii_Of_Chr;		//handles any other character (spaces etc)   
	   }//end for loop
   }
   
   //return the Cipher Text
   public String getCipher() {
	   return encryptStr;
   }
}