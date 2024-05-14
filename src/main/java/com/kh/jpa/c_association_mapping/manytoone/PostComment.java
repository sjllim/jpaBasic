package com.kh.jpa.c_association_mapping.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PostComment {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
}
