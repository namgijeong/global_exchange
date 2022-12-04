package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.DiaryVO;
import com.globalexchange.app.domain.vo.DiaryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
//    일기 추가
  public void diaryInsert(DiaryDTO diaryDTO);
//    일기 수정
  public void diaryUpdate(DiaryDTO diaryDTO);
//    일기 삭제
  public void diaryDelete(Long diaryNumber);
//    일기 조회
  public DiaryVO diarySelect(Long diaryNumber);
//    일기 전체 조회
  public List<DiaryDTO> diarySelectAll(Criteria criteria);
//    일기 전체 개수
  public int getTotal();
//    코멘트 추가

//    코멘트 수정

//    코멘트 삭제
  
//    코멘트 조회


}
