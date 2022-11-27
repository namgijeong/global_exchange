package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.MeetVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeetMapper {
    public List<MeetVO> meetSelectAll(Criteria criteria);
    public List<MeetVO> categoryMeetSelectAll(@Param("criteria") Criteria criteria, @Param("meetLearningLang") String meetLearningLang);
    public int getTotal();
    public int categoryGetTotal(String meetLearningLang);
}
