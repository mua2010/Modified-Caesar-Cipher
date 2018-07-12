import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.mail.*;
//import javax.mail.internet.*;

public class CaesarCipherMain {

   public static void main(String[] args) {
	   String inputText;
	   String cipherText;
	   Random rand = new Random();
	   int shift;
	   
	   Scanner scan = new Scanner(System.in);
	   System.out.println("Enter text to be encrypted");
	   inputText = scan.nextLine();
	   shift = rand.nextInt(25)+1;
	   System.out.println("Shift used = " + shift);
	   
      Encrypt encryptText = new Encrypt(inputText, shift);
	   encryptText.shiftString();
	   cipherText = encryptText.getCipher();
      System.out.println("The encrypted text after shifting by " + shift + " is:   " + cipherText);
      String base64EncodedText = "";
      
      try {
         base64EncodedText = Base64EncryptDecrypt.b64encode(cipherText.getBytes());
      }
      catch(IOException e) {
	      System.out.println(e.getMessage());
	   }
      catch(MessagingException e) {
	      System.out.println(e.getMessage());
	   }
      catch(Exception e) {
	      System.out.println(e.getMessage());
	   }
      
      System.out.println("The base 64 encoded text is:   " + base64EncodedText);
      
      System.out.println("Enter D if you would like to have your text decrypted. Enter X to quit.");
	   String x = scan.next();
	   if (x.equalsIgnoreCase("D")) {
         byte[] base64EncodedByteArray = null;
         try {
            base64EncodedByteArray = Base64EncryptDecrypt.b64decode(base64EncodedText);
         }
         catch (IOException e) {
	         System.out.println(e.getMessage());
	      }
         catch (MessagingException e) {
	         System.out.println(e.getMessage());
	      }
         catch (Exception e) {
	         System.out.println(e.getMessage());
	      }      
      String base64DecodedText = new String(base64EncodedByteArray);
      System.out.println("The base 64 decoded text is:   " + base64DecodedText);
      
		   Decrypt decryptText = new Decrypt(cipherText, shift);
		   decryptText.reverseShift();
		   System.out.println("The Caesar Cipher decrypted text after reverse shift by " + shift + " is:   " + decryptText.getText());
	   }
	   else if (x.equalsIgnoreCase("X"))
		   System.out.println("Thank you for using the Caesar Cipher. Good bye!");
	   scan.close();
   }//end main
}//end class