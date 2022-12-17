package com.globalexchange.app.repository;
//

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.mapper.LodgingMapper;
import com.globalexchange.app.mapper.MeetMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//

//
@Repository
@RequiredArgsConstructor
public class LodgingDAO {
    private final LodgingMapper lodgingMapper;

    // 숙소가 필요해 리스트
    public List<LodgingVO> lodgingSelectAll(Criteria criteria){
        return lodgingMapper.lodgingSelectAll(criteria);
    }

    // 리스트 전체 갯수

    public int getTotal(){
        return lodgingMapper.getTotal();
    }

    // 리스트 카테고리
    public List<LodgingVO> categoryLodgingSelectAll(Criteria criteria,String lodgingLearningLang){
        return lodgingMapper.categoryLodgingSelectAll(criteria,lodgingLearningLang);
    }


    // 카테고리 게시글 전체 갯수

    public int categoryGetTotal(String lodgingLearningLang){
        return lodgingMapper.categoryGetTotal(lodgingLearningLang);
    }

    // 답글이 없는 최신글 조회
    public List<LodgingVO> findAllLatestNotAnsweredLodging(Criteria criteria){
        return lodgingMapper.selectAllLatestNotAnsweredLodging(criteria);
    }

    // 답글이 있는 최신글 조회
    public List<LodgingVO> findAllLatestAnsweredLodging(Criteria criteria){
        return lodgingMapper.selectAllLatestAnsweredLodging(criteria);
    }

    // 숙소가 필요해 상세보기
    public LodgingVO selectLodgingRequest(Long lodgingNumber){
        return  lodgingMapper.selectLodgingRequest(lodgingNumber);
    }

    // 숙소가 필요해 작성자 정보
    public MemberVO writerInfo(Long memberNumber){
        return  lodgingMapper.writerInfo(memberNumber);
    }

    // 숙소가 필요해 댓글 갯수
    public Long lodgingAnswerCount(Long lodgingNumber){
        return lodgingMapper.lodgingAnswerCount(lodgingNumber);
    }

    // lodging 게시글 등록
    public void insertRequest(LodgingDTO lodgingDTO){
        lodgingMapper.insertRequest(lodgingDTO);
    }

    // lodging 게시글 update
    public void updateRequest(LodgingDTO lodgingDTO){
        lodgingMapper.updateRequest(lodgingDTO);
    }

    // lodging 게시글 delete
    public void deleteRequest(Long lodgingNumber){
        lodgingMapper.deleteRequest(lodgingNumber);
    }

    // lodging 답글 pageNation
    public List<LodgingAnswerVO> lodgingAnswerSelectAll(Long lodgingNumber,Criteria criteria){
        return lodgingMapper.lodgingAnswerSelectAll(lodgingNumber,criteria);
    }

    // lodging 답글 수정
    public void lodgingAnswerUpdate(LodgingAnswerVO lodgingAnswerVO){
        lodgingMapper.lodgingAnswerUpdate(lodgingAnswerVO);
    }

    // lodging 답글 추가
    public void lodgingAnswerInsert(LodgingAnswerVO lodgingAnswerVO){
        lodgingMapper.lodgingAnswerInsert(lodgingAnswerVO);
    }

    // lodging 답글 삭제
    public void lodgingAnswerRemove(Long lodgingAnswerNumber){
        lodgingMapper.lodgingAnswerRemove(lodgingAnswerNumber);
    }

    // lodging 댓글 목록 뽑기
    public List<LodgingAnswerCommentVO> lodgingAnswerCommentSelectAll(Long lodgingAnswerNumber){
        return  lodgingMapper.lodgingAnswerCommentSelectAll(lodgingAnswerNumber);

    }
    // lodging 댓글 추가
    public void lodgingCommentInsert(LodgingAnswerCommentVO lodgingAnswerCommentVO){
        lodgingMapper.lodgingCommentInsert(lodgingAnswerCommentVO);
    }

    // lodging 댓글 수정
    public void lodgingCommentUpdate(LodgingAnswerCommentVO lodgingAnswerCommentVO){
        lodgingMapper.lodgingCommentUpdate(lodgingAnswerCommentVO);
    }

    // lodging 댓글 삭제
    public void lodgingCommentRemove(Long lodgingAnswerNumber){
        lodgingMapper.lodgingCommentRemove(lodgingAnswerNumber);
    }
}
