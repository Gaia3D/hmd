package hmd.config;

import java.util.Properties;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.mybatis.spring.annotation.MapperScan;
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
@ComponentScan(	basePackages = {"hmd.service, hmd.persistence"},
				includeFilters = {	@Filter(type = FilterType.ANNOTATION, value = Component.class),
									@Filter(type = FilterType.ANNOTATION, value = Service.class),
									@Filter(type = FilterType.ANNOTATION, value = Repository.class) },
				excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class) )
public class RootConfig {
	
	@Bean(name="userTransactionServiceImp", initMethod = "init", destroyMethod = "shutdownForce")
    public UserTransactionServiceImp userTransactionServiceImp() {
		Properties properties = new Properties();
		properties.setProperty("com.atomikos.icatch.max_timeout", "600000");
		UserTransactionServiceImp userTransactionServiceImp = new UserTransactionServiceImp(properties);
		return userTransactionServiceImp;
	}

	@Bean
	@DependsOn("userTransactionServiceImp")
	public UserTransaction userTransaction() {
		UserTransactionImp userTransactionImp = new UserTransactionImp();
		return userTransactionImp;
	}

//	@Bean(initMethod = "init", destroyMethod = "close")
//	@DependsOn("userTransactionServiceImp")
//	public TransactionManager userTransactionManager() {
//		UserTransactionManager userTransactionManager = new UserTransactionManager();
//		userTransactionManager.setStartupTransactionService(false);
//		userTransactionManager.setForceShutdown(false);
//		return userTransactionManager;
//	}
	
	@Bean(initMethod = "init", destroyMethod = "close")
	public UserTransactionManager atomikosTransactionManager() throws SystemException {
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		// second
		userTransactionManager.setTransactionTimeout(600);
		return userTransactionManager;
	}
	
//	@Bean
//	@DependsOn("userTransactionServiceImp")
//	public PlatformTransactionManager transactionManager() {
//		return new JtaTransactionManager(userTransaction(), userTransactionManager());
//	}    
	
	@Bean
	public JtaTransactionManager transactionManager(UserTransactionManager atomikosTransactionManager) {
		JtaTransactionManager transactionManager = new JtaTransactionManager();
		transactionManager.setTransactionManager(atomikosTransactionManager);
		transactionManager.setUserTransaction(atomikosTransactionManager);
		return transactionManager;
	}
}
