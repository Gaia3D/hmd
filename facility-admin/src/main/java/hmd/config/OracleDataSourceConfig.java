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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import hmd.security.Crypt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "hmd.persistence.oracle", sqlSessionFactoryRef = "oracleSqlSessionFactory")
@Configuration
public class OracleDataSourceConfig {

    @Value("${spring.datasource.oracle.driver-class-name}")
    private String oracleDriverClassName;
    @Value("${spring.datasource.oracle.url}")
    private String oracleUrl;
    @Value("${spring.datasource.oracle.user}")
    private String oracleUser;
    @Value("${spring.datasource.oracle.password}")
    private String oraclePassword;
    @Value("${spring.datasource.oracle.hikari.maximum-pool-size}")
    private Integer oracleMaximumPoolSize;
    @Value("${spring.datasource.oracle.hikari.minimum-idle}")
    private Integer oracleMinimumIdle;

    @Bean
    public DataSource oracleDataSource() {
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName(Database.ORACLE.name());
        dataSource.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");

        Properties properties = new Properties();
        properties.setProperty("user", Crypt.decrypt(oracleUser));
        properties.setProperty("password", Crypt.decrypt(oraclePassword));
        properties.setProperty("URL", Crypt.decrypt(oracleUrl));

        dataSource.setXaProperties(properties);
        dataSource.setMaxPoolSize(oracleMaximumPoolSize);
        dataSource.setMinPoolSize(oracleMinimumIdle);

        return dataSource;
    }

    @Primary
    @Bean(name = "oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory() throws Exception {
        log.info(" ### Oracle sqlSessionFactory ### ");
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(oracleDataSource());
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/oracle/*.xml"));
        factory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("mybatis-config-oracle.xml"));
        return factory.getObject();
    }

}
