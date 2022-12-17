package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.*;
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

    // 숙소가 필요해 상세보기
    public LodgingVO selectLodgingRequest(Long lodgingNumber);

    // 숙소가 필요해 작성자 정보
    public MemberVO writerInfo(Long memberNumber);

    // 숙소가 필요해 댓글 갯수
    public Long lodgingAnswerCount(Long lodgingNumber);

    // lodging 게시글 등록
    public void insertRequest(LodgingDTO lodgingDTO);

    // lodging 게시글 update
    public void updateRequest(LodgingDTO lodgingDTO);

    // lodging 게시글 delete
    public void deleteRequest(Long lodgingNumber);

    // lodging 답글 pageNation
    public List<LodgingAnswerVO> lodgingAnswerSelectAll(@Param("lodgingNumber") Long lodgingNumber, @Param("criteria") Criteria criteria);
    
    // lodging 답글 수정
    public void lodgingAnswerUpdate(LodgingAnswerVO lodgingAnswerVO);

    // lodging 답글 추가
    public void lodgingAnswerInsert(LodgingAnswerVO lodgingAnswerVO);

    // lodging 답글 삭제
    public void lodgingAnswerRemove(Long lodgingAnswerNumber);

    // lodging 댓글 목록 뽑기
    public List<LodgingAnswerCommentVO> lodgingAnswerCommentSelectAll(Long lodgingAnswerNumber);

    // lodging 댓글 추가
    public void lodgingCommentInsert(LodgingAnswerCommentVO lodgingAnswerCommentVO);

    // lodging 댓글 수정
    public void lodgingCommentUpdate(LodgingAnswerCommentVO lodgingAnswerCommentVO);

    // lodging 댓글 삭제
    public void lodgingCommentRemove(Long lodgingAnswerNumber);
    
}
