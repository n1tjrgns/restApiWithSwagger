package com.example.restservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Collections;

//@Configuration
@EnableSwagger2
@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
    //   http://localhost:8080/swagger-ui.html -> 실행 url
    @Bean
    @Primary
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)// 응답메시지를 디폴트 값을 사용할건지
                .globalResponseMessage(RequestMethod.GET, getArrayList());  //전반적인 반환 Message 셋팅
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API Swagger 적용하기",
                "스웨거 적용해보기",
                "API TOS",
                "Terms of service",
                new Contact("n1tjrgns", "n1tjrgns.tistory.com", "n1tjrgns@naver.com"),
                "", "", Collections.emptyList());
    }

    private ArrayList<ResponseMessage> getArrayList() {
        ArrayList<ResponseMessage> lists = new ArrayList<>();

        lists.add(new ResponseMessageBuilder().code(500).message("서버에러").responseModel(new ModelRef("Error")).build());
        lists.add(new ResponseMessageBuilder().code(403).message("권한없음").responseModel(new ModelRef("Forbbiden")).build());
        lists.add(new ResponseMessageBuilder().code(404).message("페이지 찾을 수 없음").responseModel(new ModelRef("PageNotFound")).build());

        return lists;
    }

}
