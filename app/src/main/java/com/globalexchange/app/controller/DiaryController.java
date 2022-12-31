package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.service.DiaryObjectificationService;
import com.globalexchange.app.service.DiaryService;
import com.globalexchange.app.service.MemberObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/diary/*")
public class DiaryController {
    private final DiaryService diaryService;
    private final MemberObjectificationService memberObjectificationService;

    // 일기 목록 페이지
    @GetMapping("/list")
    public void list(HttpServletRequest request, Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }

//        model.addAttribute("members", diaryService.showAllPartner(criteria));
        model.addAttribute("diaries", diaryService.showAll(criteria));
//        model.addAttribute("diary", diaryService.show(diaryNumber));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, diaryService.getTotal()));
//        if(request.getSession().getAttribute("memberNumber") != null){
//            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
////            Long diaryPartnerNumber = (Long)request.getSession().getAttribute("diaryPartnerNumber");
////            model.addAttribute("partner", memberObjectificationService.show(diaryPartnerNumber));
//            model.addAttribute("member", memberObjectificationService.show(memberNumber));
//            log.info("멤버넘버: "+memberNumber);
////            log.info("파트너넘버: "+diaryPartnerNumber);
//        }

        if(request.getSession().getAttribute("memberNumber") != null){
            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
            model.addAttribute("diaries", diaryService.myDiarySelectAll(criteria, memberNumber));
            model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, diaryService.myDiaryGetTotal(memberNumber)));
            model.addAttribute("partners", diaryService.showPartner(memberNumber));
            log.info("멤버넘버: "+memberNumber);
        }


    }
    @GetMapping("/categoryList")
    public void categoryList(HttpServletRequest request, Criteria criteria, Model model, Long diaryPartnerNumber){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        if(request.getSession().getAttribute("memberNumber") != null){
            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
            model.addAttribute("diaries", diaryService.myPartnerSelectAll(memberNumber, diaryPartnerNumber, criteria));
            model.addAttribute("diaryPartnerNumber", diaryPartnerNumber);
//        model.addAttribute("diary", diaryService.show(diaryNumber));
            model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, diaryService.categoryGetTotal(memberNumber, diaryPartnerNumber)));
            model.addAttribute("partners", diaryService.showPartner(memberNumber));
            log.info("멤버DTO"+diaryService.myPartnerSelectAll(memberNumber, diaryPartnerNumber, criteria));
        }
//        model.addAttribute("members", diaryService.showAllPartner(criteria));

    }

    @GetMapping("/listWrittenByPartner")
    public void listWrittenByPartner(HttpServletRequest request, Long diaryNumber, Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        if(request.getSession().getAttribute("memberNumber") != null){
            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
            model.addAttribute("diaries", diaryService.toMeDiarySelectAll(criteria, memberNumber));
            model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, diaryService.toMeDiaryGetTotal(memberNumber)));
            model.addAttribute("partners", diaryService.showPartner(memberNumber));
        }
    }

    @GetMapping("/categoryListWrittenByPartner")
    public void categoryListWrittenByPartner(HttpServletRequest request, Criteria criteria, Model model, Long diaryPartnerNumber){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        if(request.getSession().getAttribute("memberNumber") != null){
            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
            model.addAttribute("diaries", diaryService.toMeFromPartnerDiarySelectAll(criteria, memberNumber, diaryPartnerNumber));
            model.addAttribute("diaryPartnerNumber", diaryPartnerNumber);
            model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, diaryService.toMeFromPartnerDiaryGetTotal(memberNumber, diaryPartnerNumber)));
            model.addAttribute("partners", diaryService.showPartner(memberNumber));
        }

    }

    // 일기 상세 페이지, 일기 수정 페이지
    @GetMapping(value={"/detail", "/update"})
    public void detail(HttpServletRequest request, Long diaryNumber, Criteria criteria, Model model){
        model.addAttribute("diary", diaryService.show(diaryNumber));
        if(request.getSession().getAttribute("memberNumber") != null){
            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
            model.addAttribute("member", memberObjectificationService.getMypageProfile(memberNumber));
        }

    }

    @GetMapping(value={"/detailWrittenByPartner", "/updateWrittenByPartner"})
    public void detailWrittenByPartner(HttpServletRequest request, Long diaryNumber, Criteria criteria, Model model){
        model.addAttribute("diary", diaryService.showWrittenByPartner(diaryNumber));
        if(request.getSession().getAttribute("memberNumber") != null){
            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
            model.addAttribute("member", memberObjectificationService.getMypageProfile(memberNumber));
        }
    }

//    @GetMapping(value={"/updateWrittenByPartner"})
//    public void updateWrittenByPartner(HttpServletRequest request, Long memberNumber, Long diaryNumber, Criteria criteria, Model model){
//        model.addAttribute("diary", diaryService.showWrittenByPartner(diaryNumber));
//    }


    // 일기 작성 페이지 이동
    @GetMapping("/write")
    public void write(HttpServletRequest request, Model model, Long memberNumber){

        model.addAttribute("diary", new DiaryVO());

//        model.addAttribute("members", diaryService.showPartner(memberNumber));
//        model.addAttribute("member", memberObjectificationService.show(memberNumber));
        if(request.getSession().getAttribute("memberNumber") != null){
            Long member = (Long) request.getSession().getAttribute("memberNumber");
            log.info("멤버:"+member);
            model.addAttribute("members", diaryService.showPartner(member));
            model.addAttribute("member", memberObjectificationService.show(member));
            log.info("파트너:"+diaryService.showPartner(member));
        }
    }

    // 일기 작성 완료
    @PostMapping("/write")
    public RedirectView write(HttpServletRequest request, DiaryDTO diaryDTO, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("diaryNumber", diaryDTO.getDiaryNumber());
//        log.info("날짜 출력:"+diaryDTO.getDiaryWriteDate());
        if(request.getSession().getAttribute("memberNumber") != null){
            Long member = (Long) request.getSession().getAttribute("memberNumber");
            diaryDTO.setMemberNumber(member);
            diaryService.register(diaryDTO);
//            log.info("멤버:"+member);
//            model.addAttribute("members", diaryService.showPartner(member));
//            model.addAttribute("member", memberObjectificationService.show(member));
//            log.info("파트너:"+diaryService.showPartner(member));
        }
        return new RedirectView("/diary/list");
    }

    // 일기 수정 활성화
//    @GetMapping("/update")
//    public void update(){
//    }

    // 일기 수정 완료
    @PostMapping("/update")
    public RedirectView update(DiaryDTO diaryDTO, RedirectAttributes redirectAttributes){
        diaryService.modify(diaryDTO);
        redirectAttributes.addAttribute("diaryNumber", diaryDTO.getDiaryNumber());
        return new RedirectView("/diary/detail");
    }

    // 일기 삭제
    @GetMapping("/delete")
    public RedirectView delete(Long diaryNumber){
        diaryService.remove(diaryNumber);
        return new RedirectView("/diary/list");
    }

    @PostMapping("/updateWrittenByPartner")
    public RedirectView updateWrittenByPartner(DiaryDTO diaryDTO, RedirectAttributes redirectAttributes){
        diaryService.modify(diaryDTO);
        redirectAttributes.addAttribute("diaryNumber", diaryDTO.getDiaryNumber());
        return new RedirectView("/diary/detailWrittenByPartner");
    }

    // 일기 코멘트 작성
    @GetMapping("/commentWrite")
    public void commentWrite(){

    }

    // 일기 코멘트 작성 완료
    @GetMapping("/commentWriteOk")
    public void commentWriteOk(){

    }

    // 일기 코멘트 수정 활성화
    @GetMapping("/commentUpdate")
    public void commentUpdate(){

    }

    // 일기 코멘트 수정 완료
    @GetMapping("/commentUpdateOk")
    public void commentUpdateOk(){

    }

    // 일기 코멘트삭제
    @GetMapping("/CommentRemove")
    public void CommentRemove(){

    }

    //교환일기 파트너 리스트 이동
    @GetMapping("/partnerList")
    public void diaryPartnerList(Criteria criteria, Model model){

        if(criteria.getPage() == 0){
            criteria.create(1, 16, "ALL");
        }
        model.addAttribute("members", diaryService.showAllPartner(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, diaryService.getTotal(criteria)));
    }

    // 파트너 상세 페이지
    @GetMapping("/partnerDetail")
    public void partnerDetail(Long memberNumber, Criteria criteria, Model model){
        model.addAttribute("partner", diaryService.showPartnerDetail(memberNumber));
    }

    // 파트너 등록
    @GetMapping("/partnerApply")
    public RedirectView partnerApply(Long memberNumber, Long diaryPartnerNumber){

        if(diaryService.diaryPartnerCheck(memberNumber, diaryPartnerNumber) == 0) {
            diaryService.registerPartner(memberNumber, diaryPartnerNumber);
        }

        return new RedirectView("/diary/list");
    }

    // 파트너 신고
    @GetMapping("/partnerReport")
    public RedirectView report(Long reportingMemberNumber, Long reportedMemberNumber){

        diaryService.registerReport(reportingMemberNumber, reportedMemberNumber);

        return new RedirectView("/diary/list");
    }
}
