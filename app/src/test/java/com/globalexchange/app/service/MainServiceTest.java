package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.LodgingDTO;
import com.globalexchange.app.domain.vo.MeetDTO;
import com.globalexchange.app.repository.MeetDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MainServiceTest {

    @Autowired
    private MainService mainService;

    @Test
    void showAllLatestAnsweredMeet() {
        mainService.showAllLatestAnsweredMeet().stream().map(MeetDTO::getMeetTitle).forEach(log::info);
    }

    @Test
    void showAllLatestNotAnsweredMeet() {
        mainService.showAllLatestNotAnsweredMeet().stream().map(MeetDTO::getMeetTitle).forEach(log::info);
    }

    @Test
    void showAllLatestAnsweredLodging() {
        mainService.showAllLatestAnsweredLodging().stream().map(LodgingDTO::getLodgingTitle).forEach(log::info);
    }

    @Test
    void showAllLatestNotAnsweredLodging() {
        mainService.showAllLatestNotAnsweredLodging().stream().map(LodgingDTO::getLodgingTitle).forEach(log::info);
    }
}