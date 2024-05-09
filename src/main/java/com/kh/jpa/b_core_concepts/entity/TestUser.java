package com.kh.jpa.b_core_concepts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQuery(name = "TestUser.findAdult", query = "select u from TestUser u where u.age >= 20")
public class TestUser {

    /*
     * @NamedQuery : 자주 사용되거나 복잡한 쿼리를 미리 정의해두고
     *               레포지토리에서 선언하여 사용
     *   - name : 엔티티명.사용할_메소드_명
     *   - query : 실행할 쿼리
     */


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_uid")
    @SequenceGenerator(name="seq_uid", sequenceName = "SEQ_UID", allocationSize = 1)
    private Long id;

    private String name;
    private int age;

    // 테스트 시 사용하기 위해 생성자 정의
    public TestUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
