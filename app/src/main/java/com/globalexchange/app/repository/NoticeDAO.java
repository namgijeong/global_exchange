package com.globalexchange.app.repository;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import com.globalexchange.app.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDAO {

    private final NoticeMapper noticeMapper;

    // save
    public void save(NoticeVO noticeVO) {
        noticeMapper.insert(noticeVO);
    }

    // setNoticeVO
    public void setNoticeVO(NoticeVO noticeVO) {
        noticeMapper.update(noticeVO);
    }

    // remove
    public void remove(Long noticeNumber) {
        noticeMapper.delete(noticeNumber);
    }

    // findById
    public NoticeVO findById(Long noticeNumber) {
        return noticeMapper.select(noticeNumber);
    }

    // findAll
    public List<NoticeVO> findAll(Criteria criteria) {
        return noticeMapper.selectAll(criteria);
    };

    // findCountAll
    public int findCountAll() {
        return noticeMapper.getTotal();
    }
}
