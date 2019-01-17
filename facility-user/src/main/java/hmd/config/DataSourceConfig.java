//package hmd.config;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import hmd.security.Crypt;
//
//@Configuration
//public class DataSourceConfig {
//
//	@Value("${spring.datasource.postgresql.driver-class-name}")
//	private String postgresqlDriverClassName;
//	@Value("${spring.datasource.postgresql.url}")
//	private String postgresqlUrl;
//	@Value("${spring.datasource.postgresql.user}")
//	private String postgresqlUser;
//	@Value("${spring.datasource.postgresql.password}")
//	private String postgresqlPassword;
//	@Value("${spring.datasource.postgresql.hikari.maximum-pool-size}")
//	private Integer postgresqlMaximumPoolSize;
//	@Value("${spring.datasource.postgresql.hikari.minimum-idle}")
//	private Integer postgresqlMinimumIdle;
//	
//	@Value("${spring.datasource.oracle.driver-class-name}")
//	private String oracleDriverClassName;
//	@Value("${spring.datasource.oracle.url}")
//	private String oracleUrl;
//	@Value("${spring.datasource.oracle.user}")
//	private String oracleUser;
//	@Value("${spring.datasource.oracle.password}")
//	private String oraclePassword;
//	@Value("${spring.datasource.oracle.hikari.maximum-pool-size}")
//	private Integer oracleMaximumPoolSize;
//	@Value("${spring.datasource.oracle.hikari.minimum-idle}")
//	private Integer oracleMinimumIdle;
//	
//	@Value("${spring.datasource.maria.driver-class-name}")
//	private String mariaDriverClassName;
//	@Value("${spring.datasource.maria.url}")
//	private String mariaUrl;
//	@Value("${spring.datasource.maria.user}")
//	private String mariaUser;
//	@Value("${spring.datasource.maria.password}")
//	private String mariaPassword;
//	@Value("${spring.datasource.maria.hikari.maximum-pool-size}")
//	private Integer mariaMaximumPoolSize;
//	@Value("${spring.datasource.maria.hikari.minimum-idle}")
//	private Integer mariaMinimumIdle;
//	
//	@Bean
//	public DataSource routingDataSource() {
//		AbstractRoutingDataSource routingDataSource = new RoutingDataSource();
//		routingDataSource.setDefaultTargetDataSource(createPostgresqlDataSource());
//
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put(Database.ORACLE.name(), createOracleDataSource());
//        targetDataSources.put(Database.MARIA.name(), createMariaDataSource());
//
//        routingDataSource.setTargetDataSources(targetDataSources);
// 
//        return routingDataSource;
//    }
//	
//	private DataSource createOracleDataSource() {
//		AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//		dataSource.setUniqueResourceName(Database.ORACLE.name());
//		dataSource.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
//		
//		Properties properties = new Properties();
//		properties.setProperty("user", Crypt.decrypt(oracleUser));
//		properties.setProperty("password", Crypt.decrypt(oraclePassword));
//		properties.setProperty("url", Crypt.decrypt(oracleUrl));
//	
//		dataSource.setXaProperties(properties);
//		dataSource.setMaxPoolSize(oracleMaximumPoolSize);
//		dataSource.setMinPoolSize(oracleMinimumIdle);
//
//        return dataSource;
//	}
//	
//	private DataSource createPostgresqlDataSource() {
//		AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//		dataSource.setUniqueResourceName(Database.POSTGRESQL.name());
//		dataSource.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
//		
//		Properties properties = new Properties();
//		properties.setProperty("user", Crypt.decrypt(postgresqlUser));
//		properties.setProperty("password", Crypt.decrypt(postgresqlPassword));
//		properties.setProperty("url", Crypt.decrypt(postgresqlUrl));
//	
//		dataSource.setXaProperties(properties);
//		dataSource.setMaxPoolSize(postgresqlMaximumPoolSize);
//		dataSource.setMinPoolSize(postgresqlMinimumIdle);
//
//        return dataSource;
//	}
//
//	private DataSource createMariaDataSource() {
//		AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//		dataSource.setUniqueResourceName(Database.MARIA.name());
//		dataSource.setXaDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
//		
//		Properties properties = new Properties();
//		properties.setProperty("user", Crypt.decrypt(mariaUser));
//		properties.setProperty("password", Crypt.decrypt(mariaPassword));
//		properties.setProperty("url", Crypt.decrypt(mariaUrl));
//	
//		dataSource.setXaProperties(properties);
//		dataSource.setMaxPoolSize(mariaMaximumPoolSize);
//		dataSource.setMinPoolSize(mariaMinimumIdle);
//
//        return dataSource;
//	}
//
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//		factory.setDataSource(dataSource);
//		factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
//		factory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("mybatis-config.xml"));
//		factory.setTransactionFactory(new ManagedTransactionFactory());
//		return factory.getObject();
//	}
//}