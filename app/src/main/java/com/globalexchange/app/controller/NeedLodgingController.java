package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/needLodging/*")
public class NeedLodgingController {

    // 숙소가 필요해 상세 페이지
    @GetMapping("/detail")
    public void detail(){

    }

    // 숙소가 필요해 목록 페이지
    @GetMapping("/list")
    public void list(){

    }

    // 숙소가 필요해 작성 페이지
    @GetMapping("/write")
    public void write(){

    }

    // 숙소가 필요해 작성 페이지 완료
    @GetMapping("/writeOk")
    public void writeOk(){

    }

    // 숙소가 필요해 수정 페이지 이동
    @GetMapping("/writeUpdate")
    public void writeUpdate(){

    }

    // 숙소가 필요해 수정 완료
    @GetMapping("/writeUpdateOk")
    public void writeUpdateOk(){

    }

    // 숙소가 필요해 삭제
    @GetMapping("/writeRemove")
    public void writeRemove(){

    }

//    // 숙소가 필요해 답글 쓰기 페이지 이동
//    @GetMapping("/answerWrite")
//    public void answerWrite(){
//
//    }

    // 숙소가 필요해 답글 쓰기 완료
    @GetMapping("/answerWriteOk")
    public void answerWriteOk(){

    }

    // 숙소가 필요해 답글 수정 활성화
    @GetMapping("/answerUpdate")
    public void answerUpdate(){

    }

    // 숙소가 필요해 답글 수정 완료
    @GetMapping("/answerUpdateOk")
    public void answerUpdateOk(){

    }

    // 숙소가 필요해 답글 삭제
    @GetMapping("/answerRemove")
    public void answerRemove(){

    }

//    // 숙소가 필요해 댓글 작성 페이지 이동
//    @GetMapping("/answerCommentWrite")
//    public void answerCommentWrite(){
//
//    }

    // 숙소가 필요해 댓글 작성 완료
    @GetMapping("/answerCommentWriteOk")
    public void answerCommentWriteOk(){

    }

    // 숙소가 필요해 댓글 수정 활성화
    @GetMapping("/answerCommentUpdate")
    public void answerCommentUpdate(){

    }

    // 숙소가 필요해 댓글 수정 완료
    @GetMapping("/answerCommentUpdateOk")
    public void answerCommentUpdateOk(){

    }

    // 숙소가 필요해 댓글 삭제
    @GetMapping("/answerCommentRemove")
    public void answerCommentRemove(){

    }
}
