package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class NoticeMapperTest {
    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    void insert() {
        NoticeVO noticeVO = new NoticeVO().create("공지사항 제목1", "공지사항 내용1");
        noticeMapper.insert(noticeVO);
    }

    @Test
    void update() {
        NoticeVO noticeVO = noticeMapper.select(2L);
        noticeVO.setNoticeContent("수정된 내용");
        noticeVO.setNoticeTitle("수정된 제목");
        noticeMapper.update(noticeVO);
    }

    @Test
    void delete() {
        noticeMapper.delete(1L);
    }

    @Test
    void select() {
        log.info("notice : " + noticeMapper.select(3L));
    }

    @Test
    void selectAll() {
        noticeMapper.selectAll(new Criteria().create(1, 10)).stream().map(NoticeVO::getNoticeTitle).forEach(log::info);
    }

    @Test
    void getTotal() {
        noticeMapper.getTotal();
    }
}