package com.its.ex.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "test_table")
public class TestEntity {
    @Id // PK이므로 반드시 있어야
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "test_id")
    private Long id;

    @Column(name = "test_Column1", length = 50) // 일반 컬럼
    private String column1;

    @Column(unique = true)
    private String testColumn2;
    // 객체이름 카멜케이스가 DB에서 snake_case로 매핑됨.
    // "test_column"으로 자동 변환
}
