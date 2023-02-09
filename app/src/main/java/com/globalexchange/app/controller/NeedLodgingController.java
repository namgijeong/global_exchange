package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.service.LodgingObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/needLodging/*")
@RequiredArgsConstructor
@Slf4j
public class NeedLodgingController {
    private final LodgingObjectificationService lodgingObjectificationService;

    // 숙소가 필요해 목록 페이지
    @GetMapping("/list")
    public void list(HttpServletRequest request,Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }

            model.addAttribute("boards", lodgingObjectificationService.lodgingSelectAll(criteria));
            model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, lodgingObjectificationService.getTotal()));

    }

    // 모달창을 선택하여 골랐을때
    @GetMapping("/categorylist")
    public void categorylist(Criteria criteria, String nation2, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("nation2", nation2);
        model.addAttribute("boards", lodgingObjectificationService.categoryLodgingSelectAll(criteria,nation2));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria,lodgingObjectificationService.categoryGetTotal(nation2)));
        log.info("" + lodgingObjectificationService.categoryLodgingSelectAll(criteria,nation2));
    }

    // 숙소가 필요해 상세 페이지
    @GetMapping("/detail")
    public void detail(Long lodgingNumber, Model model){

        LodgingDTO lodgingDTO = lodgingObjectificationService.detailLodgingBody(lodgingNumber);
        Long answerCount = lodgingObjectificationService.lodgingAnswerCount(lodgingNumber);
        model.addAttribute("lodgingDTO",lodgingDTO);
        model.addAttribute("answerCount",answerCount);

    }

    // 숙소가 필요해 작성 페이지
    @GetMapping("/write")
    public String write(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Long memberNumber = (Long)session.getAttribute("memberNumber");


        MemberVO memberVO;
        FileProfileVO fileProfileVO;
        memberVO = lodgingObjectificationService.writerInfo(memberNumber);
        fileProfileVO = lodgingObjectificationService.getMeetWriterImage(memberNumber);

        model.addAttribute("memberVO", memberVO);
        model.addAttribute("file",fileProfileVO);

        return "/needLodging/write";
    }

    // 숙소가 필요해 작성 페이지 완료
    @PostMapping("/writeOk")
    public RedirectView writeOk(LodgingDTO lodgingDTO){

        log.info("1111"+ lodgingDTO);
        lodgingObjectificationService.insertLodgingBody(lodgingDTO);
        return new RedirectView("/needLodging/list");
    }

    // 숙소가 필요해 수정 페이지 이동
    @GetMapping("/writeUpdate")
    public void writeUpdate(Long lodgingNumber,Model model){
        LodgingDTO lodgingDTO = lodgingObjectificationService.goModifyPage(lodgingNumber);
        model.addAttribute("lodgingDTO",lodgingDTO );
    }

    // 숙소가 필요해 수정 완료
    @PostMapping("/writeUpdateOk")
    public RedirectView writeUpdateOk(LodgingDTO lodgingDTO){
        lodgingObjectificationService.updateLodgingBody(lodgingDTO);
        return new RedirectView("/needLodging/detail?lodgingNumber=" + lodgingDTO.getLodgingNumber());
    }

    // 숙소가 필요해 삭제
    @GetMapping("/writeRemove")
    public RedirectView writeRemove(Long lodgingNumber){
        lodgingObjectificationService.deleteRequest(lodgingNumber);
        return new RedirectView("/needLodging/list");
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
