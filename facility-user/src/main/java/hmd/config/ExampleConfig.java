//package hmd.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//import hmd.security.Crypt;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@MapperScan("hmd.persistence.oracle")
//@ComponentScan(	basePackages = {"hmd.service, hmd.persistence.oracle"},
//includeFilters = {	@Filter(type = FilterType.ANNOTATION, value = Component.class),
//					@Filter(type = FilterType.ANNOTATION, value = Service.class),
//					@Filter(type = FilterType.ANNOTATION, value = Repository.class) },
//excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class) )
//public class ExampleConfig {
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
//	@Bean(name="datasourceUser")
//	public DataSource dataSource() {
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName(oracleDriverClassName);
//		dataSource.setJdbcUrl(Crypt.decrypt(oracleUrl));
//		dataSource.setUsername(Crypt.decrypt(oracleUser));
//		dataSource.setPassword(Crypt.decrypt(oraclePassword));
//		dataSource.setMaximumPoolSize(oracleMaximumPoolSize);
//		dataSource.setMinimumIdle(oracleMaximumPoolSize);
//		
//	    return dataSource;
//	}
//	
//	@Bean
//    public DataSourceTransactionManager transactionManager() {
//		log.info(" ### RootConfig transactionManager ### ");
//        final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
//        return transactionManager;
//    }
//	
//	@Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//		log.info(" ### RootConfig sqlSessionFactory ### ");
//		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//		factory.setDataSource(dataSource());
//		factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/oracle/*.xml"));
//		factory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("mybatis-config-oracle.xml"));
//		//factory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//		return factory.getObject();
//    }
//}
