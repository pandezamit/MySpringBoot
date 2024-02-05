package MyWork.MySpringBoot.swagger;

public class SwaggerUtility {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
                .apis(RequestHandlerSelectors.basePackage("com.abhicodes.springfoxswagger3.controller"))
                .paths(PathSelectors.ant("/api/**")).build()
                .globalRequestParameters(Arrays.asList(
                        new RequestParameterBuilder().name("x-global-header-1").description("Remote User")
                                .in(ParameterType.HEADER).required(true)
                                .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder
                                        .allowEmptyValue(false)
                                        .model(modelSpecificationBuilder -> modelSpecificationBuilder
                                                .scalarModel(ScalarType.STRING)))
                                .build(),
                        new RequestParameterBuilder().name("x-global-header-2").description("Impersonate User")
                                .in(ParameterType.HEADER).required(false)
                                .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder
                                        .allowEmptyValue(false)
                                        .model(modelSpecificationBuilder -> modelSpecificationBuilder
                                                .scalarModel(ScalarType.STRING)))
                                .build()));
    }


    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpringShop API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

}
