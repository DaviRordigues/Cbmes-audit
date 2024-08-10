package br.es.gov.cb.cbmesaudit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//TODO: TESTAR SE O SWAGGER ESTÁ FUNCIONANDO. NAO CONSEGUI VERIFICAR SE ESTÁ FUNCIONANDO EM: http://localhost:8080/swagger-ui/
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//TODO: ESTE PACOTE DEVE SER ALTERADO PARA O PACOTE QUE CONTÉM OS CONTROLLERS
				.apis(RequestHandlerSelectors.basePackage("br.es.gov.cb.cbmesaudit.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Audit API")
				.description("API to manage audits")
				.version("1.0.0")
				.build();
	}
}
