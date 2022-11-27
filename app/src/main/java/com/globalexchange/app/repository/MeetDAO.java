package com.globalexchange.app.repository;
//

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.MeetVO;
import com.globalexchange.app.mapper.MeetMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
//
import java.util.List;
//
@Repository
@RequiredArgsConstructor
public class MeetDAO{
    private final MeetMapper meetMapper;

    public List<MeetVO> meetSelectAll(Criteria criteria){
        return meetMapper.meetSelectAll(criteria);
    }
    public List<MeetVO> categoryMeetSelectAll(Criteria criteria,String meetLearningLang){
        return meetMapper.categoryMeetSelectAll(criteria, meetLearningLang);
    }
    public int getTotal(){
        return meetMapper.getTotal();
    }

    public int categoryGetTotal(String meetLearningLang) {
        return meetMapper.categoryGetTotal(meetLearningLang);
    }
}
