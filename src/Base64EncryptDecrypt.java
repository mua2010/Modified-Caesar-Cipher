import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.mail.*;
import javax.mail.internet.*;

//https://docs.oracle.com/javase/8/docs/api/java/util/Base64.Encoder.html
//This code is taken from an online source which uses java packages for encoding and decoding

public class Base64EncryptDecrypt {
   
   public static String b64encode(byte[] b) throws MessagingException, 
      IOException {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      OutputStream b64os = MimeUtility.encode(baos, "base64");
      b64os.write(b);
      b64os.close();
      return new String(baos.toByteArray());
   } 
   
   public static byte[] b64decode(String s) throws 
      MessagingException, IOException {
      ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
      InputStream b64is = MimeUtility.decode(bais, "Base64");
      byte[] tmp = new byte[s.length()];
      int n = b64is.read(tmp);
      byte[] res = new byte[n];
      System.arraycopy(tmp, 0, res, 0, n);
      return res;
   } 
}