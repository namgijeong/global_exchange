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

    // 만남과 도움 댓글 작성 완료
    @PostMapping("/commentWriteOk")
    public void answerCommentWriteOk(@RequestBody MeetAnswerCommentVO meetAnswerCommentVO,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long memberNumber=(Long)session.getAttribute("memberNumber");
        meetAnswerCommentVO.setMemberNumber(memberNumber);
        meetObjectificationService.meetCommentInsert(meetAnswerCommentVO);
    }

  /*  // 만남과 도움 댓글 수정 활성화
    @GetMapping("/commentUpdate")
    public void answerCommentUpdate(){

    }*/

    // 만남과 도움 댓글 수정 완료
    @PostMapping("/commentUpdateOk")
    public void answerCommentUpdateOk(@RequestBody MeetAnswerCommentVO meetAnswerCommentVO){
        //meet 댓글 코멘트 업데이트
        meetObjectificationService.meetCommentUpdate(meetAnswerCommentVO);
    }

    // 만남과 도움 댓글 삭제
    @GetMapping("/commentRemove/{meetAnswerCommentNumber}")
    public void answerCommentRemove(@PathVariable("meetAnswerCommentNumber") Long meetAnswerCommentNumber){

        meetObjectificationService.meetCommentRemove(meetAnswerCommentNumber);
    }

}
