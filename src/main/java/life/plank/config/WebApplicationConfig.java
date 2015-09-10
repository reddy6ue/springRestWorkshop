package life.plank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Praneeth on 9/9/2015.
 */
@Configuration
@ComponentScan(basePackages = "life.plank")
@EnableWebMvc
public class WebApplicationConfig {
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        return resolver;
    }
}