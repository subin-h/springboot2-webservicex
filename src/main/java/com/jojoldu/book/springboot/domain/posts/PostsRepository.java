package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


// DB Layer 접근자, DAO
public interface PostsRepository extends JpaRepository<Posts,Long> {
    //JpaRepository<Entity 클래스, PK 타입> 상속 = 기본적인 CRUD 메소드 자동 생성성
    //이때, entity 클래스와 Repository는 함께 위치해야 함. 즉 domain 패키지에서 부조건 함께 관리해야한다.
}

