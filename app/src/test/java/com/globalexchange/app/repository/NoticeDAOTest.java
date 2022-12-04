package com.globalexchange.app.repository;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class NoticeDAOTest {
    @Autowired
    private NoticeDAO noticeDAO;

    @Test
    void save() {
        NoticeVO noticeVO = new NoticeVO().create("공지사항 제목1", "공지사항 내용1");
        noticeDAO.save(noticeVO);
    }

    @Test
    void setNoticeVO() {
        NoticeVO noticeVO = noticeDAO.findById(2L);
        noticeVO.setNoticeContent("수정된 내용");
        noticeVO.setNoticeTitle("수정된 제목");
        noticeDAO.setNoticeVO(noticeVO);
    }

    @Test
    void remove() {
        noticeDAO.remove(1L);
    }

    @Test
    void findById() {
        log.info("notice : " + noticeDAO.findById(3L));
    }

    @Test
    void finadAll() {
        noticeDAO.findAll(new Criteria().create(1, 10)).stream().map(NoticeVO::getNoticeTitle).forEach(log::info);
    }

    @Test
    void findCountAll() {
        noticeDAO.findCountAll();
    }
}