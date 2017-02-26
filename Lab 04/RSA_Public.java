package com.CS136.Lab04;

import java.math.BigInteger;

public class RSA_Public {
	private BigInteger primeP;
	private BigInteger primeQ;
	
	private BigInteger publicKey;
	private BigInteger privateKey;
	
	public RSA_Public(){
		//This will create random values for PrimeP and Q
	}
	
	public RSA_Public(Integer primeP, Integer primeQ){
		//this.primeP = new BigInteger();
		this.primeP = BigInteger.valueOf(primeP.intValue());
		this.primeQ = BigInteger.valueOf(primeQ.intValue());
	}
	
	public void generatePublicKey(){
		System.out.println("Given Prime P: " + primeP);
		System.out.println("Given Prime Q: " + primeQ);
		
		BigInteger modulusN = primeP.multiply(primeQ);
		System.out.println("ModulusN: " + modulusN);
		
		BigInteger primePSub = primeP.subtract(BigInteger.valueOf(1));
		BigInteger primeQSub = primeQ.subtract(BigInteger.valueOf(1));
		BigInteger lcmDenominator = primePSub.gcd(primeQSub);
		BigInteger lcmNumerator = primePSub.multiply(primeQSub);
		BigInteger totient = lcmNumerator.divide(lcmDenominator);
		System.out.println("Totient: " + totient);
		
		BigInteger publicKeyExponent = BigInteger.valueOf(1);
		
		//(publicKeyExponent.compareTo(BigInteger.valueOf(1)) > 0)
		//System.out.println("Exponent Compare Result: " + publicKeyExponent.compareTo(BigInteger.valueOf(1)));
		//(publicKeyExponent.compareTo(BigInteger.valueOf(1)) > 0) && 
		//System.out.println("Exponent Compare Totient: " + publicKeyExponent.compareTo(totient));
		//Computing the public key exponent
		for(int ii = 0; (BigInteger.valueOf(ii).compareTo(totient) <= 0); ii++)
		{
			//System.out.println("Exponent Compare Totient: " + publicKeyExponent.compareTo(totient));
			//System.out.println("here");
			if(totient.mod(publicKeyExponent).compareTo(BigInteger.valueOf(0)) == 0){
				//System.out.println("Totient mod Exponent equals 0: " + totient.mod(publicKeyExponent).compareTo(BigInteger.valueOf(0)));
				publicKeyExponent = publicKeyExponent.add(BigInteger.valueOf(1));
				System.out.println("Current public key: " + publicKeyExponent);
			}
		}
		System.out.println("Public Key Exponent: " + publicKeyExponent);
		
		BigInteger modularMultiInverse; //= publicKeyExponent.modInverse(totient);
		//System.out.println("Modular Multiplicitive Inverse: " + modularMultiInverse);
		
		BigInteger privateKeyExponent = BigInteger.valueOf(0);
		BigInteger modularMultiResult;
		BigInteger modularMultiStep;
		/*
		while(true){
			modularMultiStep = privateKeyExponent.multiply(publicKeyExponent);
			modularMultiInverse = modularMultiStep.modInverse(totient);
			if(modularMultiInverse.compareTo(BigInteger.valueOf(1)) == 0){
				break;
			}
			else{
				privateKeyExponent = privateKeyExponent.add(BigInteger.valueOf(1));
			}
		}
		System.out.println("Private Key Exponent: " + privateKeyExponent);*/
		
		
		
	}
}
