package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.
        Autowired;
import org.springframework.boot.test.autoconfigure.web.
        servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.
        MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@RunWith(SpringRunner.class) //테스트를 진행할 때, JUnit에 내장된 실행자 외 다른실해 실행, 스프링루너라는 실행자를 사용
@WebMvcTest(controllers = HelloController.class) // Web에 집중할 수 있는 어노테이션, 단 service component repository는 사용 불가
public class HelloControllerTest {
    @Autowired // 스프링이 관리하는 bean을 주입 받음
    private MockMvc mvc; // 웹 api를 테스트 할 때 사용, mvc 테스트의 시작점.
    @Test
    public void hello가_리턴된다() throws Exception { //throws Exception = 예외처리, 강제로 예외처리,
        String hello = "hello";

        mvc.perform(get("/hello")) // hello 주소로 http get요청, 체이닝이 지원됨
                .andExpect(status().isOk())
                // mvc.perform의 결과를 검증한다. http header의 status를 검증 (200 400 등의 상태 검증)
                .andExpect(content().string(hello));
                // 결과를 검증한다. 응답 본문 내용, 즉 hello를 리턴하기 때문에 이 값이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                // param : API 테스트할때 사용될 요청 파라미터를 설정,값은 String만 허용, 그래서 숫자 날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 함.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
                // jasonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드, 이때 $ 기준 필드명

    }
}