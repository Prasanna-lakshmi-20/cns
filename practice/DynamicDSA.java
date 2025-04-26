import java.security.*;
import java.util.Base64;
import java.util.Scanner;
class DynamicDSA{
    public static void main(String[] args) {
        try(Scanner scanner=new Scanner(System.in)){
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            keyGen.initialize(2048);
            KeyPair keyPair=keyGen.generateKeyPair();
            PrivateKey privateKey=keyPair.getPrivate();
            PublicKey publicKey=keyPair.getPublic();
            System.out.println("Enter message to sign:");
            String message=scanner.nextLine();
            Signature signature=Signature.getInstance("SHA256withDSA");
            signature.initSign(privateKey);
            signature.update(message.getBytes());
            byte[] digitalSignature=signature.sign();
            String encodedSignature= Base64.getEncoder().encodeToString(digitalSignature);
            System.out.println("Generated Digital Signature"+encodedSignature);
            System.out.println("Enter message to verify:");
            String verifyMessage=scanner.nextLine();
            Signature verifySignature=Signature.getInstance("SHA256withDSA");
            verifySignature.initVerify(publicKey);
            verifySignature.update(verifyMessage.getBytes());
            boolean isValid=verifySignature.verify(Base64.getDecoder().decode(encodedSignature));
            if(isValid){
                System.out.println("String successfully verified");
            }
            else{
                System.out.println("Signature verification failed");
            }



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}