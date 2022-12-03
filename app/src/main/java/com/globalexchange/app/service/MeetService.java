package com.globalexchange.app.service;

//import com.example.app.domain.vo.BoardDTO;
//import com.example.app.domain.vo.BoardVO;
//import com.example.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeetService {
    
    //조회
    public List<MeetVO> meetSelectAll(Criteria criteria);
    //전체 개수
    public int getTotal();
    //카테고리별 조회
    public List<MeetVO> categoryMeetSelectAll(Criteria criteria, String meetLearningLang);
    //카테고리별 게시글 갯수
    public int categoryGetTotal(String meetLearningLang);
    //작성자 정보 가져오기
    public MemberVO writerInfo(Long memberNumber);
    //작성자 프로필 이미지 가져오기
    public FileProfileVO getMeetWriterImage(Long memberNumber);
    //    추가
   public void insertMeetBody(MeetDTO meetDTO);
   // meet 게시글 detail 정보 불러오기
    public MeetDTO detailMeetBody(Long meetNumber);
    //meet 게시글 수정페이지에서 글과 작성자 정보 불러오기
    public MeetDTO goModifyPage (Long meetNumber);
    //meet 게시글 수정완료해서 글은 디비에 넣고, 원래있던 디비파일정보삭제하고(수정페이지에 원래있던 파일정보를 주는게 아니라서 파일번호모름) 디비파일정보 새로 넣음
    public void updateMeetBody(MeetDTO meetDTO);
    //meet 게시글 삭제
    public void deleteMeetBody(Long meetNumber);
    //meet 답글 목록 보여주면서 페이지네이션
    public List<MeetAnswerDTO> meetAnswerSelectAll(Long meetNumber, Criteria criteria);
    //meet 답글 갯수 세기
    public long meetAnswerCount(Long meetNumber);
    //meet 답글 업데이트
    public void  meetAnswerUpdate(MeetAnswerVO meetAnswerVO);
    //meet 답글 쓰기 인서트
    public void meetAnswerInsert(MeetAnswerVO meetAnswerVO);
    //meet 답글 댓글 개수 목록 뿌리기
    public List<MeetAnswerCommentDTO> meetAnswerCommentSelectAll (Long meetAnswerNumber);
    //meet 답글 삭제
     public void meetAnswerRemove(Long meetAnswerNumber);

//    //    수정
//    public void modify(BoardDTO boardDTO);
//    //    삭제
//    public void remove(Long boardNumber);
//    //    조회
//    public BoardDTO show(Long boardNumber);
//    //    전체 조회
//    public List<BoardVO> showAll(Criteria criteria);
////    전체 개수
//    public int getTotal();
}


