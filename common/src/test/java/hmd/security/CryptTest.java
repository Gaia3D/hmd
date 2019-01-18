package hmd.security;

import org.junit.Test;

public class CryptTest {

	@Test
	public void test() {
		System.out.println(Crypt.encrypt("jdbc:oracle:thin:@localhost:1521:gaia3d"));
		System.out.println("user : " + Crypt.encrypt("test"));
		System.out.println("password : " + Crypt.encrypt("test"));
		
		System.out.println(Crypt.decrypt("cvH67DYjqA/huOOBPPPYtg=="));
	}
}
