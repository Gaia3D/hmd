package hmd.config;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JDBCConnectionTest {

	@Test
	public void postgresqlConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mago3d", "postgres", "postgres");
			PreparedStatement psmt = conn.prepareStatement("select 1");
			ResultSet rs = null;
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println("postgresql test code 성공 . value = " + rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void oracleConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:gaia3d", "test", "test");
			PreparedStatement psmt = conn.prepareStatement("select 1 from dual");
			ResultSet rs = null;
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println("oracle test code 성공 . value = " + rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
