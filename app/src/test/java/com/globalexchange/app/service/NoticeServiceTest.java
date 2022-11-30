package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class NoticeServiceTest {
    @Autowired
    private NoticeService noticeService;

    @Test
    void register() {
        NoticeVO noticeVO = new NoticeVO().create("공지사항 제목1", "공지사항 내용1");
        noticeService.register(noticeVO);
    }

    @Test
    void modify() {
        NoticeVO noticeVO = noticeService.show(2L);
        noticeVO.setNoticeContent("수정된 내용");
        noticeVO.setNoticeTitle("수정된 제목");
        noticeService.modify(noticeVO);
    }

    @Test
    void remove() {
        noticeService.remove(1L);
    }

    @Test
    void show() {
        log.info("notice : " + noticeService.show(3L));
    }

    @Test
    void showAll() {
        noticeService.showAll(new Criteria().create(1, 10)).stream().map(NoticeVO::getNoticeTitle).forEach(log::info);
    }

    @Test
    void getTotal() {
        noticeService.getTotal();
    }
}