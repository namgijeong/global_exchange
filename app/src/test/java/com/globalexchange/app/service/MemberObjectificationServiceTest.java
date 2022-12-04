package com.globalexchange.app.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberObjectificationServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void show() {
        log.info("member : " + memberService.show(1L));
    }
}