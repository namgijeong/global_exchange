package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void select() {
        log.info("member : " + memberMapper.select(1L));
    }

    @Test
    void selectAll() {
        log.info("member : " + memberMapper.selectAll(new Criteria().create(1, 16, "ALL")));
    }

    @Test
    void getTotal() {
        log.info("count : " + memberMapper.getTotal(new Criteria().create(1, 16, "ALL")));
    }

    @Test
    void myPageProfile() {
        log.info("memberProfileFile" + memberMapper.myPageProfile(1L));
    }

    @Test
    void diaryTotalPost() {
        log.info("total diary count : " + memberMapper.diaryTotalPost(1L));
    }

    @Test
    void meetPost() {
        log.info("total meet post count : " + memberMapper.meetPost(1L));
    }

    @Test
    void lodgingPost() {
        log.info("total lodging post count : " + memberMapper.lodgingPost(1L));
    }

    @Test
    void meetAnswer() {
        log.info("total meet answer count : " + memberMapper.meetAnswer(1L));
    }

    @Test
    void lodgingAnswer() {
        log.info("total lodging answer count : " + memberMapper.lodgingAnswer(1L));
    }

    @Test
    void insertReport() {
        memberMapper.insertReport(1L, 3L);
    }
}