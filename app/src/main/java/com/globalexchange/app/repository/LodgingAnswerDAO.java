package com.globalexchange.app.repository;

import com.globalexchange.app.mapper.LodgingAnswerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LodgingAnswerDAO {
    private final LodgingAnswerMapper lodgingAnswerMapper;

    public int findCount(Long lodgingNumber){
        return lodgingAnswerMapper.getCount(lodgingNumber);
    }
}
