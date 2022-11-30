package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    // insert
    public void insert(NoticeVO noticeVO);

    // update
    public void update(NoticeVO noticeVO);

    // delete
    public void delete(Long noticeNumber);

    // select
    public NoticeVO select(Long noticeNumber);

    // selectAll
    public List<NoticeVO> selectAll(Criteria criteria);

    // getTotal
    public int getTotal();
}
