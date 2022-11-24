package com.globalexchange.app.service;

import org.springframework.stereotype.Service;

@Service
public interface NoticeService {
    //    추가
    public void register();
    //    수정
    public void modify();
    //    삭제
    public void remove(Long noticeNumber);
//    //    조회
//    public BoardDTO show(Long boardNumber);
//    //    전체 조회
//    public List<BoardVO> showAll();
//    전체 개수
    public int getTotal();
}


