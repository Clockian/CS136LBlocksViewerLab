/*
 * Created by Jasque Saydyk and Emalina Bidari
 * Lab 04 - RSA Encryption
 * CS 136L Section 3801
 * 14 February 2017
 * Description - This class is main, creating the keys to encrypt and decrypt numbers
*/
import java.math.BigInteger;

public class RSA_Main {
	public static void main(String[] args){
		RSA_Public thing = new RSA_Public(61, 53);
		thing.generateKeys();
		
		BigInteger encrypted = thing.encryptValue(65);
		BigInteger decrypted = thing.decryptValue(encrypted);
		
		System.out.println("\nEncrypted value: " + encrypted + "  Expected Encrypted Value: 2790");
		System.out.println("\nDecrypted value is: " + decrypted + "  Expected Decrypted Value: 65\n");
		
		
		RSA_Public thing2 = new RSA_Public();
		thing2.generateKeys();
		
		BigInteger encrypted2 = thing2.encryptValue(65);
		BigInteger decrypted2 = thing2.decryptValue(encrypted2);
		
		System.out.println("\nEncrypted value: " + encrypted2);
		System.out.println("\nDecrypted value is: " + decrypted2 + "  Expected Decrypted Value: 65");
	}
}
