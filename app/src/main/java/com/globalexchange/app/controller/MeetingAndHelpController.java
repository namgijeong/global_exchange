package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.PageDTO;
import com.globalexchange.app.service.MeetObjectificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/meetingAndHelp/*")
public class MeetingAndHelpController {
    private final MeetObjectificationService meetObjectificationService;
    // 만남과 도움 목록 페이지
    @GetMapping("/list")
    public void list(Criteria criteria, Model model){

        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("boards",  meetObjectificationService.meetSelectAll(criteria));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, meetObjectificationService.getTotal()));
    }
    @GetMapping("/categorylist")
    public void categorylist(Criteria criteria,  String nation2, Model model){

        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("nation2",nation2);
        model.addAttribute("boards",  meetObjectificationService.categoryMeetSelectAll(criteria,nation2));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, meetObjectificationService.categoryGetTotal(nation2)));
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

    // 만남과 도움 수정 활성화
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

//    // 만남과 도움 답글 쓰기 페이지 이동
//    @GetMapping("/answerWrite")
//    public void answerWrite(){
//
//    }

    // 만남과 도움 답글 쓰기 완료
    @GetMapping("/answerWriteOk")
    public void answerWriteOk(){

    }

    // 만남과 도움 답글 수정 활성화
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

//    // 만남과 도움 댓글 작성 페이지 이동
//    @GetMapping("/answerCommentWrite")
//    public void answerCommentWrite(){
//
//    }

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
