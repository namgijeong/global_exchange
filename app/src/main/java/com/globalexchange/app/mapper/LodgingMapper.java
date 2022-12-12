package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.LodgingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LodgingMapper {

    // 숙소가 필요해 리스트
    public List<LodgingVO> lodgingSelectAll(Criteria criteria);

    // 리스트 전체 갯수
    public int getTotal();

    // 카테고리 리스트
    public List<LodgingVO> categoryLodgingSelectAll(@Param("criteria") Criteria criteria, @Param("lodgingLearningLang") String lodgingLearningLang);
    
    // 카테고리 게시글 전체 갯수
    public int categoryGetTotal(String lodgingLearningLang);

    // 답글이 없는 최신글 조회
    public List<LodgingVO> selectAllLatestNotAnsweredLodging(Criteria criteria);

    // 답글이 있는 최신글 조회
    public List<LodgingVO> selectAllLatestAnsweredLodging(Criteria criteria);
}
