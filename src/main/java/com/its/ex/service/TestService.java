package com.its.ex.service;

import com.its.ex.dto.TestDTO;
import com.its.ex.entity.TestEntity;
import com.its.ex.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public Long save(TestDTO testDTO) {
        System.out.println("testDTO = " + testDTO);

        // testDTO 객체에 담긴 값을 TestEntity 객체에 옮겨담기
        TestEntity testEntity1 = TestEntity.toEntity(testDTO);
        Long id = testRepository.save(testEntity1).getId(); // jpa save method는 save한 entity를 리턴함
        return id;
    }

    public TestDTO findById(Long id) {
        Optional<TestEntity> optionalTestEntity = testRepository.findById(id);
        // findById 하면 Optional 객체로 감싸줌: nullpointexception 방지
        if(optionalTestEntity.isPresent()) {
            // isPresent() 메서드: 있니? -> true: 있다, isEmpty(): 비었니? -> true: 비었다
            // 조회된 결과가 있다
            TestEntity testEntity = optionalTestEntity.get(); // get(): Optional 감싸져 있는걸 까는 것
            TestDTO testDTO = TestDTO.toDTO(testEntity);
            return testDTO;
//            return TestDTO.toDTO(optionalTestEntity.get());
        } else {
            // 조회된 결과가 없다
            return null;
        }
    }

    public List<TestDTO> findAll() {
        List<TestEntity> entityList = testRepository.findAll();
        List<TestDTO> testDTOList = new ArrayList<>();
        for(TestEntity t : entityList) {
            TestDTO testDTO = TestDTO.toDTO(t);
//            testDTO.setColumn1(t.getColumn1());
//            testDTO.setTestColumn2(t.getTestColumn2());
//            testDTO.setId(t.getId());
            testDTOList.add(testDTO);
        }
        return testDTOList;
    }

    public void delete(Long id) {
        testRepository.deleteById(id);
    }

    public Long update(TestDTO testDTO) {
        // save 매서드 호출로 update 쿼리 가능(단, id가 같이 가야함)
        TestEntity testEntity = TestEntity.toUpdateEntity(testDTO);
        Long id = testRepository.save(testEntity).getId();
        return id;
    }
}
