package com.gateway;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.xmlpull.v1.XmlPullParserException;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@EnableZuulProxy  // act as zuul proxy.
@EnableEurekaServer //for making this application as eureka server.
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
    public Docket api() throws IOException, XmlPullParserException {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.gateway.api"))
          .paths(PathSelectors.any())
          .build();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
