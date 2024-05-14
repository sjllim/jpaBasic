package com.kh.jpa.c_association_mapping.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    private Long id;

    /**
     * {@code @OneToMany} mappedBy 양방향 관계 매핑 시 연관 관계의 주인을 가리킴
     *                     * 여기서는 PostComment 엔티티의 post 필드를 가르킴
     */
    @OneToMany(mappedBy = "post")
    private List<PostComment> comments = new ArrayList<>();
}
