package hmd.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfig {

    /**
    * WEB-INF 밑에서 template를 가져 올때
    * @param servletContext
    * @return
    */
    @Bean(name = "templateResolver")
    public ServletContextTemplateResolver templateResolver(ServletContext servletContext) {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
        resolver.setPrefix("WEB-INF/templates/"); //webapp 디렉토리 내의 뷰페이지 위치
        resolver.setSuffix(".html"); // 뷰페이지들에 포함되는 파일들의 확장자
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false); //배포 할때는 true로 변경.
        return resolver;
    }

    @Bean(name = "templateEngine")
    public SpringTemplateEngine templateEngine(@Qualifier("templateResolver") ServletContextTemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setDialect(new LayoutDialect());
        engine.setTemplateResolver(templateResolver);
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(@Qualifier("templateEngine") SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }
}
