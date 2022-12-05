package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import com.globalexchange.app.domain.vo.PageDTO;
import com.globalexchange.app.repository.NoticeDAO;
import com.globalexchange.app.service.AdminService;
import com.globalexchange.app.service.MainService;
import com.globalexchange.app.service.MemberService;
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

    // 멤버 리스트
    @GetMapping("/memberList")
    public void memberList(Criteria criteria, Model model) {
        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }

        model.addAttribute("members", adminService.showAllMember(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getTotalMember(criteria)));
    }

    // 멤버 상세보기
    @GetMapping("/memberDetail")
    public void memberDetail(Criteria criteria, Long memberNumber, Model model){
        model.addAttribute("member", adminService.showMemberDetail(memberNumber));
    }

    // 멤버 삭제
    @GetMapping("/memberDelete")
    public RedirectView memberDelete(Long memberNumber){
        adminService.removeMember(memberNumber);
        return new RedirectView("/admin/memberList");
    }

    // 만남과 도움 리스트
    @GetMapping("/meetList")
    public void meetList(Criteria criteria, Model model){
        if (criteria.getPage() == 0) {
            criteria.create(1, 10);
        }

        model.addAttribute("meets", adminService.showAllMeet(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminService.getTotalMeet()));
    }

    // 만남과 도움 상세보기
    @GetMapping("/meetDetail")
    public void meetDetail(Criteria criteria, Long meetNumber, Model model){
        model.addAttribute("meet", adminService.showMeetDetail(meetNumber));
    }

    // 만남과 도움 삭제
    @GetMapping("/meetDelete")
    public RedirectView meetDelete(Long meetNumber){
        adminService.removeMeet(meetNumber);
        return new RedirectView("/admin/meetList");
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
    public void noticeDetail(Criteria criteria, Long noticeNumber, Model model) {
        model.addAttribute("notice", adminService.show(noticeNumber));
    }

    // 공지사항 수정
    @PostMapping("/noticeUpdate")
    public RedirectView noticeUpdate(NoticeVO noticeVO, RedirectAttributes redirectAttributes) {
        adminService.modify(noticeVO);
        redirectAttributes.addAttribute("noticeNumber", noticeVO.getNoticeNumber());
        return new RedirectView("/admin/noticeDetail");
    }

    // 공지사항 삭제
    @GetMapping("/noticeDelete")
    public RedirectView noticeDelete(Long noticeNumber) {
        adminService.remove(noticeNumber);
        return new RedirectView("/admin/noticeList");
    }

    // 공지사항 작성 페이지
    @GetMapping("/noticeWrite")
    public void noticeWrite(Model model) {
        model.addAttribute("notice", new NoticeVO());
    }

    // 공지사항 작성
    @PostMapping("/noticeWrite")
    public RedirectView noticeWrite(NoticeVO noticeVO) {
        adminService.register(noticeVO);
        return new RedirectView("/admin/noticeList");
    }
}