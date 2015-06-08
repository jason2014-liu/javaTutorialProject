/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: GenSig.java
 * @Package com.appframework.examples.security
 * @author jason.liu
 * @Date 2014-10-28 上午9:43:58
 * @Version v1.0
 */
package com.appframework.examples.security;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

/**
 * TODO
 * 
 * @ClassName: GenSig
 * @author jason.liu
 */
public class GenSig {

	/**
	 * It is more common in cryptography to exchange certificates containing
	 * public keys rather than the keys themselves.
	 * 
	 * 
	 * In general, sending the data and the signature separately from your
	 * public key greatly reduces the likelihood of an attack
	 */

	/**
	 * It would be more secure for GenSig to create a certificate containing the
	 * public key and for VerSig to then import the certificate and extract the
	 * public key. However, the JDK has no public certificate APIs that would
	 * allow you to create a certificate from a public key, so the GenSig
	 * program cannot create a certificate from the public key it generated.
	 * TODO
	 * 
	 * If you want, you can use the various security tools, not APIs, to sign
	 * your important document(s) and work with certificates from a keystore, as
	 * was done in the Exchanging Files lesson.
	 * 
	 * Alternatively you can use the API to modify your programs to work with an
	 * already existing private key and corresponding public key (in a
	 * certificate) from your keystore
	 * 
	 * To keep the data confidential, you should encrypt it and store and send
	 * only the encryption result (referred to as ciphertext). The receiver can
	 * decrypt the ciphertext to obtain a copy of the original data.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String orginFile = "one-liners.txt";

		try {
			/**
			 * Generate a DSA(Digital Signature Algorithm) signature You will
			 * generate keys with a 1024-bit length.
			 */
			// Create a Key Pair Generator
			KeyPairGenerator keyGen = KeyPairGenerator
					.getInstance("DSA", "SUN");

			// Initialize the Key Pair Generator.All key pair generators share
			// the concepts of a keysize and a source of randomness
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			keyGen.initialize(1024, random);

			// Generate the Pair of Keys
			KeyPair pair = keyGen.generateKeyPair();
			PrivateKey priv = pair.getPrivate();
			PublicKey pub = pair.getPublic();

			// Sign the Data
			Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
			dsa.initSign(priv);// The initialization method for signing requires
								// a private key

			FileInputStream fis = new FileInputStream(orginFile);
			BufferedInputStream bufin = new BufferedInputStream(fis);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = bufin.read(buffer)) >= 0) {
				dsa.update(buffer, 0, len);
			}
			bufin.close();

			// Generate the Signature
			byte[] realSig = dsa.sign();

			// Save the Signature and the Public Key in Files
			FileOutputStream sigfos = new FileOutputStream("sig");
			sigfos.write(realSig);
			sigfos.close();

			byte[] key = pub.getEncoded();
			FileOutputStream keyfos = new FileOutputStream("suepk");
			keyfos.write(key);
			keyfos.close();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
