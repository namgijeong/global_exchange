package com.globalexchange.app.repository;

import com.globalexchange.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.login.CredentialException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LodgingDAOTest {

    @Autowired
    private LodgingDAO lodgingDAO;

    @Test
    void findAllLatestNotAnsweredLodging() {
        lodgingDAO.findAllLatestNotAnsweredLodging(new Criteria().create(1, 4));
    }

    @Test
    void findAllLatestAnsweredLodging() {
        lodgingDAO.findAllLatestAnsweredLodging(new Criteria().create(1, 4));
    }
}