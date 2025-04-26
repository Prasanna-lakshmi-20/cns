import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
 class diffieHellman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();
        
        // Input Prime number (P) and generator (G)
        System.out.print("Enter a prime number (P): ");
        BigInteger P = scanner.nextBigInteger();
        
        System.out.print("Enter a base (G): ");
        BigInteger G = scanner.nextBigInteger();
        
        // Private keys for Alice and Bob
        System.out.print("Enter private key for Alice: ");
        BigInteger a = scanner.nextBigInteger();
        
        System.out.print("Enter private key for Bob: ");
        BigInteger b = scanner.nextBigInteger();
        
        // Compute public keys
        BigInteger A = G.modPow(a, P);
        BigInteger B = G.modPow(b, P);
        
        // Compute shared secret keys
        BigInteger sharedKeyAlice = B.modPow(a, P);
        BigInteger sharedKeyBob = A.modPow(b, P);
        
        // Display results
        System.out.println("Public Prime (P): " + P);
        System.out.println("Public Base (G): " + G);
        System.out.println("Private Key (Alice): " + a);
        System.out.println("Private Key (Bob): " + b);
        System.out.println("Public Key (Alice): " + A);
        System.out.println("Public Key (Bob): " + B);
        System.out.println("Shared Secret Key (Alice): " + sharedKeyAlice);
        System.out.println("Shared Secret Key (Bob): " + sharedKeyBob);
        
        // Verifying the shared keys are same
        if (sharedKeyAlice.equals(sharedKeyBob)) {
            System.out.println("Key Exchange Successful! Both parties have the same shared key.");
        } else {
            System.out.println("Key Exchange Failed!");
        }
        
        scanner.close();
    }
}