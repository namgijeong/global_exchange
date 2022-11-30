package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.DiaryDTO;
import com.globalexchange.app.domain.vo.DiaryVO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DiaryService {
    //    추가
    public void register(DiaryDTO diaryDTO);
    //    수정
    public void modify(DiaryDTO diaryDTO);
    //    삭제
    public void remove(Long diaryNumber);
    //    조회
    public DiaryDTO show(Long diaryNumber);
    //    전체 조회
    public List<DiaryVO> showAll(Criteria criteria);
    //    전체 개수
    public int getTotal();
}


