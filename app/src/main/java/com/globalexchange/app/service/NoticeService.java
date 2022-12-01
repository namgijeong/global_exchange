package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import com.globalexchange.app.repository.NoticeDAO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeDAO noticeDAO;

    // showAll
    public List<NoticeVO> showAll(Criteria criteria) {
        return noticeDAO.findAll(criteria);
    };

    // getTotal
    public int getTotal() {
        return noticeDAO.findCountAll();
    }
}
