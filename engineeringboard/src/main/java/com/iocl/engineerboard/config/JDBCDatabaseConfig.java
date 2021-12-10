package com.iocl.engineerboard.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

/**
 * JDBCDatabaseConfig
 */
@Service
public class JDBCDatabaseConfig {

//	 @Value("${spring.datasource.url}")
//	 private String jdbcURL;
//
//	 @Value("${spring.datasource.username}")
//	 private String jdbcUserName;
//
//	 @Value("${spring.datasource.password}")
//	 private String jdbcPassword;
//
//	 @Value("${app.jdbc.driver-class-name}")
//	 private String jdbcDriverClassName;

	public Connection getJDBCDatabaseConnection() {

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			 con = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
//			 con = DriverManager.getConnection("jdbc:oracle:thin:@mktoradev1.ds.indianoil.in:1521/MKTORADB", "dhruva2", "kxbRwq6hvA");

//			  con = DriverManager.getConnection("jdbc:oracle:thin:@OTHORASCAN.DS.INDIANOIL.IN:1521/MKTORARACKDB", "dhruva2", "kxbRwq6hvA");

			InitialContext jndiCntx = new InitialContext();
			DataSource ds = (DataSource) jndiCntx.lookup("java:/DHRUVA2");
			con = ds.getConnection();

		} catch (Exception e) {
			System.out.println("Could not make using jndi..." + e.getLocalizedMessage());
			try {
				System.out.println("Could not make using jndi... so making using thin client");
				con = DriverManager.getConnection("jdbc:oracle:thin:@rdborascan.ds.indianoil.in:1521/RETAILORADB",
						"dhruva2", "kxbRwq6hvA");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return con;
	}
}