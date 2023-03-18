package com.jojoldu.book.springboot.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) //RequsetMapping 할당된 모든 URL 리스트 추출
                .paths(PathSelectors.ant("/api/**")) // 그 중 /api/** 인 URL들만 필터링
                // /api/path를 가진 url만 공개, 모든 화면을 노출시키고 싶다면 /api를 지우면 된다.
                .build();
    }
}
