package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import com.globalexchange.app.repository.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final NoticeDAO noticeDAO;

    // register
    public void register(NoticeVO noticeVO) {
        noticeDAO.save(noticeVO);
    }

    // modify
    public void modify(NoticeVO noticeVO) {
        noticeDAO.setNoticeVO(noticeVO);
    }

    // remove
    public void remove(Long noticeNumber) {
        noticeDAO.remove(noticeNumber);
    }

    // show
    public NoticeVO show(Long noticeNumber) {
        return noticeDAO.findById(noticeNumber);
    }

    // showAll
    public List<NoticeVO> showAll(Criteria criteria) {
        return noticeDAO.findAll(criteria);
    };

    // getTotal
    public int getTotal() {
        return noticeDAO.findCountAll();
    }
}
