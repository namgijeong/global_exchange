package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.service.DiaryService;
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

    // 일기 목록 페이지
    @GetMapping("/list")
    public void list(Long diaryNumber, Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("diaries", diaryService.showAll(criteria));
//        model.addAttribute("diary", diaryService.show(diaryNumber));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, diaryService.getTotal()));
    }

    // 일기 상세 페이지, 일기 수정 페이지
    @GetMapping(value={"/detail", "/update"})
    public void detail(Long diaryNumber, Criteria criteria, Model model){
        model.addAttribute("diary", diaryService.show(diaryNumber));
    }

    // 일기 작성 페이지 이동
    @GetMapping("/write")
    public void write(HttpServletRequest request, Model model){
        model.addAttribute("memberId", request.getSession().getAttribute("memberId"));
        model.addAttribute("diary", new DiaryVO());
    }

    // 일기 작성 완료
    @PostMapping("/write")
    public RedirectView write(DiaryDTO diaryDTO, RedirectAttributes redirectAttributes){
        diaryService.register(diaryDTO);
        redirectAttributes.addFlashAttribute("diaryNumber", diaryDTO.getDiaryNumber());
//        log.info("날짜 출력:"+diaryDTO.getDiaryWriteDate());
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

//    // 일기 코멘트 작성
//    @GetMapping("/commentWrite")
//    public void commentWrite(){
//
//    }

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
}
