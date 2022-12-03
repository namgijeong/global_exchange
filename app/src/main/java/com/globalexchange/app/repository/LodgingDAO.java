package com.globalexchange.app.repository;
//

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.mapper.LodgingMapper;
import com.globalexchange.app.mapper.MeetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//

//
@Repository
@RequiredArgsConstructor
public class LodgingDAO {
    private final LodgingMapper lodgingMapper;

    // 답글이 없는 최신글 조회
    public List<LodgingVO> findAllLatestNotAnsweredLodging(Criteria criteria){
        return lodgingMapper.selectAllLatestNotAnsweredLodging(criteria);
    }

    // 답글이 있는 최신글 조회
    public List<LodgingVO> findAllLatestAnsweredLodging(Criteria criteria){
        return lodgingMapper.selectAllLatestAnsweredLodging(criteria);
    }
}
