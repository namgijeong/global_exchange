package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.LodgingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LodgingAnswerMapper {

    public int getCount(Long lodgingNumber);
}
