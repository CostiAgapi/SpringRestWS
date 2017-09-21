package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ConstantinAgapi on 21/09/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"config","controllers","dao","services"})
public class SpringConfig {


}
