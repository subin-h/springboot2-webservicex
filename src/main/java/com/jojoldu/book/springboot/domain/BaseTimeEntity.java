package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
// 모든 엔티티의 상위 클래스
@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 칠드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing 기능을 포함(수정,생성시간 자동생성)
public abstract class BaseTimeEntity {
    @CreatedDate // 필드, entity 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //필드, 조회한 entity 값을 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;
}
