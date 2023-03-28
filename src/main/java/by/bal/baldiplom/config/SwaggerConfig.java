package by.bal.baldiplom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "e-Scooters Sharing API",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Odio ut enim blandit volutpat maecenas. Non sodales neque sodales ut etiam sit amet nisl. Tellus integer feugiat scelerisque varius morbi enim. Maecenas ultricies mi eget mauris pharetra et ultrices. Id faucibus nisl tincidunt eget nullam non. Dictumst vestibulum rhoncus est pellentesque elit. Varius quam quisque id diam vel quam. Dolor morbi non arcu risus quis varius quam quisque. Urna porttitor rhoncus dolor purus non enim praesent elementum facilisis. Arcu cursus vitae congue mauris rhoncus aenean vel elit scelerisque. Etiam non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Pharetra et ultrices neque ornare aenean. Posuere lorem ipsum dolor sit amet consectetur adipiscing. Tellus at urna condimentum mattis pellentesque id nibh tortor id. Turpis massa sed elementum tempus egestas. Scelerisque fermentum dui faucibus in. Hendrerit gravida rutrum quisque non tellus orci ac auctor augue. Mollis nunc sed id semper risus in. Elit duis tristique sollicitudin nibh.",
                "1.0",
                "Terms of service",
                new Contact("Pavel Bal", "www.baeldung.com", "balpoi000@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}
