package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DiaryObjectificationServiceTest {

    @Autowired
    private DiaryService diaryService;

    @Test
    void showAll() {
        log.info("member : " + diaryService.showAllPartner(new Criteria().create(1, 10, "KOREAN")));
    }

    @Test
    void getTotal() {
        log.info("count : " + diaryService.getTotal(new Criteria().create(1, 10, "KOREAN")));
    }

    @Test
    void showPartner() {
        log.info("member : " + diaryService.showPartner(1L));
    }
}