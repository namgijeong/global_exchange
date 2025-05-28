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
@RequestMapping("/meetingAndHelpAnswer/*")
public class MeetingAndHelpAnswerController {
    private final MeetObjectificationService meetObjectificationService;

    // 만남과 도움 답글 목록 뿌려주기위해 데이터 전송
    @GetMapping("/list/{meetNumber}/{page}")
    public MeetAnswerPagenationDTO list(@PathVariable("meetNumber") Long meetNumber, @PathVariable int page){
         List<MeetAnswerDTO> meetAnswerDTO=meetObjectificationService.meetAnswerSelectAll(meetNumber, new Criteria().create(page, 2));
         long meetAnswerCount=meetObjectificationService.meetAnswerCount(meetNumber);
        MeetAnswerPagenationDTO meetAnswerPagenationDTO = new MeetAnswerPagenationDTO();
        meetAnswerPagenationDTO.setMeetAnswerCount(meetAnswerCount);
        meetAnswerPagenationDTO.setMeetAnswerDTOList(meetAnswerDTO);

        return meetAnswerPagenationDTO;
    }


//    // 만남과 도움 답글 쓰기 페이지 이동
//    @GetMapping("/answerWrite")
//    public void answerWrite(){
//
//    }

    // 만남과 도움 답글 쓰기 완료
    //클라이언트에서 서버로 필요한 데이터를 요청하기 위해 JSON 데이터를 요청 본문에 담아서 서버로 보내면, 서버에서는 @RequestBody 어노테이션을 사용하여 HTTP 요청 본문에 담긴 값들을 자바객체로 변환시켜, 객체에 저장한다.
    //서버에서 클라이언트로 응답 데이터를 전송하기 위해 @ResponseBody 어노테이션을 사용하여 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송한다.
    @PostMapping("/answerWriteOk")
    public void answerWriteOk(@RequestBody MeetAnswerVO meetAnswerVO , HttpServletRequest request){
        //로그인한 멤버정보를 vo에 같이 담아서 보내준다.
        log.info("answerwriteok컨트롤러들어옴"+meetAnswerVO);
        HttpSession session = request.getSession();
        Long memberNumber=(Long)session.getAttribute("memberNumber");
        meetAnswerVO.setMemberNumber(memberNumber);
        meetObjectificationService.meetAnswerInsert(meetAnswerVO);
    }

/*
    // 만남과 도움 답글 수정 활성화
    @GetMapping("/answerUpdate")
    public void answerUpdate(){

    }*/

    // 만남과 도움 답글 수정 완료
    @PostMapping("/answerUpdateOk")
    public void answerUpdateOk(@RequestBody MeetAnswerVO meetAnswerVO){
        //long meetAnswerNumber=meetAnswerVO.getMeetAnswerNumber();
        //String meetAnswerContent=meetAnswerVO.getMeetAnswerContent();
        log.info("수정완료 컨트롤러들어옴"+meetAnswerVO);
        meetObjectificationService.meetAnswerUpdate(meetAnswerVO);

    }

    // 만남과 도움 답글 삭제

    @GetMapping("/answerRemove/{meetAnswerNumber}")
    public void answerRemove(@PathVariable("meetAnswerNumber") Long meetAnswerNumber){
        meetObjectificationService.meetAnswerRemove(meetAnswerNumber);
    }



}
