package hmd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:hmd.properties")
@ConfigurationProperties(prefix = "hmd")
public class PropertiesConfig {

	private String osType;
	private boolean callRemoteEnable;
	private String serverIp;
	private String restAuthKey;
	
	private String outputDir;
	private String logBaseDir;
	private String logBaseName;
}
