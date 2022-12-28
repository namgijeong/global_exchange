package com.globalexchange.app.repository;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.mapper.DiaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DiaryDAO {
  private final DiaryMapper diaryMapper;
  //    추가
  public void save(DiaryDTO diaryDTO){
    diaryMapper.diaryInsert(diaryDTO);
  }
  //    수정
  public void setDiaryVO(DiaryDTO diaryDTO){
    diaryMapper.diaryUpdate(diaryDTO);
  }
  //    삭제
  public void remove(Long diaryNumber){
    diaryMapper.diaryDelete(diaryNumber);
  }
  //    조회
  public DiaryVO findById(Long diaryNumber){
    return diaryMapper.diarySelect(diaryNumber);
  }
  //    전체 조회
  public List<DiaryDTO> findAll(Criteria criteria){
    return diaryMapper.diarySelectAll(criteria);
  }

  // 내가 쓴 일기 전체 조회
  public List<DiaryDTO> myDiarySelectAll(Criteria criteria, Long memberNumber){
    return diaryMapper.myDiarySelectAll(criteria, memberNumber);
  }
  // 나와 특정 파트너의 일기 내용
  public List<DiaryDTO> myPartnerSelectAll(Long memberNumber, Long diaryPartnerNumber, Criteria criteria) {
    return diaryMapper.myPartnerSelectAll(memberNumber, diaryPartnerNumber, criteria);
  }

  //  파트너가 나에게 쓴 일기 전체 조회
  public List<DiaryDTO> toMeDiarySelectAll(Criteria criteria, Long memberNumber){
    return diaryMapper.toMeDiarySelectAll(criteria, memberNumber);
  }
  //  특정 파트너가 나에게 쓴 일기 전체 조회
  public List<DiaryDTO> toMeFromPartnerDiarySelectAll(Criteria criteria, Long memberNumber, Long diaryPartnerNumber){
    return diaryMapper.toMeFromPartnerDiarySelectAll(criteria, memberNumber, diaryPartnerNumber);
  }

  //    전체 개수
  public int findCountAll(){
    return diaryMapper.getTotal();
  }

  // 내가 쓴 일기 전체 개수
  public int myDiaryGetTotal(Long memberNumber){
    return diaryMapper.myDiaryGetTotal(memberNumber);
  }

  // 나와 특정 파트너의 일기 수
  public int categoryGetTotal(Long memberNumber, Long diaryPartnerNumber){
    return diaryMapper.categoryGetTotal(memberNumber, diaryPartnerNumber);
  }

  //  파트너가 나에게 쓴 일기 전체 개수
  public int toMeDiaryGetTotal(Long memberNumber){
    return diaryMapper.toMeDiaryGetTotal(memberNumber);
  }
  //  특정 파트너가 나에게 쓴 일기 전체 개수
  public int toMeFromPartnerDiaryGetTotal(Long memberNumber, Long diaryPartnerNumber){
    return diaryMapper.toMeFromPartnerDiaryGetTotal(memberNumber, diaryPartnerNumber);
  }


  //    파트너 조회
  public List<Long> findPartner(Long memberNumber){
    return diaryMapper.diaryPartnerSelect(memberNumber);
  }

  // 파트너 신청
  public void saveDiaryPartner(Long memberNumber, Long diaryPartnerNumber){
    diaryMapper.diaryPartnerInsert(memberNumber, diaryPartnerNumber);
  }

  // 파트너 유무 확인
  public int diaryPartnerCheck(Long memberNumber, Long diaryPartnerNumber){
    return diaryMapper.diaryPartnerCheck(memberNumber, diaryPartnerNumber);
  }


}
