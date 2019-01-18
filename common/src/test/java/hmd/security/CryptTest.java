package hmd.security;

import org.junit.Test;

public class CryptTest {

	@Test
	public void test() {
		System.out.println(Crypt.encrypt("jdbc:oracle:thin:@118.216.255.110:15210:gaia3d11g"));
		System.out.println("user : " + Crypt.encrypt("sys as sysdba"));
		System.out.println("password : " + Crypt.encrypt("gaia#doracle1"));
		
		System.out.println(Crypt.decrypt("Mocf058K2sOHdq7iY09RWM2h7mAZ4ifViFFoRfKu0mzIwT142HIagh1tbI//dKf96FczLbQRjFbcB/vUeO0B6A=="));
		System.out.println(Crypt.decrypt("UU+maA6GZHDSLn2jz5i+fA=="));
		System.out.println(Crypt.decrypt("UU+maA6GZHDSLn2jz5i+fA=="));
	}
}
