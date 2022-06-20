package com.its.ex.controller;

import com.its.ex.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TestController {

    // TestController는 TestService를 호출
    // TestService는 TestRepository를 호출
    // 의존 관계를 만들어주세요. (생성자 주입을 이용)
    private final TestService testService;
}
