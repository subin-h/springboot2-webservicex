package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.
        RestController;

@RestController // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어줌
public class HelloController {
    @GetMapping("/hello") // Http 메소드의 Get 요청을 받을 수 있는 API 생성
    public String hello() {
        return "hello";
    } //hello 요청이 오면 hello 반환

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        /*@RequestParam = 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        여기서는 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장됨.
         */
        return new HelloResponseDto(name, amount); //외부 class HelloResponseDto에서 호출한 name amout API를 넘겨줌.
    }


}

