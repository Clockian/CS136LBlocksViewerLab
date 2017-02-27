/*
 * Created by Jasque Saydyk and Emalina Bidari
 * Lab 04 - RSA Encryption
 * CS 136L Section 3801
 * 14 February 2017
 * Description - This class generates 
*/
import java.math.BigInteger;
import java.util.Random;

public class RSA_Public {
	private BigInteger primeP;
	private BigInteger primeQ;
	
	private BigInteger publicKeyExponent;
	private BigInteger privateKeyExponent;
	private BigInteger modulusN;
	
	
	/**
	 * Default constructor creates random values for Prime P and Q
	 */
	public RSA_Public(){
		Random rnd = new Random();
		this.primeP = new BigInteger(256, 100, rnd);
		this.primeQ = new BigInteger(256, 100, rnd);
	}
	
	
	/**
	 * Constuctor creates custom values for Prime P and Q
	 * @param primeP BigInteger value of the prime P
	 * @param primeQ BigInteger value of the prime Q
	 */
	public RSA_Public(Integer primeP, Integer primeQ){
		this.primeP = BigInteger.valueOf(primeP.intValue());
		this.primeQ = BigInteger.valueOf(primeQ.intValue());
	}
	
	
	/**
	 * Generates a public and private key based on the Prime P and Q
	 * For more information, see example in the RSA Encryption Wikipedia page
	 * https://en.wikipedia.org/wiki/RSA_(cryptosystem)
	 */
	public void generateKeys(){
		// 1. Two distinct prime numbers given from the constructors
		// 2. The modulus n is gotten by n = P * Q
		modulusN = primeP.multiply(primeQ);
		
		// 3. Compute the totient with totient(n) = lcm(P-1, Q-1)
		// Here we prep the calculation by removing one from P and Q
		BigInteger primePSub = primeP.subtract(BigInteger.valueOf(1));
		BigInteger primeQSub = primeQ.subtract(BigInteger.valueOf(1));
		
		// To calculate lcm(P-1, Q-1), we use "Reduction by the greatest common divisor"
		// For more information, see https://en.wikipedia.org/wiki/Least_common_multiple
		// The section under "Computing the least common mulitple"
		BigInteger lcmNumerator = primePSub.multiply(primeQSub);
		BigInteger lcmDenominator = primePSub.gcd(primeQSub);
		BigInteger totient = lcmNumerator.divide(lcmDenominator);
		
		// 4. Compute the Public Key Exponent
		// Test every number between 2 and the totient to see if it is coprime to the totient
		// Therefore, the public key exponent should a prime that is NOT a divisor of the totient
		// The skip passes over X correct answers, in this case two. To improve security, randomize the skip
		publicKeyExponent = BigInteger.valueOf(2);
		int skip = 0;
		for(int ii = 2; (BigInteger.valueOf(ii).compareTo(totient) <= 0); ii++)
		{
			if(BigInteger.valueOf(ii).isProbablePrime(100) && 
					totient.mod(BigInteger.valueOf(ii)).compareTo(BigInteger.ZERO) != 0){
				if(skip == 2){
					publicKeyExponent = BigInteger.valueOf(ii);
					break;
				}
				else{
					skip++;
				}
			}
		}
		
		// 5. Compute the PrivateKeyExponent
		// Find private key(multiplicative inverse) --> (privateKey*publicKey)% modulus = 1
	    privateKeyExponent = publicKeyExponent.modInverse(totient);
	    
	    // Tests for correct values
	    /*
	 	System.out.println("Prime P: " + primeP);
	 	System.out.println("Prime Q: " + primeQ);
	 	System.out.println("modulusN: " + modulusN);
	 	System.out.println("totient: " + totient);
	 	System.out.println("Public Key Exponent: " + publicKeyExponent);
	 	System.out.println("Private Key Exponent: " + privateKeyExponent);
	 	*/
	}
	
	/**
	 * Encrypts a given number
	 * @param value the number to be encrypted
	 * @return the encrypted number
	 */
	public BigInteger encryptValue(int value){
		return BigInteger.valueOf(value).modPow(publicKeyExponent, modulusN);
	}
	
	/**
	 * Decrypts a given number
	 * @param value BigInteger to be decrypted
	 * @return BigInteger of the encrypted number
	 */
	public BigInteger decryptValue(BigInteger value){
		return value.modPow(privateKeyExponent, modulusN);
	}
}
