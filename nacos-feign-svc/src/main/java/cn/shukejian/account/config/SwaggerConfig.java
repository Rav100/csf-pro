package cn.shukejian.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        System.out.println("swagger-ui .... ");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.shukejian.account.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Account REST API")
                .description("Shukejian Account REST API")
                .contact(new Contact("chaseshu", "https://github.com/skjme", "skjme2006@qq.com"))
                .license("The MIT License")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version("V2")
                .build();
    }
}
