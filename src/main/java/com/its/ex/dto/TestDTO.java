package com.its.ex.dto;

import com.its.ex.entity.TestEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TestDTO {
    private Long id;
    private String column1;
    private String testColumn2;

    public TestDTO(String column1, String testColumn2) { // alt + insert -> constructor
        this.column1 = column1;
        this.testColumn2 = testColumn2;
    }

    public static TestDTO toDTO(TestEntity testEntity) {
        TestDTO testDTO = new TestDTO();
        testDTO.setId(testEntity.getId());
        testDTO.setColumn1(testEntity.getColumn1());
        testDTO.setTestColumn2(testEntity.getTestColumn2());
        return testDTO;
    }
}
