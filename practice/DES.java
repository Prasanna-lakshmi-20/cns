import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
class DesEncrypter {
 Cipher ecipher;
 Cipher dcipher;
 DesEncrypter(SecretKey key) throws Exception {
 ecipher = Cipher.getInstance("DES");
 dcipher = Cipher.getInstance("DES");
 ecipher.init(Cipher.ENCRYPT_MODE, key);
 dcipher.init(Cipher.DECRYPT_MODE, key);
 }
 public String encrypt(String str) throws Exception {
 byte[] utf8 = str.getBytes("UTF8");
 byte[] enc = ecipher.doFinal(utf8);
 return Base64.getEncoder().encodeToString(enc);
 }
 public String decrypt(String str) throws Exception {
 byte[] dec = Base64.getDecoder().decode(str);
 byte[] utf8 = dcipher.doFinal(dec);
 return new String(utf8, "UTF8");
 }
}
public class DES {
 public static void main(String[] argv) throws Exception {
    Scanner sc=new Scanner(System.in);
 SecretKey key = KeyGenerator.getInstance("DES").generateKey();
 DesEncrypter encrypter = new DesEncrypter(key);
 System.out.println("Enter the text :");
 String text=sc.nextLine();
 String encrypted = encrypter.encrypt(text);
 System.out.println("Encrypted text: "+encrypted);
 String decrypted = encrypter.decrypt(encrypted);
 System.out.println(decrypted);
 }
}