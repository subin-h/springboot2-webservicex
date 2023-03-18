package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Entity의 일부만 사용하므로 entity를 받아 필드에 값을 넣는다.

@Getter
@NoArgsConstructor //생성자
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
