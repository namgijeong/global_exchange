package com.globalexchange.app.repository;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.MeetVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MeetDAOTest {

    @Autowired
    private MeetDAO meetDAO;
    private MemberDAO memberDAO;

    @Test
    void findAllLatestNotAnsweredMeet() {
        meetDAO.findAllLatestNotAnsweredMeet(new Criteria().create(1, 4)).stream().map(MeetVO::getMeetTitle).forEach(log::info);
    }

    @Test
    void findAllLatestAnsweredMeet() {
        meetDAO.findAllLatestAnsweredMeet(new Criteria().create(1, 4)).stream().map(MeetVO::getMeetTitle).forEach(log::info);
    }

    @Test
    void findAll() {
        log.info("member : " + memberDAO.findAll(new Criteria().create(1, 10, "KOREAN")));
    }

    @Test
    void findCountAll() {
        log.info("count : " + memberDAO.findCountAll(new Criteria().create(1, 10)));
    }

    @Test
    void meetSelectAll() {
        for(MeetVO meetVO : meetDAO.meetSelectAll(new Criteria().create(1, 10))) {
            log.info("meetVO : " + meetVO);
        }
    }

    @Test
    void selectMeetRequest() {
        log.info("meetVO : " + meetDAO.selectMeetRequest(1L));
    }

    @Test
    void removeMeet() {
        meetDAO.removeMeet(36L);
    }
}