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

    // 숙소가 필요해 리스트
    public List<LodgingVO> lodgingSelectAll(Criteria criteria){
        return lodgingMapper.lodgingSelectAll(criteria);
    }

    // 리스트 전체 갯수

    public int getTotal(){
        return lodgingMapper.getTotal();
    }

    // 리스트 카테고리
    public List<LodgingVO> categoryLodgingSelectAll(Criteria criteria,String lodgingLearningLang){
        return lodgingMapper.categoryLodgingSelectAll(criteria,lodgingLearningLang);
    }


    // 카테고리 게시글 전체 갯수

    public int categoryGetTotal(String lodgingLearningLang){
        return lodgingMapper.categoryGetTotal(lodgingLearningLang);
    }

    // 답글이 없는 최신글 조회
    public List<LodgingVO> findAllLatestNotAnsweredLodging(Criteria criteria){
        return lodgingMapper.selectAllLatestNotAnsweredLodging(criteria);
    }

    // 답글이 있는 최신글 조회
    public List<LodgingVO> findAllLatestAnsweredLodging(Criteria criteria){
        return lodgingMapper.selectAllLatestAnsweredLodging(criteria);
    }
}
