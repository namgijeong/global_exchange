package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.service.MeetObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
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
    //모달창을 선택하여 골랐을때
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
    public void detail(Long meetNumber,Model model){
        MeetDTO meetDTO=meetObjectificationService.detailMeetBody(meetNumber);
        log.info(""+meetDTO.getFileMeetVO());
        log.info(""+meetDTO.getFileProfileVO());
        model.addAttribute("meetDTO",meetDTO);

    }

    // 만남과 도움 작성 페이지 이동
    @GetMapping("/write")
    public String write(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Long memberNumber=(Long)session.getAttribute("memberNumber");

        if(memberNumber==null){
            //memberVO.setMemberNickname("존재하지 않는 회원");
            //return "/member/login";


            MemberVO memberVO;
            FileProfileVO fileProfileVO;
            memberVO=meetObjectificationService.writerInfo(1L);

            fileProfileVO=meetObjectificationService.getMeetWriterImage(1L);

            session.setAttribute("memberNumber",1L);
            model.addAttribute("memberVO",memberVO);
            model.addAttribute("file",fileProfileVO);
            return "/meetingAndHelp/write";
        }

        MemberVO memberVO;
        FileProfileVO fileProfileVO;
        memberVO=meetObjectificationService.writerInfo(memberNumber);
        fileProfileVO=meetObjectificationService.getMeetWriterImage(memberNumber);

        model.addAttribute("memberVO",memberVO);
        model.addAttribute("file",fileProfileVO);
        return "/meetingAndHelp/write";

    }

    // 만남과 도움 작성 페이지 완료
    @PostMapping("/writeOk")
    public RedirectView writeOk(MeetDTO meetDTO){

        meetObjectificationService.insertMeetBody(meetDTO);
            
        return new RedirectView("/meetingAndHelp/list");
    }

    // 만남과 도움 수정 활성화
    @GetMapping("/writeUpdate")
    public String writeUpdate(Long meetNumber,Model model){
        MeetDTO meetDTO=meetObjectificationService.goModifyPage(meetNumber);
        log.info(""+meetDTO.getFileMeetVO());
        log.info(""+meetDTO.getFileProfileVO());
        model.addAttribute("meetDTO",meetDTO);

        return "/meetingAndHelp/writeUpdate";
    }

    // 만남과 도움 수정 완료
    @PostMapping("/writeUpdateOk")
    public RedirectView writeUpdateOk(MeetDTO meetDTO){
        meetObjectificationService.updateMeetBody(meetDTO);
        return new RedirectView("/meetingAndHelp/detail?meetNumber="+meetDTO.getMeetNumber());
    }

    // 만남과 도움 삭제
    @GetMapping("/writeRemove")
    public RedirectView writeRemove(Long meetNumber){
        meetObjectificationService.deleteMeetBody(meetNumber);
        return new RedirectView("/meetingAndHelp/list");
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
