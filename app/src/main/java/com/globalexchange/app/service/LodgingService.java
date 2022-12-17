package com.globalexchange.app.service;


import com.globalexchange.app.domain.vo.*;
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

    // 숙소가 필요해 상세보기
    public LodgingDTO detailLodgingBody(Long lodgingNumber);

    // 숙소가 필요해 댓글 갯수
    public Long lodgingAnswerCount(Long lodgingNumber);

    //작성자 정보 가져오기
    public MemberVO writerInfo(Long memberNumber);

    //작성자 프로필이미지 가져오기
    public FileProfileVO getMeetWriterImage(Long memberNumber);

    // lodging 게시글 추가
    public void insertLodgingBody(LodgingDTO lodgingDTO);

    // 수정하기 페이지 이동
    public LodgingDTO goModifyPage(Long lodgingNumber);

    // lodging 게시글 전체 update
    public void updateLodgingBody(LodgingDTO lodgingDTO);

    // lodging 게시글 delete
    public void deleteRequest(Long lodgingNumber);

    // lodging 답글 pageNation
    public List<LodgingAnswerDTO> lodgingAnswerSelectAll(Long lodgingNumber, Criteria criteria);

    // 숙소가 필요해 답글 수정
    public void lodgingAnswerUpdate(LodgingAnswerVO lodgingAnswerVO);

    // 숙소가 필요해 답글 추가
    public void lodgingAnswerInsert(LodgingAnswerVO lodgingAnswerVO);

    // 숙소가 필요해 답글 삭제
    public void lodgingAnswerRemove(Long lodgingAnswerNumber);

    //lodging 답글 코멘트 전체 불러오기
    public List<LodgingAnswerCommentDTO> lodgingAnswerCommentSelectAll(Long lodgingAnswerNumber);

    // lodging 댓글 추가
    public void lodgingCommentInsert(LodgingAnswerCommentVO lodgingAnswerCommentVO);

    // lodging 댓글 수정
    public void lodgingCommentUpdate(LodgingAnswerCommentVO lodgingAnswerCommentVO);

    // lodging 댓글 삭제
    public void lodgingCommentRemove(Long lodgingAnswerNumber);
}


