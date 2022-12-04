package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.LodgingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LodgingMapper {

    // 답글이 없는 최신글 조회
    public List<LodgingVO> selectAllLatestNotAnsweredLodging(Criteria criteria);

    // 답글이 있는 최신글 조회
    public List<LodgingVO> selectAllLatestAnsweredLodging(Criteria criteria);
}
