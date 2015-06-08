/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: VerSig.java
 * @Package com.appframework.examples.security
 * @author jason.liu
 * @Date 2014-10-28 上午10:35:12
 * @Version v1.0
 */
package com.appframework.examples.security;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * TODO
 * 
 * @ClassName: VerSig
 * @author jason.liu
 */
public class VerSig {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String publicKeyFile = "suepk";
		String signatureFile = "sig";
		String transferdFile = "one-liners.txt";

		try {

			// Input and Convert the Encoded Public Key Bytes
			FileInputStream keyfis = new FileInputStream(publicKeyFile);
			byte[] enckey = new byte[keyfis.available()];
			keyfis.read(enckey);
			keyfis.close();

			// Now the byte array encKey contains the encoded public key bytes.
			// You can use a KeyFactory class in order to instantiate a DSA
			// public key from its encoding.

			/**
			 * So, first you need a key specification. You can obtain one via
			 * the following, assuming that the key was encoded according to the
			 * X.509 standard, which is the case, for example, if the key was
			 * generated with the built-in DSA key-pair generator supplied by
			 * the SUN provider:
			 */
			X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(enckey);
			KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
			PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
			
			
			//Input the Signature Bytes
			FileInputStream sigfis = new FileInputStream(signatureFile);
			byte[] sigToVerify = new byte[sigfis.available()];
			sigfis.read(sigToVerify);
			sigfis.close();
			
			//Verify the Signature
			
			//You need to create a Signature object that uses the same signature algorithm as was used to generate the signature.
			Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
			sig.initVerify(pubKey);
			
			//Supply the Signature Object With the Data to be Verified
			FileInputStream datafis = new FileInputStream(transferdFile);
			BufferedInputStream bufin = new BufferedInputStream(datafis);
			byte[] buffer = new byte[1024];
			int len;
			while(bufin.available()!=0){
				len = bufin.read(buffer);
				sig.update(buffer, 0, len);
			}
			bufin.close();
			
			boolean verifies = sig.verify(sigToVerify);
			
			System.out.println("signature verifies:"+verifies);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}