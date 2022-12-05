package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import com.globalexchange.app.domain.vo.PageDTO;
import com.globalexchange.app.repository.NoticeDAO;
import com.globalexchange.app.service.AdminService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // 관리자 멤버 리스트 페이지
    @GetMapping("/memberList")
    public void memberList(HttpServletRequest request){
    }

    // 공지사항 리스트 페이지
    @GetMapping("/noticeList")
    public void noticeList(Criteria criteria, Model model) {

        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }

        model.addAttribute("notices", adminService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getTotal()));
    }

    // 공지사항 상세보기 페이지
    // 공지사항 수정 페이지
    @GetMapping(value = {"/noticeDetail", "/noticeUpdate"})
    public void noticeDetail(Criteria criteria, Long noticeNumber, Model model){
        model.addAttribute("notice", adminService.show(noticeNumber));
    }

    // 공지사항 수정
    @PostMapping("/noticeUpdate")
    public RedirectView noticeUpdate(NoticeVO noticeVO, RedirectAttributes redirectAttributes){
        adminService.modify(noticeVO);
        redirectAttributes.addAttribute("noticeNumber", noticeVO.getNoticeNumber());
        return new RedirectView("/admin/noticeDetail");
    }

    // 공지사항 삭제
    @GetMapping("/noticeDelete")
    public RedirectView noticeDelete(Long noticeNumber){
        adminService.remove(noticeNumber);
        return new RedirectView("/admin/noticeList");
    }

    // 공지사항 작성 페이지
    @GetMapping("/noticeWrite")
    public void noticeWrite(Model model){
        model.addAttribute("notice", new NoticeVO());
    }

    // 공지사항 작성
    @PostMapping("/noticeWrite")
    public RedirectView noticeWrite(NoticeVO noticeVO){
        adminService.register(noticeVO);
        return new RedirectView("/admin/noticeList");
    }

/*

    // 관리자 멤버 상세보기 페이지
    @GetMapping("/memberDetail")
    public void memberDetail(){

    }

    // 관리자 멤버 삭제
    @GetMapping("/memberRemove")
    public void memberRemove(){

    }

    // 관리자 만남과 도움 리스트 페이지
    @GetMapping("/meetingAndHelpList")
    public void meetingAndHelpList(){

    }

    // 관리자 만남과 도움 상세보기 페이지
    @GetMapping("/meetingAndHelpDetail")
    public void meetingAndHelpDetail(){

    }

    // 삭제
    @GetMapping("/meetingAndHelpRemove")
    public void meetingAndHelpRemove(){

    }

    // 관리자 숙소가 필요해 리스트 페이지
    @GetMapping("/needLodgingList")
    public void needLodgingList(){

    }

    // 관리자 숙소가 필요해 상세보기 페이지
    @GetMapping("/needLodgingDetail")
    public void needLodgingDetail(){

    }

    // 삭제
    @GetMapping("/needLodgingRemove")
    public void needLodgingRemove(){

    }*/
}
