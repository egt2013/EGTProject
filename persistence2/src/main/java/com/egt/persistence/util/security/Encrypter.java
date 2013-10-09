package com.egt.persistence.util.security;

import java.security.NoSuchAlgorithmException;

public interface Encrypter {
	public String encrypt( String plainText ) throws NoSuchAlgorithmException;
	public String encrypt( String username, String password ) throws NoSuchAlgorithmException;
	public boolean verifyPassword(String username, String password, String passwordInDb);
}
