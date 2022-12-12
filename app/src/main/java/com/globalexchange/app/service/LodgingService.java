package com.globalexchange.app.service;


import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.LodgingVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LodgingService {

    // 숙소가 필요해 리스트
    public List<LodgingVO> lodgingSelectAll(Criteria criteria);

    // 리스트 전체 갯수
    public int getTotal();

    // 리스트 카테고리
    public List<LodgingVO> categoryLodgingSelectAll(Criteria criteria,String lodgingLearningLang);

    // 카테고리 게시글 전체 갯수

    public int categoryGetTotal(String lodgingLearningLang);
}


