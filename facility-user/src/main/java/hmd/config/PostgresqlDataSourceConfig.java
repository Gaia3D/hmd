package hmd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import hmd.security.Crypt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "hmd.persistence.postgresql", sqlSessionFactoryRef = "postgresqlSqlSessionFactory")
@Configuration
public class PostgresqlDataSourceConfig {

	@Value("${spring.datasource.postgresql.driver-class-name}")
	private String postgresqlDriverClassName;
	@Value("${spring.datasource.postgresql.url}")
	private String postgresqlUrl;
	@Value("${spring.datasource.postgresql.user}")
	private String postgresqlUser;
	@Value("${spring.datasource.postgresql.password}")
	private String postgresqlPassword;
	@Value("${spring.datasource.postgresql.hikari.maximum-pool-size}")
	private Integer postgresqlMaximumPoolSize;
	@Value("${spring.datasource.postgresql.hikari.minimum-idle}")
	private Integer postgresqlMinimumIdle;
	
	@Bean
	public DataSource postgresqlDataSource() {
		AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
		dataSource.setUniqueResourceName(Database.POSTGRESQL.name());
		dataSource.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
		
		Properties properties = new Properties();
		properties.setProperty("user", Crypt.decrypt(postgresqlUser));
		properties.setProperty("password", Crypt.decrypt(postgresqlPassword));
		properties.setProperty("url", Crypt.decrypt(postgresqlUrl));
	
		dataSource.setXaProperties(properties);
		dataSource.setMaxPoolSize(postgresqlMaximumPoolSize);
		dataSource.setMinPoolSize(postgresqlMinimumIdle);

        return dataSource;
	}
	
	@Bean(name = "postgresqlSqlSessionFactory")
    public SqlSessionFactory postgresqlSqlSessionFactory() throws Exception {
		log.info(" ### Postgresql sqlSessionFactory ### ");
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(postgresqlDataSource());
		factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/postgresql/*.xml"));
		factory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("mybatis-config-postgresql.xml"));
		return factory.getObject();
    } 
	
//	@Bean(name = "postgresqlSqlSessionTemplate")
//    public SqlSessionTemplate postgresqlSqlSessionTemplate(@Qualifier("postgresqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
