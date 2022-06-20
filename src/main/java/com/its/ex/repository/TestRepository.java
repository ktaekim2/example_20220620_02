package com.its.ex.repository;

import com.its.ex.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받기 때문에 알아서 @Repository로 등록됨
public interface TestRepository extends JpaRepository<TestEntity, Long> { // 대상 entity, pk타입
}
