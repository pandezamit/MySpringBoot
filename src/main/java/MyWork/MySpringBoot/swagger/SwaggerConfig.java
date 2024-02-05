package MyWork.MySpringBoot.swagger;

import org.springdoc.core.customizers.OperationCustomizer;
        import org.springframework.context.annotation.Bean;
        import org.springframework.stereotype.Component;

        import io.swagger.v3.oas.models.Components;
        import io.swagger.v3.oas.models.OpenAPI;
        import io.swagger.v3.oas.models.info.Info;
        import io.swagger.v3.oas.models.info.License;
        import io.swagger.v3.oas.models.parameters.Parameter;
        import io.swagger.v3.oas.models.security.SecurityScheme;
        import io.swagger.v3.oas.models.servers.Server;

@Component
public class SwaggerConfig {

    @Bean
    public OperationCustomizer customize() {
        return (operation, handlerMethod) -> operation
                .addParametersItem(new Parameter().in("header").required(true).description("Access token mandatory").name("X-Access-Token"))
                .addParametersItem(new Parameter().in("cookie").required(false).description("Caller indentifier").name("X-Caller-Name"));
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().addServersItem(new Server().url("https://myserver.com"))
                .addServersItem(new Server().url("https://google.com"))
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info().title("SpringShop API").version("0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
    view rawSwaggerConfig.java hosted with ❤ by GitHub