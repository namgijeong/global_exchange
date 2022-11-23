package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meetingAndHelp/*")
public class MeetingAndHelpController {

    // 만남과 도움 목록 페이지
    @GetMapping("/list")
    public void list(){

    }

    // 만남과 도움 상세 페이지
    @GetMapping("/detail")
    public void detail(){

    }

    // 만남과 도움 작성 페이지 이동
    @GetMapping("/write")
    public void write(){

    }

    // 만남과 도움 작성 페이지 완료
    @GetMapping("/writeOk")
    public void writeOk(){

    }

    // 만남과 도움 수정 페이지 이동
    @GetMapping("/writeUpdate")
    public void writeUpdate(){

    }

    // 만남과 도움 수정 완료
    @GetMapping("/writeUpdateOk")
    public void writeUpdateOk(){

    }

    // 만남과 도움 삭제
    @GetMapping("/writeRemove")
    public void writeRemove(){

    }

    // 만남과 도움 답글 쓰기 페이지 이동
    @GetMapping("/answerWrite")
    public void answerWrite(){

    }

    // 만남과 도움 답글 쓰기 완료
    @GetMapping("/answerWriteOk")
    public void answerWriteOk(){

    }

    // 만남과 도움 답글 수정 페이지 이동
    @GetMapping("/answerUpdate")
    public void answerUpdate(){

    }

    // 만남과 도움 답글 수정 완료
    @GetMapping("/answerUpdateOk")
    public void answerUpdateOk(){

    }

    // 만남과 도움 답글 삭제
    @GetMapping("/answerRemove")
    public void answerRemove(){

    }

    // 만남과 도움 댓글 작성 페이지 이동
    @GetMapping("/answerCommentWrite")
    public void answerCommentWrite(){

    }

    // 만남과 도움 댓글 작성 완료
    @GetMapping("/answerCommentWriteOk")
    public void answerCommentWriteOk(){

    }

    // 만남과 도움 댓글 수정 페이지 이동
    @GetMapping("/answerCommentUpdate")
    public void answerCommentUpdate(){

    }

    // 만남과 도움 댓글 수정 완료
    @GetMapping("/answerCommentUpdateOk")
    public void answerCommentUpdateOk(){

    }

    // 만남과 도움 댓글 삭제
    @GetMapping("/answerCommentRemove")
    public void answerCommentRemove(){

    }

}
