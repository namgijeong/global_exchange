package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
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
    public List<DiaryDTO> showAll(Criteria criteria);
    //    전체 개수
    public int getTotal();

    // 파트너 리스트 조회
    public List<MemberDTO> showAllPartner(Criteria criteria);

    // 파트너 수 조회
    public int getTotal(Criteria criteria);

    // 파트너 상세 정보 조회
    public MemberDTO showPartnerDetail(Long memberNumber);
}


