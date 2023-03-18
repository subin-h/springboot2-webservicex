package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// 주요 어노테이션을 클래스에 가깝게 둔다.
// Entity 클래스에는 절대 Setter 메소드를 만들지 않는다.
// 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 구분이 불가능하기 때문

@Getter //롬복, getter 메소드 자동 생성
@NoArgsConstructor // 롬복, 기본 생성자 자동 추가
@Entity // JPA의 어노테이션, 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity { // 실제 DB의 테이블과 매칭될 클래스, entity 클래스라고도 함

    @Id //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙, GenerationType.IDENTITY = auto_increment 부여 (데이터 증가 시, 자동으로 1씩 증가)
    private Long id; //id 타입, JPA의 long 타입은 = SQL의 bigint 타입

    @Column(length = 500, nullable = false)
    //Column = 테이블의 탈럼을 나타내며 굳이 선언하지 않아도 해당 클래스의 필드는 모드 칼럼이다.
    //사용하는 이유는, 기본값 외 추가로 변경이 필요한 옵션이 있으면 사용한다.
    //문자열의 경우 VARCHAR(255)가 기본값, length로 500으로 늘림
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    //사용하는 이유는, 기본값 외 추가로 변경이 필요한 옵션이 있으면 사용한다.
    //타입을 TEXT로 변경하여 어노테이션을 사용한 것.
    private String content;

    private String author;

    @Builder // 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
