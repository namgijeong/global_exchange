package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.MeetDTO;
import com.globalexchange.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Test
    void register() {
        NoticeVO noticeVO = new NoticeVO().create("공지사항 제목1", "공지사항 내용1");
        adminService.register(noticeVO);
    }

    @Test
    void modify() {
        NoticeVO noticeVO = adminService.show(2L);
        noticeVO.setNoticeContent("수정된 내용");
        noticeVO.setNoticeTitle("수정된 제목");
        adminService.modify(noticeVO);
    }

    @Test
    void remove() {
        adminService.remove(1L);
    }

    @Test
    void show() {
        log.info("notice : " + adminService.show(3L));
    }

    @Test
    void showAll() {
        adminService.showAll(new Criteria().create(1, 10)).stream().map(NoticeVO::getNoticeTitle).forEach(log::info);
    }

    @Test
    void getTotal() {
        adminService.getTotal();
    }

    @Test
    void showAllMeetTest() {
        for(MeetDTO meetDTO : adminService.showAllMeet(new Criteria().create(1, 10))) {
            log.info("meetTitle : " + meetDTO.getMeetTitle());
        }

    }

    @Test
    void showMeetDetail() {
        log.info("meetDTO : " + adminService.showMeetDetail(1L));
    }
}