package hmd.security;

import org.junit.Test;

public class CryptTest {

	@Test
	public void test() {
		System.out.println(Crypt.encrypt("jdbc:mariadb://localhost/transport"));
		System.out.println("user : " + Crypt.encrypt("test"));
		System.out.println("password : " + Crypt.encrypt("test"));
		
		System.out.println(Crypt.decrypt("VisSFDP+8GqC9Pdnr6q5fQ=="));
	}
}
