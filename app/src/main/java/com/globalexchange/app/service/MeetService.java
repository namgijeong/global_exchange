package com.globalexchange.app.service;

//import com.example.app.domain.vo.BoardDTO;
//import com.example.app.domain.vo.BoardVO;
//import com.example.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.MeetVO;
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
//    //    추가
//    public void register(BoardDTO boardDTO);
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


