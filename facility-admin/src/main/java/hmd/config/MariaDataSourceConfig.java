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
@MapperScan(basePackages = "hmd.persistence.maria", sqlSessionFactoryRef = "mariaSqlSessionFactory")
@Configuration
public class MariaDataSourceConfig {

    @Value("${spring.datasource.maria.driver-class-name}")
    private String mariaDriverClassName;
    @Value("${spring.datasource.maria.url}")
    private String mariaUrl;
    @Value("${spring.datasource.maria.user}")
    private String mariaUser;
    @Value("${spring.datasource.maria.password}")
    private String mariaPassword;
    @Value("${spring.datasource.maria.hikari.maximum-pool-size}")
    private Integer mariaMaximumPoolSize;
    @Value("${spring.datasource.maria.hikari.minimum-idle}")
    private Integer mariaMinimumIdle;

    @Bean
    public DataSource mariaDataSource() {
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName(Database.MARIA.name());
        dataSource.setXaDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");

        Properties properties = new Properties();
        properties.setProperty("user", Crypt.decrypt(mariaUser));
        properties.setProperty("password", Crypt.decrypt(mariaPassword));
        properties.setProperty("url", Crypt.decrypt(mariaUrl));

        dataSource.setXaProperties(properties);
        dataSource.setMaxPoolSize(mariaMaximumPoolSize);
        dataSource.setMinPoolSize(mariaMinimumIdle);

        return dataSource;
    }

    @Bean(name = "mariaSqlSessionFactory")
    public SqlSessionFactory mariaSqlSessionFactory() throws Exception {
        log.info(" ### maria sqlSessionFactory ### ");
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(mariaDataSource());
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/maria/*.xml"));
        factory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("mybatis-config-maria.xml"));
        return factory.getObject();
    }
}
