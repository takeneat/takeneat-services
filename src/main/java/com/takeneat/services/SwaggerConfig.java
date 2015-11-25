package com.takeneat.services;

import com.google.common.base.Predicate;
import static com.google.common.base.Predicates.or;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author paoesco
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.takeneat.services.api")
public class SwaggerConfig {

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("services-api-v1")
                .apiInfo(apiInfo("1"))
                .select()
                .paths(pathsV1())
                .build();
    }

    private Predicate<String> pathsV1() {
        return or(
                regex("/api/v1.*")
        );
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Takeneat API")
                .description("Full Takeneat API")
                .termsOfServiceUrl("http://springfox.io")
                .contact("takeneat")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version(version)
                .build();
    }

}
