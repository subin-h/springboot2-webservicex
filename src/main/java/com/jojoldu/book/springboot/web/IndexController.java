package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index.mustache";
    }
    @GetMapping("/post/save") // /post/save 호출시
    public String postSave() {
        return "post-save.mustache"; //posts-save.mustache를 호출하는 메소드 출력
    }
}
