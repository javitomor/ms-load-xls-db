package org.loadxls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"org.loadxls"})
@EnableJpaRepositories({"org.loadxls.repository"})
@EntityScan({"org.loadxls.model"})
@EnableSwagger2
public class LoadXlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadXlsApplication.class, args);
    }
}
