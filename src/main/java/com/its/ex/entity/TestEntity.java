package com.its.ex.entity;

import com.its.ex.dto.TestDTO;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Test;

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

    // 목적: TestDTO 객체를 받아서 Entity 객체에 옮겨 담은 후 Entity 객체를 리턴
    // Service 클래스에서 toEntity 메서드를 호출해서 리턴받은 객체를
    // testRepository의 save 메서드로 전달하세요.
    public static TestEntity toEntity(TestDTO testDTO) {
        // static: 객체를 만들지 않고 TestEntity.toEntity(클래스.메서드)로 호출
        // 정적 팩토리 메서드 (다른 클래스에서 객체를 만들지 않고 직접 접근 가능)
        // Entity 객체에 대한 기본 생성자를 외부에서 막을 수 있음.
        // 설계 취지: 레파지토리에서만 접근할 수 있게
        // 장점: 내부구조는 노출이 안된채 매개변수와 리턴만 공개하여 캡슐화 가능
        // 장점: 원하는 리턴을 줄 수 있음
        TestEntity testEntity = new TestEntity();
        testEntity.setColumn1(testDTO.getColumn1());
        testEntity.setTestColumn2(testDTO.getTestColumn2());
        return testEntity;
    }

    public static TestEntity toUpdateEntity(TestDTO testDTO) {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(testDTO.getId());
        testEntity.setColumn1(testDTO.getColumn1());
        testEntity.setTestColumn2(testDTO.getTestColumn2());
        return testEntity;
    }
}
