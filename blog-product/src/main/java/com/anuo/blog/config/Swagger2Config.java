package com.anuo.blog.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //xml  bean
@EnableSwagger2
public class Swagger2Config {

    //核心对象 Docket

    // 前端
    @Bean
    public Docket webApiConfig(){
        // 过滤掉 /admin 的所有请求
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }


    private ApiInfo webApiInfo(){
        // 建造者模式
        return new ApiInfoBuilder()
                .title("颜少剑-产品中心API文档")
                .description("产品中心微服务！")
                .version("1.0")
                .contact(new Contact("Coding", "http://baidu.com", "coding666@qq.com"))
                .build();
    }

    // 后台管理员的
    @Bean
    public Docket adminApiConfig(){
        // 只要 /admin 的所有请求
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    private ApiInfo adminApiInfo(){
        // 建造者模式
        return new ApiInfoBuilder()
                .title("颜少剑-产品中心管理端API文档")
                .description("产品中心微服务管理中心！")
                .version("1.0")
                .contact(new Contact("Coding", "http://baidu.com", "coding666@qq.com"))
                .build();
    }



}
