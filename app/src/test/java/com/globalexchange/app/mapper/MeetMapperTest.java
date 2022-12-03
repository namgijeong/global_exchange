package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MeetMapperTest {

    @Autowired
    private MeetMapper meetMapper;

    @Test
    void selectLatestNotAnsweredMeet() {
        meetMapper.selectAllLatestNotAnsweredMeet(new Criteria().create(1, 4));
    }

    @Test
    void selectLatestAnsweredMeet() {
        meetMapper.selectAllLatestAnsweredMeet(new Criteria().create(1, 4));
    }
}