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

}
