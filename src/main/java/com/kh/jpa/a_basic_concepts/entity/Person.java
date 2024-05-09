package com.kh.jpa.a_basic_concepts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity             // JPA 에서 사용되는 어노테이션.
@Getter
@Setter
@ToString
public class Person {
    /*
     * * 엔티티 (Entity) : 데이터베이스 테이블과 매핑되는 클래스
     *   - @Entity 추가 시
     *          클래스 내 각 필드는 해당 테이블의 컬럼과 매핑되며,
     *          클래스의 인스턴스는 해당 테이블의 행(데이터)에 해당됨
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pid")
    @SequenceGenerator(name="seq_pid", sequenceName = "SEQ_PID", allocationSize = 1)
    private Long id;

    private String name;
    
    /*
     * 위에 선언된 id, name 필드는 person 테이블의 컬럼으로 추가됨.
     * - @Id 추가 시 해당 필드는 테이블의 기본키로 매핑
     * - @GeneratedValue 추가 시 기본키 생성 규칙을 적용
     *   * GenerationType.AUTO : JPA 에서 자동으로 적절한 생성 규칙 선택. 주로 자동 생성 시 사용
     *   * GenerationType.IDENTITY : 데이터베이스의 자동 증가 컬럼을 사용
     *   * GenerationType.SEQUENCE : 데이터베이스의 시퀀스 사용
     */
}
