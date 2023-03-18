package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.
        SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication // 반드시 최상단에 위치해야 함, 메인 클래스
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args); //내장 WAS(Web Application Server) 실행
    }
}