package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.service.MeetObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/meetingAndHelpComment/*")
public class MeetingAndHelpCommentController {
    private final MeetObjectificationService meetObjectificationService;

    // 만남과 도움 댓글 목록 뿌리기
    @GetMapping("/list/{meetAnswerNumber}")
    public List<MeetAnswerCommentDTO> answerCommentWrite(@PathVariable("meetAnswerNumber") Long meetAnswerNumber){
        log.info(""+ meetAnswerNumber);
        log.info("comment 컨트롤러들어옴");
        List<MeetAnswerCommentDTO> meetAnswerCommentDTOList=meetObjectificationService.meetAnswerCommentSelectAll(meetAnswerNumber);
        log.info(""+meetAnswerCommentDTOList);
        return meetAnswerCommentDTOList;
    }

    /*// 만남과 도움 댓글 작성 완료
    @GetMapping("/commentWriteOk")
    public void answerCommentWriteOk(){

    }

    // 만남과 도움 댓글 수정 활성화
    @GetMapping("/commentUpdate")
    public void answerCommentUpdate(){

    }

    // 만남과 도움 댓글 수정 완료
    @GetMapping("/commentUpdateOk")
    public void answerCommentUpdateOk(){

    }

    // 만남과 도움 댓글 삭제
    @GetMapping("/commentRemove")
    public void answerCommentRemove(){

    }*/

}
