package hmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FacilityUserApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FacilityUserApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FacilityUserApplication.class);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
//					.allowedHeaders("*");
//			}
//		};
//	}
	
	// TODO 내장 된건가? spring.mvc.hiddenmethod.filter.enabled=false로 하고 활성화 가능
//	@Bean
//	public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
//		FilterRegistrationBean<HiddenHttpMethodFilter> registrationBean = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
//		registrationBean.addUrlPatterns("/*");
//		return registrationBean;
//	}
}