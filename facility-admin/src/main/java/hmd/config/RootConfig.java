package hmd.config;

import java.util.Properties;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

import lombok.extern.slf4j.Slf4j;

/**
 * root context 설정
 * @author Cheon JeongDae
 *
 */
@Slf4j
@Configuration
@ComponentScan(	basePackages = {"hmd.service, hmd.persistence.oracle, hmd.persistence.postgresql"},
                includeFilters = {	@Filter(type = FilterType.ANNOTATION, value = Component.class),
                                    @Filter(type = FilterType.ANNOTATION, value = Service.class),
                                    @Filter(type = FilterType.ANNOTATION, value = Repository.class) },
                excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class) )
public class RootConfig {

    @Autowired
    private PropertiesConfig propertiesConfig;


    @Bean(name="userTransactionService", initMethod = "init", destroyMethod = "shutdownForce")
    public UserTransactionServiceImp userTransactionService() {
        Properties properties = new Properties();
        properties.setProperty("com.atomikos.icatch.service",  "com.atomikos.icatch.standalone.UserTransactionServiceFactory");
        properties.setProperty("com.atomikos.icatch.log_base_name", propertiesConfig.getLogBaseName());
        properties.setProperty("com.atomikos.icatch.output_dir", propertiesConfig.getOutputDir());
        properties.setProperty("com.atomikos.icatch.log_base_dir", propertiesConfig.getLogBaseDir());
        UserTransactionServiceImp userTransactionServiceImp = new UserTransactionServiceImp(properties);
        return userTransactionServiceImp;
    }

    @DependsOn("userTransactionService")
    @Bean(initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikosTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setStartupTransactionService(false);
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    @DependsOn("userTransactionService")
    @Bean
    public UserTransactionImp atomikosUserTransaction() throws SystemException {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(300);
        return userTransactionImp;
    }

    @DependsOn("userTransactionService")
    @Bean
    public JtaTransactionManager jtaTransactionManager() throws SystemException {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
        jtaTransactionManager.setUserTransaction(atomikosUserTransaction());
        return jtaTransactionManager;
    }
}
