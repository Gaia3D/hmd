package hmd.security;

import org.junit.Test;

public class CryptTest {

	@Test
	public void test() {
		System.out.println(Crypt.encrypt("jdbc:postgresql://localhost:5432/hmd"));
		System.out.println(Crypt.encrypt("postgres"));
		System.out.println(Crypt.encrypt("postgres"));
		
		System.out.println(Crypt.decrypt("Mocf058K2sOHdq7iY09RWM2h7mAZ4ifViFFoRfKu0mzIwT142HIagh1tbI//dKf96FczLbQRjFbcB/vUeO0B6A=="));
		System.out.println(Crypt.decrypt("UU+maA6GZHDSLn2jz5i+fA=="));
		System.out.println(Crypt.decrypt("UU+maA6GZHDSLn2jz5i+fA=="));
	}
}
