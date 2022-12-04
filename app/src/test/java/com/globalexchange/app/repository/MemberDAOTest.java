package com.globalexchange.app.repository;

import com.globalexchange.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MemberDAOTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    void findByMemberNumber() {
        log.info("member : " + memberDAO.findByMemberNumber(1L));
    }

    @Test
    void myPageProfile() {
        log.info("memberProfileFile : " + memberDAO.myPageProfile(1L));
    }

    @Test
    void findAll() {
        log.info("members : " + memberDAO.findAll(new Criteria().create(1, 10, "KOREAN")));
    }

    @Test
    void findCountAll() {
        log.info("members : " + memberDAO.findCountAll(new Criteria().create(1, 10, "KOREAN")));
    }
}