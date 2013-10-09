package com.egt.persistence.util.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.log4j.Logger;


import com.Ostermiller.util.MD5;

public class MD5Encrypter implements Encrypter {
	private Logger logger = Logger.getLogger(this.getClass());

	public String encrypt(String plainText) throws NoSuchAlgorithmException {
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		algorithm.reset();
		algorithm.update(plainText.getBytes());
		byte messageDigest[] = algorithm.digest();

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < messageDigest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
		}

		return hexString.toString();

	}

	public String encrypt(String username, String password) throws NoSuchAlgorithmException {
		String passwordHash = null;
		// Generate a DES key
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		SecretKey key = keyGen.generateKey();
		String keyS = MD5.getHashString(key.getEncoded());
		passwordHash = keyS + MD5.getHashString(password + username + keyS);
		return passwordHash;
	}

	public boolean verifyPassword(String username, String password,
			String passwordInDb) {

		logger.debug("Username : " + username);
		logger.debug("Password : " + password);
		logger.debug("PasswordDB : " + passwordInDb);
		String userPassword = null;
		// for new encoding method dbPassword's length = 64
		if (passwordInDb.length() > 32) {
			String keyS = passwordInDb.substring(0, 32);
			userPassword = keyS + MD5.getHashString(password + username + keyS);
		}
		// for old encoding method dbPassword's length = 32
		else {
			userPassword = MD5.getHashString(password + username);
		}
		logger.debug("EncrypPassword : " + userPassword);

		if (userPassword.equals(passwordInDb)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		MD5Encrypter en = new MD5Encrypter();
		System.out.println(en.encrypt("SYSADMIN", "Passw0rd"));

	}
}
