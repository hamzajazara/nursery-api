package com.nurseryapi.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SCHEMA_NAME = "Nursery Api";

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.nurseryapi.controller")).paths(PathSelectors.any())
				.build().securitySchemes(Collections.singletonList(securitySchema()))
				.securityContexts(Collections.singletonList(securityContext()))
				.ignoredParameterTypes(AuthenticationPrincipal.class, Pageable.class);
	}

	/**
	 *
	 * @return
	 */
	private OAuth securitySchema() {
		List<GrantType> grantTypes = new ArrayList<>();
		grantTypes.add(new ResourceOwnerPasswordCredentialsGrant("/oauth/token"));
		return new OAuthBuilder().name(SCHEMA_NAME).scopes(Collections.emptyList()).grantTypes(grantTypes).build();
	}

	/**
	 *
	 * @return
	 */
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/api/**"))
				.build();
	}

	/**
	 *
	 * @return
	 */
	private List<SecurityReference> defaultAuth() {
		return Collections.singletonList(new SecurityReference(SCHEMA_NAME, new AuthorizationScope[0]));
	}
}