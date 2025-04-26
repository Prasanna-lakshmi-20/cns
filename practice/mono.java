import java.util.Scanner;

public class mono{
    
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        
        for (char ch : plaintext.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            if (index != -1) {
                ciphertext.append(key.charAt(index)); 
            } else {
                ciphertext.append(ch); 
            }
        }
        
        return ciphertext.toString();
    }

  
    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        
        for (char ch : ciphertext.toUpperCase().toCharArray()) {
            int index = key.indexOf(ch);
            if (index != -1) {
                plaintext.append(ALPHABET.charAt(index)); // Replace with corresponding character in the alphabet
            } else {
                plaintext.append(ch); // Non-alphabetic characters remain unchanged
            }
        }
        
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter the key (26 unique uppercase letters): ");
        String key = scanner.nextLine().toUpperCase();

        
        if (key.length() != 26 || key.chars().distinct().count() != 26) {
            System.out.println("Key must contain 26 unique letters.");
            return;
        }

       
        String encryptedText = encrypt(plaintext.toUpperCase(), key);
        System.out.println("Encrypted Text: " + encryptedText);

        
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);
        
        scanner.close();
    }
}