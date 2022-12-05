package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeetMapper {
    public List<MeetVO> meetSelectAll(Criteria criteria);
    public List<MeetVO> categoryMeetSelectAll(@Param("criteria") Criteria criteria, @Param("meetLearningLang") String meetLearningLang);
    public int getTotal();
    public int categoryGetTotal(String meetLearningLang);
    //작성자 정보 가져오기
    public MemberVO writerInfo(Long memberNumber);
    //meet 게시글 등록
    public void insertRequest(MeetDTO meetDTO);
    //meet 게시글 detail 이동
    public MeetVO selectMeetRequest(Long meetNumber);
    //meet 게시글 update
    public void updateRequest(MeetDTO meetDTO);
    //meet 게시글 delete
    public void deleteRequest(Long meetNumber);
    //meet 답글 select 페이지네이션
    public List<MeetAnswerVO> meetAnswerSelectAll(@Param("meetNumber") Long meetNumber, @Param("criteria") Criteria criteria);
    //meet 답글 갯수 세기
    public long meetAnswerCount(Long meetNumber);
    //meet 답글 업데이트
    public void  meetAnswerUpdate(MeetAnswerVO meetAnswerVO);
    //meet 답글 쓰기 인서트
    public void meetAnswerInsert(MeetAnswerVO meetAnswerVO);
    //meet 답글 코멘트 전체 불러오기
    public List<MeetAnswerCommentVO> meetAnswerCommentSelectAll (Long meetAnswerNumber);
    //meet 답글 삭제
    public void meetAnswerRemove(Long meetAnswerNumber);
    //meet 댓글 코멘트 등록
    public void meetCommentInsert(MeetAnswerCommentVO meetAnswerCommentVO);
    //meet 댓글 코멘트 업데이트
    public void meetCommentUpdate(MeetAnswerCommentVO meetAnswerCommentVO);
    //meet 댓글 코멘트 삭제
    public void meetCommentRemove(Long meetAnswerCommentNumber);

    // 답글이 없는 최신글 조회
    public List<MeetVO> selectAllLatestNotAnsweredMeet(Criteria criteria);

    // 답글이 있는 최신글 조회
    public List<MeetVO> selectAllLatestAnsweredMeet(Criteria criteria);

}
