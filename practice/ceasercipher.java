import java.util.Scanner;

class CaesarCipher {
    
    public static String caesarCipher(String text, int shift, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int shiftDirection = encrypt ? shift : -shift; // Forward shift for encryption, backward for decryption

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char shiftedChar = (char) ((c - base + shiftDirection + 26) % 26 + base);
                result.append(shiftedChar);
            } else {
                result.append(c); // Keep non-alphabet characters unchanged
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter the String for Encryption: ");
        String text = scanner.nextLine();


        System.out.print("Enter Shift Key: ");
        int shift = scanner.nextInt();

        // Encrypt the message
        String encrypted = caesarCipher(text, shift, true);
        System.out.println("Encrypted Message: " + encrypted);

        // Decrypt the message
        String decrypted = caesarCipher(encrypted, shift, false);
        System.out.println("Decrypted Message: " + decrypted);

        scanner.close();
    }
}