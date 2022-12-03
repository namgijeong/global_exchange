package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LodgingMapperTest {

    @Autowired
    private LodgingMapper lodgingMapper;

    @Test
    void selectAllLatestNotAnsweredLodging() {
        lodgingMapper.selectAllLatestNotAnsweredLodging(new Criteria().create(1, 4));
    }

    @Test
    void selectAllLatestAnsweredLodging() {
        lodgingMapper.selectAllLatestAnsweredLodging(new Criteria().create(1, 4));
    }
}