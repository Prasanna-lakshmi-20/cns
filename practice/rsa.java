import java.math.BigInteger;
import java.util.Scanner;

 class rsaExample {
    public static void main(String args[]) {
        int p, q, n, z, d = 0, e, i;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Message: ");
        int msg = sc.nextInt();

        BigInteger msgback;
        System.out.print("Enter first prime number (p): ");
        p = sc.nextInt();
        System.out.print("Enter second prime number (q): ");
        q = sc.nextInt();
        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("The value of phi(n) = " + z);
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("The value of e = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("The value of d = " + d);
        BigInteger message = BigInteger.valueOf(msg);
        BigInteger publicKeyExponent = BigInteger.valueOf(e);
        BigInteger modulus = BigInteger.valueOf(n);
        BigInteger encryptedMessage = message.modPow(publicKeyExponent, modulus);
        System.out.println("Encrypted message is: " + encryptedMessage);
        msgback = encryptedMessage.modPow(BigInteger.valueOf(d), modulus);
        System.out.println("Decrypted message is: " + msgback);
    }
    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return(z%e);

    }
}