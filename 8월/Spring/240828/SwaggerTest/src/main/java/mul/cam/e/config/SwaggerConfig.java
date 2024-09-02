package mul.cam.e.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    private ApiInfo apiInfo() {
        System.out.println("SwaggerConfig apiInfo() >>");

        return new ApiInfoBuilder().title("스웨거 테스트")
                .description("API example")
                .build();
    }

    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("example")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("mul.cam.e.controller"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }
}
