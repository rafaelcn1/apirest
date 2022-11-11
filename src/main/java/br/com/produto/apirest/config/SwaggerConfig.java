package br.com.produto.apirest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // Anotação para o spring saber que é uma classe de configuração
@EnableSwagger2 // Anotação para o Spring Boot para ativar o Swagger
public class SwaggerConfig {

	@Bean
	public Docket produtoApi() { // Para usr a classe externa Docket, tem que usar o @Bean
		
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.produto.apirest")) // é o pacote onde tem todas as classes java do projeto
		.paths(regex("/api.*"))  // O caminho que pode ser acessado, valor informado na classe de resource, definido na anotação @RequestMapping atraves do parametro Value
		.build()
		.apiInfo(metaInfo()); // Chamar o metodo criado com as informações
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Produtos API Rest", // Nome da API
				"API REST de cadastro de Produtos", // Descrição da API
				"1.0", // Versão da API
				"Termos de Serviço", // O termo do serviço
				new springfox.documentation.service.Contact("Rafael Cunha", "https://github.com/rafaelcn1",
						"rafaelcn1@hotmail.com"), // Contato de quem criou a aplicação
				"Apache License Version 2.0", // versão da licença 
				"https://www.apache.org/license.html", // Site da licença 
				new ArrayList<VendorExtension>());
		
		return apiInfo;
	}

}
